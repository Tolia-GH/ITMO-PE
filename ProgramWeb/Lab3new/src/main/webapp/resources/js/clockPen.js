const length = 310;
const height = 310;
const radius = 150;
const text_font = "15px Verdana";
const circle_font = "40px Verdana";
const hour_font = "60px Verdana";
const min_font = "40px Verdana";
const sec_font = "10px Verdana";
const min_line_font = "10px Verdana";

function drawClock() {
    let canvas = document.getElementById("click-clock");
    let pen = canvas.getContext("2d");

    pen.beginPath();
    pen.save();
    pen.fillStyle = "black";
    pen.font = text_font;
    //time
    pen.translate(length/2-5,height/2+5);
    for(let i = 0; i < 12; i++){
        let time = String(i+1);
        pen.fillText(time,(radius-20)*Math.cos(30*(i-2)*Math.PI/180),(radius-20)*Math.sin(30*(i-2)*Math.PI/180));
    }
    pen.restore();
    pen.closePath();

    //clock circle
    pen.beginPath();
    pen.fillStyle = "black";
    pen.font = circle_font;
    pen.arc(length/2,height/2,radius,0,2*Math.PI);
    pen.stroke();
    pen.closePath();

    //scale of hours
    pen.beginPath();
    pen.save();
    pen.fillStyle = "black";
    pen.font = circle_font;
    pen.translate(length/2,height/2);
    for(let i = 0; i < 12; i++){
        pen.moveTo((radius-10)*Math.cos(30*i*Math.PI/180),(radius-10)*Math.sin(30*i*Math.PI/180));
        pen.lineTo(radius*Math.cos(30*i*Math.PI/180),radius*Math.sin(30*i*Math.PI/180));
        pen.stroke();
    }
    pen.restore();
    pen.closePath();

    //scale of minutes
    pen.beginPath();
    pen.save();
    pen.fillStyle = "black";
    pen.font = min_line_font;
    pen.translate(length/2,height/2);
    for(let i = 0; i < 60; i++){
        pen.moveTo((radius-5)*Math.cos(6*i*Math.PI/180),(radius-5)*Math.sin(6*i*Math.PI/180));
        pen.lineTo(radius*Math.cos(6*i*Math.PI/180),radius*Math.sin(6*i*Math.PI/180));
        pen.stroke();
    }
    pen.restore();
    pen.closePath();

    //mid
    pen.beginPath();
    pen.font = circle_font;
    pen.fillStyle = "red";
    pen.arc(length/2,height/2,2,0,2*Math.PI);
    pen.fill();
    pen.closePath();

    let date = new Date();
    //pointer
    //hour
    pen.beginPath();
    pen.font = hour_font;
    pen.strokeStyle = "red";
    pen.save();
    pen.translate(length/2,height/2);
    let hour = date.getHours();
    let min = date.getMinutes();
    pen.moveTo(0,0);
    pen.lineTo((radius-60)*Math.cos(30*((hour+min/60)-3)*Math.PI/180),(radius-60)*Math.sin(30*((hour+min/60)-3)*Math.PI/180));
    pen.stroke();
    pen.restore();
    pen.closePath();
    //minute
    pen.beginPath();
    pen.font = min_font;
    pen.strokeStyle = "black";
    pen.save();
    pen.translate(length/2,height/2);
    pen.moveTo(0,0);
    pen.lineTo((radius-30)*Math.cos(6*(min-15)*Math.PI/180),(radius-30)*Math.sin(6*(min-15)*Math.PI/180));
    pen.stroke();
    pen.restore();
    pen.closePath();
    //second
    pen.beginPath();
    pen.font = sec_font;
    pen.strokeStyle = "black";
    pen.save();
    pen.translate(length/2,height/2);
    let sec = date.getSeconds();
    pen.moveTo(0,0);
    pen.lineTo((radius)*Math.cos(6*(sec-15)*Math.PI/180),(radius)*Math.sin(6*(sec-15)*Math.PI/180));
    pen.stroke();
    pen.restore();
    pen.closePath();
}

function clear(){
    let canvas = document.getElementById("click-clock");
    let rubbish = canvas.getContext("2d");
    rubbish.clearRect(0,0,length,height);
}
function flush(){
    clear();
    drawClock();
}
window.onload=function (){
    flush();
};
window.setInterval(function () {
    flush();
    },
    1000
);