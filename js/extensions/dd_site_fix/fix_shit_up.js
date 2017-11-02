/**
 * Created by Linus on 2017-11-01.
 */
function answer_q(ex, q, a) {
    console.log("Sending answers for " + ex + ", " + q);
    console.log(a);

    //TODO - Build ajax function to save answers.
}


window.onload = function () {
    console.log("DD Fix Starting...");

    $("a[target='help']").each(function (index) {
        $(this).empty();
        $(this).text("Hjälp?");
        $(this).addClass("btn btn-secondary");
    });

    var bundle = $("a[target='answers']").parent();
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