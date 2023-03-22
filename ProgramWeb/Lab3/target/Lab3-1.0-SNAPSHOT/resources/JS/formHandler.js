let x,y,r;

function init() {

}

function submitData() {
    console.log("submitting data...")

    document.getElementById("requestForm:errorMessage").innerText = "";
    x = document.getElementById("requestForm:xInput").value;
    console.log("x=" + x);

    if (checkData(x)) {

        document.getElementById("requestForm:send").click();
        //updateCanvas();

    } else {
        console.error("Error: input error!")
    }
}

function checkData(x) {
    if (x === "") {
        document.getElementById("requestForm:errorMessage").innerText = "Error: X can not be empty!";
        return false;
    } else if (x < -3 || x > 3) {
        document.getElementById("requestForm:errorMessage").innerText = "Error: X out of range!";
        return false;
    } else {
        return true;
    }
}