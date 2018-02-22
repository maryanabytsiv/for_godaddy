$(function() {
    $("#submitUserForm").submit(function(e) {
        e.preventDefault();
        var frm = $("#submitUserForm");
        var data = {name:"", phones:[]};
        $.each(this, function(i, v){
            var input = $(v);
            if (input.attr("name")=="phones") {
                data[input.attr("name")].push(input.val());

            } else{
                data[input.attr("name")] = input.val();
            }
            delete data["undefined"];
        });
        saveRequestedData(frm, data, "user");
    });

});

function myFunction(){
    var data = document.getElementById("phone").value.split(",")
    document.getElementById("phone1").value = data[0];
    document.getElementById("phone2").value = data[1];
    document.getElementById("phone3").value = data[2];
}

$(document).ready(function(){
    $("#content").text("Welcome to my Homepage!");
});

function saveRequestedData(frm, data, type) {
    $.ajax({
        contentType:"application/json; charset=utf-8",
        type:frm.attr("method"),
        url:frm.attr("action"),
        dataType:'json',
        data:JSON.stringify(data),
        success:function(data) {
            if(data.status == "success") {
                toastr.success(data.message, data.title, {
                    closeButton:true
                });
                fetchList(type);
            } else {
                toastr.error(data.message, data.title, {
                    allowHtml:true,
                    closeButton:true
                });
            }
        }
    });
}