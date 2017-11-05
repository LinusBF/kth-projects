/**
 * Created by Linus on 2017-11-01.
 */

function update_fields(ex, q, correct, incorrect, not_answered){
    var ref_elem = $("input[name='exercise'][value='" + ex + "," + q + "']");
    var tbody = ref_elem.prev().children("tbody");

    tbody.children(".answer-tr").children().each(function (index, elem) {
        $(this).children("input").val("");
    });

    tbody.children("tr[valign='TOP']").children().each(function (index, elem) {
        var letter = $(elem).children("b")[0].innerHTML.substr(0, 1);

        $(elem).removeClass();

        if (correct.indexOf(letter) != -1){
            $(elem).addClass("correct_answer bg-success");
            $(tbody.children(".answer-tr").children()[index]).children().prop("disabled", true);
        }

        if (incorrect.indexOf(letter) != -1){
            $(elem).addClass("incorrect_answer bg-danger");
        }

        if (not_answered.indexOf(letter) != -1){
            $(elem).addClass("not_answered bg-warning");
        }
    });
}

function parse_answer(ex, q, data) {
    var correct_titles = [];
    $(data).find('.correct').each(function (index) {
        correct_titles.push($(this).parent().prevAll('h2')[0].innerHTML.substr(0,1));
    });

    var incorrect_titles = [];
    var field_required = [];
    $(data).find('.errorlist').each(function (index) {
        if($(this).children().text().indexOf("Incorrect") != -1){
            incorrect_titles.push($(this).prevAll('h2')[0].innerHTML.substr(0,1));
        } else if($(this).children().text().indexOf("required") != -1){
            field_required.push($(this).prevAll('h2')[0].innerHTML.substr(0,1));
        }
    });

    update_fields(ex, q, correct_titles, incorrect_titles, field_required);
}

function send_answers(ex, q, a, nonce) {
    var answer_url = $("a[target='answers']").attr('href') + ex + "/" + q + "/";

    var post_data = {};
    a.forEach(function (elem) {
        if(elem[1] != ""){
            post_data[String.fromCharCode((97 + elem[0])) + "-value"] = (!isNaN(parseInt(elem[1])) ? parseInt(elem[1]): elem[1]);
        }
    });
    post_data['csrfmiddlewaretoken'] = nonce;

    $.ajax({
        url:answer_url,
        type:'POST',
        data:post_data,
        success: function(data){
            parse_answer(ex, q, data);
        }
    });
}

function get_correct(data, ex, q, a, callback){
    var correct_titles = [];
    $(data).find('.correct').each(function (index) {
        correct_titles.push($(this).parent().prevAll('h2')[0].innerHTML.substr(0,1));
    });

    var removed = 0;
    a.forEach(function (elem, index) {
        var letter = String.fromCharCode((97 + elem[0]));
        if(correct_titles.indexOf(letter) != -1){
            a.splice(elem[0] - removed, 1);
            removed++;
        }
    });

    var nonce = $(data).find("input[name='csrfmiddlewaretoken']").attr('value');

    callback(ex, q, a, nonce, data);
}

function answer_q(ex, q, a, callback) {

    var answer_url = $("a[target='answers']").attr('href') + ex + "/" + q + "/";

    $.ajax({
        url:answer_url,
        type:'GET',
        success: function(data){
            get_correct(data, ex, q, a, callback);
        }
    });
}

function fix_table2(index, element, exercise, question){
    var tr_questions = $(element).children("tbody").children("tr")[0];
    var tr_answers = $(element).children("tbody").children("tr")[1];
    $(tr_answers).addClass("answer-tr");

    var td_answers = $(tr_answers).children("td");

    $(td_answers).each(function (index, td_element) {
        $(td_element)[0].innerHTML = "<input id='" + exercise + "_" + question + "_" + index + "' " +
            "class='answer-input' type='text'>";
    });

    var td_questions = $(tr_questions).children("td");

    $(td_questions).each(function (index, td_element) {
        if($(td_element)[0].innerHTML.indexOf("<b>") == -1){
            var letter = String.fromCharCode(97 + index);

            if($(td_element)[0].innerHTML.indexOf(letter + ")") != -1){
                $(td_element)[0].innerHTML = $(td_element)[0].innerHTML.replace(letter + ")",
                    "<b>" + letter + ")</b>");
            } else{
                $(td_element)[0].innerHTML = "<b>" + String.fromCharCode(97 + index) + ")" + "</b>" + $(td_element)[0].innerHTML;
            }
        }
    });
}

