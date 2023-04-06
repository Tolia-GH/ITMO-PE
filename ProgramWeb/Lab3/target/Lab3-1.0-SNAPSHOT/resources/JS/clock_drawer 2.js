let canvas;
let ctx;

function drawPanel() {//Clock white panel
    ctx.translate(150, 150);
    ctx.beginPath();
    ctx.arc(0, 0, 130, 0, 2 * Math.PI);
    ctx.fillStyle = "white";
    ctx.fill();
}

function hourNum() {//Numbers of Hour
    let arr = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"];
    ctx.beginPath();
    ctx.font = "30px Times New Romen";
    ctx.textAlign = "center";
    ctx.textBaseline = "middle";
    ctx.fillStyle = "black";
    for (let i = 0; i < arr.length; i++) {
        ctx.fillText(
            arr[i],
            108 * Math.cos(((i * 30 - 60) * Math.PI) / 180),
            108 * Math.sin(((i * 30 - 60) * Math.PI) / 180)
        );
    }
}

function centerDot() {//Center point
    ctx.beginPath();
    ctx.arc(0, 0, 8, 0, 2 * Math.PI);
    ctx.fill();
    ctx.beginPath();
    ctx.fillStyle = "gray";
    ctx.arc(0, 0, 5, 0, 2 * Math.PI);
    ctx.fill();
}

function hourPin(hours, minutes) {
    let radius =
        ((2 * Math.PI) / 12) * hours + (((1 / 6) * Math.PI) / 60) * minutes;
    ctx.save();
    ctx.beginPath();
    ctx.lineWidth = 5;
    ctx.lineCap = "round";
    ctx.strokeStyle = "black";
    ctx.rotate(radius);
    ctx.moveTo(0, 0);
    ctx.lineTo(0, -50);
    ctx.stroke();
    ctx.restore();
}

function minutePin(minutes) {
    //2 * Math.PI;
    let radius = ((2 * Math.PI) / 60) * minutes;
    ctx.save();
    ctx.beginPath();
    ctx.lineWidth = 3;
    ctx.lineCap = "round";
    ctx.strokeStyle = "black";
    ctx.rotate(radius);
    ctx.moveTo(0, 0);
    ctx.lineTo(0, -70);

    ctx.stroke();
    ctx.restore();
}
function secondPin(seconds) {
    let radius = ((2 * Math.PI) / 60) * seconds;
    ctx.save();
    ctx.beginPath();
    ctx.lineWidth = 1;
    ctx.lineCap = "round";
    ctx.strokeStyle = "red";
    ctx.rotate(radius);
    ctx.moveTo(0, 0);
    ctx.lineTo(0, -90);
    ctx.stroke();
    ctx.restore();
}

/*         ctx.clearRect(0, 0, ctx.width, ctx.height);
  var time = new Date();
  var hours = time.getHours();
  var minutes = time.getMinutes();
  var seconds = time.getSeconds();
  minuteHand(minutes);
  secondHand(seconds);
  hourHand(hours, minutes); */
function update() {
    let time = new Date();
    let hours = time.getHours();
    let minutes = time.getMinutes();
    let seconds = time.getSeconds();
    ctx.save();
    drawPanel();
    hourNum();
    secondPin(seconds);
    minutePin(minutes);
    hourPin(hours, minutes);
    centerDot();
    ctx.restore();
}

window.onload=function () {
    canvas = document.getElementById("clock_canvas");
    ctx = canvas.getContext("2d");
    update();
};

window.setInterval(() => {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    update();
}, 1000);