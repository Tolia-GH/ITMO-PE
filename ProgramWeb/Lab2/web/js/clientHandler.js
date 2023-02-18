/*
$("#pointForm").on("submit", function () {

    console.log("Submitting data...");

    $.ajax({
        uri: 'Controller',
        method: "get",
        data: $(this).serialize(),
        dataType: "html",

        success: function (data) {

        }
    })
})
*/

function submitData() {
    //let x = document.getElementsByName("X");
    let y = document.getElementById("Y").value;
    //let r = document.getElementsByName("R");
    alert("x="+", y="+y+", r=");
    //dataCheck(x,y,r);

    //document.getElementById("pointForm").submit();
}

function dataCheck(x,y,r) {

}