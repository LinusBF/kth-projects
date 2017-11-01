/**
 * Created by Linus on 2017-11-01.
 */
function answer_q(ex, q) {
    console.log("Sending answers for " + ex + ", " + q);

    //TODO - Add answers to argument and build ajax function to save answers.
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

    $("table[border='2']").each(function (index) {
        if(index < 1){
            return true;
        }
        var parent = $(this).parent();
        parent.addClass("answers-wrapper");

        var exercise = parent.prevAll("h1")[0].innerHTML.split(",")[0].substr(-1, 1);
        var question = parent.prevAll("h1")[0].innerHTML.split(",")[1].substr(-1, 1);
        parent.append("<input type='hidden' name='exercise' value='" + exercise + "'>");
        parent.append("<input type='hidden' name='question' value='" + question + "'>");
        parent.append("<button class='btn btn-primary answer-trigger' >Skicka svar</button>");
    });

    $(".answer-trigger").on("click", function (e) {
        var elem = $(e.target);

        var ex = elem.siblings("input[name='exercise']").attr('value');
        var q = elem.siblings("input[name='question']").attr('value');
        //TODO - Gather answer info
        answer_q(ex, q);
    });
};