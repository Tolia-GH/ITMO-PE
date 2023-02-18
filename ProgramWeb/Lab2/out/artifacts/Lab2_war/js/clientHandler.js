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

function submitData() {
    dataCheck();
    document.getElementById("pointForm").submit();
}

function dataCheck() {

}