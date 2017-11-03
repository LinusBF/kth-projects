/**
 * Created by Linus on 2017-11-01.
 */

function parse_answer(ex, q, data) {
    var correct_titles = [];
    $(data).find('.correct').each(function (index) {
        correct_titles.push($(this).parent().prevAll('h2')[0].innerHTML.substr(0,1));
    });

    var field_required = [];
    var incorrect_titles = [];
    /*$(data).find('.errorlist').each(function (index) {
        correct_titles.push($(this).parent().prevAll('h2')[0].innerHTML.substr(0,1));
    });*/
}

function send_answers(ex, q, a, nonce) {
    console.log("Sending answers to " + ex + "," + q + " with nonce: " + nonce);
    console.log(a);
    var answer_url = $("a[target='answers']").attr('href') + ex + "/" + q + "/";

    var post_data = {};
    a.forEach(function (elem) {
        if(elem[1] != ""){
            post_data[String.fromCharCode((97 + elem[0])) + "-value"] = (!isNaN(parseInt(elem[1])) ? parseInt(elem[1]): elem[1]);
        }
    });

    $.ajax({
        url:answer_url,
        type:'POST',
        data:post_data,
        success: function(data){
            parse_answer(ex, q, data);
        }
    });
}

function get_correct(data, ex, q, a){
    var correct_titles = [];
    $(data).find('.correct').each(function (index) {
        correct_titles.push($(this).parent().prevAll('h2')[0].innerHTML.substr(0,1));
    });

    a.forEach(function (elem, index) {
        if(correct_titles.indexOf(String.fromCharCode((97 + elem[0]))) != -1){
            a.splice(elem[0], 1);
        }
    });

    var nonce = $(data).find("input[name='csrfmiddlewaretoken']").attr('value');

    send_answers(ex, q, a, nonce);
}

function answer_q(ex, q, a) {

    var answer_url = $("a[target='answers']").attr('href') + ex + "/" + q + "/";

    $.ajax({
        url:answer_url,
        type:'GET',
        success: function(data){
            get_correct(data, ex, q, a);
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

    $("table[border='2']").each(function (index, element) {
        if(index < 1){
            return true;
        }
        var parent = $(element).parent();
        parent.addClass("answers-wrapper");

        var exercise = parent.prevAll("h1")[0].innerHTML.split(",")[0].substr(-1, 1);
        var question = parent.prevAll("h1")[0].innerHTML.split(",")[1].substr(-1, 1);
        parent.append("<input type='hidden' name='exercise' value='" + exercise + "'>");
        parent.append("<input type='hidden' name='question' value='" + question + "'>");
        parent.append("<button class='btn btn-primary answer-trigger' >Skicka svar</button>");

        var tr_answers = $(element).children("tbody").children("tr")[1];
        $(tr_answers).addClass("answer-tr");

        var td_answers = $(tr_answers).children("td");

        $(td_answers).each(function (index, td_element) {
            $(td_element)[0].innerHTML = "<input id='" + exercise + "_" + question + "_" + index + "' " +
                "class='answer-input' type='text'>";
        });
    });

    $(".answer-trigger").on("click", function (e) {
        var elem = $(e.target);

        var ex = elem.siblings("input[name='exercise']").attr('value');
        var q = elem.siblings("input[name='question']").attr('value');

        var tr_answers = elem.siblings("table[border='2']").children("tbody").children(".answer-tr");
        var td_answers = $(tr_answers).children("td");
        var answers = [];

        $(td_answers).each(function (index, td_element) {
            answers.push([index, $(td_element).children(".answer-input").val()]);
        });
        answer_q(ex, q, answers);
    });
};