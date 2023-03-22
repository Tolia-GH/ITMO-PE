let canvas;
let ctx;

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

function drawPoints(x,y,r,hit) {
    ctx.restore();

    console.log("Draw: " + x + ", " + y + ", " + r + ", " + hit);

    let canvasX = (x/r) * 130 + 150;
    let canvasY = 150 - (y/r) * 130;

    ctx.moveTo(canvasX,canvasY);
    ctx.beginPath();
    ctx.arc(canvasX,canvasY,5,0,2 * Math.PI);
    ctx.closePath();

    console.log("'" + hit + "'");

    if (hit) {
        ctx.fillStyle = "#00ff00";
    } else {
        ctx.fillStyle = "#ff0000";
    }

    ctx.fill();

    ctx.save();
}

function validate(x,y,r) {
    // console.log("validating..." + x + ", " + y + ", " + r);
    // console.log(2 * x + r);
    // console.log(y)
    if(x >= 0 && y >= 0 && x <= r && y <= r) {
        return true;
    }
    else if (x < 0 && y > 0 && (2 * x) > y - r) {
        return true;
    } else return x < 0 && y < 0 && x ** 2 + y ** 2 <= (r/2) ** 2;
}

// function updateCanvas() {
//     let table = document.getElementById("table");
//
//     for (let i = 1; i < table.rows.length; i++) {
//         drawPoints(
//             table.rows[i].cells[1].innerHTML,
//             table.rows[i].cells[2].innerHTML,
//             table.rows[i].cells[3].innerHTML,
//             table.rows[i].cells[4].innerText
//         )
//     }
// }

function clickCanvas() {
    document.getElementById("requestForm:errorMessage").innerText = "";
    console.log("Clicking on canvas...")
    //document.getElementById("errorMessage").innerText = "";

    let canvas = document.getElementById("graph_canvas");

    let br = canvas.getBoundingClientRect();
    let left = br.left;
    let top = br.top;
    rIn = document.getElementById("requestForm:rInput").value;

    let event = window.event;
    if (rIn !== 0 && rIn != null && rIn !== "") {
        let x = ((event.clientX - left - 150)/65 * 0.5 * rIn).toFixed(2);
        let y = ((150 - (event.clientY - top))/65 * 0.5 * rIn).toFixed(2);

        document.getElementById("canvasForm:canvasX").value = x;
        document.getElementById("canvasForm:canvasY").value = y;
        document.getElementById("canvasForm:canvasR").value = rIn;
        document.getElementById("canvasForm:submitCanvas").click();

        drawPoints(x,y,rIn,validate(x,y,rIn));
        //updateCanvas()

        console.log("Clicking on: x=" + x + ", y =" + y + ", r=" + rIn);
        //location.reload();
    } else {
        document.getElementById("requestForm:errorMessage").innerText = "Error: R unchecked!"
        console.error("R unchecked!")
    }
}
window.onload=function () {
    canvas = document.getElementById("graph_canvas");
    ctx = canvas.getContext("2d");

    drawGraphic();
};