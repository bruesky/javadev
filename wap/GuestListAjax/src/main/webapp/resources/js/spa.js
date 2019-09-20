function getComment(id){
    let url = 	"http://jsonplaceholder.typicode.com/comments";
    $.ajax({
        type: "GET",
        url: url,
        data:{id : id}, // serializes the form's elements.
        success: function(data) {
            console.log(data);
            let ret = "";
            data.forEach(obj=>{
                ret+=`email: ${obj.email}<br>`;
                ret+=`name: ${obj.name}<br>`;
                ret+=`${obj.body}<br>`;
            })
            $("#comment_"+id).html(ret);
        }});
}

$(function() {
    $("#idform").submit(function(e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.
        var form = $(this);
        var url = "http://jsonplaceholder.typicode.com/posts";
        $.ajax({
            type: "GET",
            url: url,
            data: form.serialize(), // serializes the form's elements.
            success: function(data)
            {
                console.log(data);
                let ret = "";
                data.forEach(obj=>{
                    ret+="<H1>"+obj.title+"</H1><br>"
                    ret+="<p>"+obj.body+"</p>"
                    ret+=`<input id='${obj.id}' type='button' value='comment' onclick=\"getComment(${obj.id})\"/><br>`
                    ret+=`<div id="comment_${obj.id}"></div>`;
                });

                $("#articles").html(ret);
            }
        });
    });
});