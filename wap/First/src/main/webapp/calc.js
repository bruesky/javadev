$(function(){
    $("#calc").submit(function(event){
        event.preventDefault();
        console.log("calc");
        this.submit();
    });
});