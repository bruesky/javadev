$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();
    
    $.ajax("guest.ajax", {
		"type": "post",
		"data": {
        	"first": first,
                "last": last
		}
    }).done(displayGuests);
}

function displayGuests(data) {
    console.log(data);
    var guestList = "";
    for (let i = 0; i < data.length; i++){
        guestList+=i+" "+data[i].first+" "+data[i].last+"<br>";
    }


        // "You need to modify this method to display the updated guest list.  Remember to build the entire list before adding it to the DOM.";
    $("#guestList").html(guestList);
    
}