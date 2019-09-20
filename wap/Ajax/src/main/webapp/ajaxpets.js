$(function() {
    $("#puppies").click(updatePictures);
    $("#kitties").click(updatePictures);
});

function updatePictures() {
    var animal = "";
    if ($("#puppies").attr("checked") == "checked") {
        animal = "puppy";
    } else {
        animal = "kitty";
    }
    $.ajax("pets", {
        "type": "get",
        "data": {
            "animal": animal
        }
    }).done(displayPictures);


}

function displayPictures(data) {
    $("#pictures").html(data);
}
