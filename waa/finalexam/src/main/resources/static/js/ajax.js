$(function () {
    $("#addBook").click(function(){
        console.log("click");
        // let data = JSON.stringify($("#bookform").serialize());
        data = {"bookName":$("#bookName").val(),
            "category" : {
                "catId": $("#catId").val()
            }
        }
        data = JSON.stringify(data);
        console.log(data);
        $.ajax({
            type : "POST",
            url : "addbook",
            data : data,
            contentType: "application/json",
            dataType : "json",

            success: function(result) {
                console.log(result);
                // $('#formInput').html("");
                // $("#formInput").append( '<H3 align="center"> New Employee Information <H3>');
                // $('#formInput').append("<H4 align='center'>First Name:  " + result.firstName  + "</h4>"  );
                // $('#formInput').append("<H4 align='center'>Last Name: " + result.lastName  + "</h4>" );
                // $('#formInput').append("<H4 align='center'>Email: " + result.email  + "</h4>");
                // $("#formInput").append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');resetForm(\'employeeForm\');"><b>EXIT</b> </a> </h4>');
                // make_visible('formInput');
                // make_hidden('errors');
            },

            error: function(XMLHttpRequest, textStatus, errorThrown){
                console.log(XMLHttpRequest.responseJSON);
                // $("#errors").empty();
                //
                // if (XMLHttpRequest.responseJSON.errorType == "ValidationError") {
                //     let errorMsg = '<h3> Error(s)!! </h3>';
                //     errorMsg += "<p>";
                //     var errorList = XMLHttpRequest.responseJSON.errors;
                //     errorList.forEach(error=>{
                //         errorMsg = errorMsg + error.field+" "+error.message + '<br>';
                //     })
                //
                //     errorMsg += '</p>';
                //     $('#errors').append(errorMsg);
                //     make_visible('errors');
                //     make_hidden('formInput');
                // } else {
                //     alert(errorObject.responseJSON.errors(0)); // "non" Validation
                // }
            }
        });

    })
})