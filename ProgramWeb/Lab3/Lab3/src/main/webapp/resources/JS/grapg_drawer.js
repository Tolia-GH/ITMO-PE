let canvas;
let ctx;

let n = 0;
let pointsX = [];
let pointsY = [];
let pointsR = [];

function drawGraphic() {
    ctx.strokeStyle = "#373737"
    ctx.moveTo(0,0);
    ctx.beginPath();
    ctx.lineTo(300, 0);
    ctx.lineTo(300, 300);
    ctx.lineTo(0, 300);
    ctx.lineTo(0, 0);
    ctx.closePath();
    ctx.stroke();

    // rectangle
    ctx.fillStyle = "#2f9aff";
    ctx.fillRect(150, 20, 130, 130);

    //arc
    ctx.moveTo(150,150);
    ctx.beginPath();
    ctx.arc(150, 150, 65, 0.5 * Math.PI, Math.PI)
    ctx.closePath();
    ctx.fillStyle = "#2f9aff";
    ctx.fill();
    ctx.strokeStyle = "#2f9aff";
    ctx.stroke();

    //triangle
    ctx.beginPath();
    ctx.moveTo(150, 215);
    ctx.lineTo(85, 150);
    ctx.lineTo(150, 20);
    ctx.lineTo(150, 215)
    ctx.closePath();
    ctx.fillStyle = "#2f9aff";
    ctx.fill();
    ctx.strokeStyle = "#2f9aff";
    ctx.stroke();

    // axes
    ctx.beginPath();
    ctx.font = "10px Verdana";
    ctx.strokeStyle = "black";
    ctx.fillStyle = "black";
    ctx.moveTo(150, 0);
    ctx.lineTo(150, 300);
    ctx.moveTo(150, 0);
    ctx.lineTo(145, 15);
    ctx.moveTo(150, 0);
    ctx.lineTo(155, 15);
    ctx.fillText("Y", 160, 10);
    ctx.moveTo(0, 150);
    ctx.lineTo(300, 150);
    ctx.moveTo(300, 150);
    ctx.lineTo(285, 145);
    ctx.moveTo(300, 150);
    ctx.lineTo(285, 155);
    ctx.fillText("X", 290, 130);

    ctx.moveTo(145, 20);
    ctx.lineTo(155, 20);
    ctx.fillText('R',160, 20);
    ctx.moveTo(145, 85);
    ctx.lineTo(155, 85);
    ctx.fillText('R/2', 160, 78);
    ctx.moveTo(145, 215);
    ctx.lineTo(155, 215);
    ctx.fillText('-R/2',160, 215);
    ctx.moveTo(145, 280);
    ctx.lineTo(155, 280);
    ctx.fillText('-R',160, 280);

    // X parts
    ctx.moveTo(20, 145);
    ctx.lineTo(20, 155);
    ctx.fillText('-R', 15, 140);
    ctx.moveTo(85, 145);
    ctx.lineTo(85, 155);
    ctx.fillText('-R/2', 70, 140);
    ctx.moveTo(215, 145);
    ctx.lineTo(215, 155);
    ctx.fillText('R/2', 215, 140);
    ctx.moveTo(280, 145);
    ctx.lineTo(280, 155);
    ctx.fillText('R', 280, 140);

    ctx.closePath();
    ctx.strokeStyle = "black";
    ctx.fillStyle = "black";
    ctx.stroke();

    ctx.save();
}

function storePoint(x,y,r) {
    console.log("Storing " + n + "-th point...");
    pointsX[n] = x;
    pointsY[n] = y;
    pointsR[n] = r;
    ++n;
}

function drawPoints(x,y,r,hit) {
    ctx.restore();

    let canvasX = (x/r) * 130 + 150;
    let canvasY = 150 - (y/r) * 130;

    ctx.moveTo(canvasX,canvasY);
    ctx.beginPath();
    ctx.arc(canvasX,canvasY,2,0,2 * Math.PI);
    ctx.closePath();
    if (hit === "True") {
        ctx.fillStyle = "green";
    } else {
        ctx.fillStyle = "red";
    }

    ctx.fill();

    ctx.save();
}

function clickCanvas() {
    console.log("Clicking on canvas...")
    document.getElementById("errorR").innerText = "";

    let canvas = document.getElementById("canvas");

    let br = canvas.getBoundingClientRect();
    let left = br.left;
    let top = br.top;

    let event = window.event;
    if (r !== 0 && r != null) {
        let x = (event.clientX - left - 150)/65 * 0.5 * r;
        let y = (150 - (event.clientY - top))/65 * 0.5 * r;

        //setHiddenForm(x,y,r);
        drawPoints(x,y,r);
        storePoint(x,y,r)
        document.getElementById("hiddenForm").submit();
        //clearHiddenForm();

        console.log("Clicking on: x=" + x + ", y =" + y + ", r=" + r);
    } else {
        document.getElementById("errorR").innerText = "Error: R unchecked!"
        console.log("R unchecked!")
    }
}

window.onload=function () {
    canvas = document.getElementById("graph_canvas");
    ctx = canvas.getContext("2d");

    drawGraphic();
};