let xIn,yIn,rIn;

function submitData() {
    console.log("submitting data...")

    document.getElementById("requestForm:errorMessage").innerText = "";
    xIn = document.getElementById("requestForm:xInput").value;
    yIn = document.getElementById("requestForm:yInput").value;
    rIn = document.getElementById("requestForm:rInput").value;
    console.log("x=" + xIn + ", y=" + yIn + ", r=" + rIn);

    if (checkData(xIn)) {

        document.getElementById("requestForm:send").click();
        //location.reload();
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