function fix_table3(index, element, exercise, question){
    var tr_questions = $(element).children("tbody").children("tr")[0];
    var tr_answers = $(element).children("tbody").children("tr")[2];
    $(tr_questions).attr('valign', 'TOP');
    $(tr_answers).addClass("answer-tr");

    var td_answers = $(tr_answers).children("td");

    $(td_answers).each(function (index, td_element) {
        $(td_element).children("input").addClass("answer-input");
        $(td_element).children("input").attr('id', exercise + "_" + question + "_" + index);
    });

    var th_questions = $(tr_questions).children("th");

    $(th_questions).each(function (index, th_element) {
        if($(th_element)[0].innerHTML.indexOf("<b>") == -1){
            var letter = String.fromCharCode(97 + index);
            if($(th_element)[0].innerHTML.indexOf(")") != -1 &&
                letter != $(th_element)[0].innerHTML.charAt($(th_element)[0].innerHTML.indexOf(")") - 1)){
                letter = $(th_element)[0].innerHTML.charAt($(th_element)[0].innerHTML.indexOf(")") - 1);
            }

            if($(th_element)[0].innerHTML.indexOf(letter + ")") != -1){
                $(th_element)[0].innerHTML = $(th_element)[0].innerHTML.replace(letter + ")",
                    "<b>" + letter + ")</b>");
            } else{
                $(th_element)[0].innerHTML = "<b>" + String.fromCharCode(97 + index) + ")" + "</b>" + $(th_element)[0].innerHTML;
            }
        }
    });
}


window.onload = function () {
    console.log("DD Fix Starting...");

    $("a[target='help']").each(function (index) {
        $(this).empty();
        $(this).text("Hjälp?");
        $(this).addClass("btn btn-secondary");
    });

    var url_link = $("a[target='answers']");
    url_link.attr('href', url_link.attr('href').replace("http://", "https://"));

    var bundle = url_link.parent();
    bundle.addClass("header page-header");

    $("table[border='2'], table[border='3']").each(function (index, element) {

        if(index < 1){
            return true;
        }
        var parent = $(element).parent();
        parent.addClass("answers-wrapper");

        var exercise = parent.prevAll("h1")[0].innerHTML.split(",")[0].substr(-1, 1);
        var question = parent.prevAll("h1")[0].innerHTML.split(",")[1].substr(-1, 1);
        parent.append("<input type='hidden' name='exercise' value='" + exercise + "," + question + "'>");
        parent.append("<button class='btn btn-primary answer-trigger' >Skicka svar</button>");


        if($(this).attr('border') == 2){
            fix_table2(index, element, exercise, question);
        }
        if($(this).attr('border') == 3){
            fix_table3(index, element, exercise, question);
        }

        answer_q(exercise, question, [], function (ex, q, a, nonce, data) {
            var correct_titles = [];
            $(data).find('.correct').each(function (index) {
                correct_titles.push($(this).parent().prevAll('h2')[0].innerHTML.substr(0,1));
            });

            update_fields(ex, q, correct_titles, [], []);
        });

    });

    $(".answer-trigger").on("click", function (e) {
        var elem = $(e.target);

        var ex_q = elem.siblings("input[name='exercise']").attr('value');
        var ex = ex_q.split(",")[0];
        var q = ex_q.split(",")[1];

        var tr_answers = elem.siblings("table[border='2'], table[border='3']").children("tbody").children(".answer-tr");
        var td_answers = $(tr_answers).children();
        var answers = [];

        $(td_answers).each(function (index, td_element) {
            answers.push([index, $(td_element).children(".answer-input").val()]);
        });
        answer_q(ex, q, answers, send_answers);
    });
};