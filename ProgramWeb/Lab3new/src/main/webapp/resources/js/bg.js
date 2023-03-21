const r = 100;
const x = 175;
const y = 150;
var inputR = "1";
var inputX;
var inputY;
function drawBackground(id){
    let canvas = document.getElementById(id);
    let pen = canvas.getContext("2d");
    //background
    pen.fillStyle = "white" ;
    pen.beginPath();
    pen.rect(0,0,2*x, 2*y);
    pen.closePath();
    pen.fill();

    //axis
    pen.beginPath();
    pen.font = "20px Verdana";
    //y
    pen.moveTo(x, 0);
    pen.lineTo(x, 2*y);
    //x
    pen.moveTo(0, y);
    pen.lineTo(2*x, y);
    //arrow of y
    pen.moveTo(x-7,7);
    pen.lineTo(x,0);
    pen.moveTo(x+7,7);
    pen.lineTo(x,0);
    //arrow of x
    pen.moveTo(2*x-7,y-7);
    pen.lineTo(2*x,y);
    pen.moveTo(2*x-7,y+7);
    pen.lineTo(2*x,y);
    pen.stroke();

    //clear a range and set it's transparency
    pen.fillStyle = "orange";
    pen.clearRect(0,0,canvas.width,canvas.length);
    pen.globalAlpha = 0.5;

    //forth quadrant
    pen.beginPath();
    pen.rect(x,y,r,r);
    pen.closePath();
    pen.fill();

    //second quadrant
    pen.beginPath();
    pen.moveTo(x,y);
    pen.arc(x,y,r,Math.PI,1.5*Math.PI);
    pen.closePath();
    pen.fill();

    //third quadrant
    pen.beginPath();
    pen.moveTo(x,y);
    pen.lineTo(x,y+100);
    pen.lineTo(x-r/2,y);
    pen.fill();
    pen.closePath();

    //find R
    //onx
    let length = 2.5
    pen.beginPath();
    pen.font = "20px Verdana";
    pen.moveTo(x-3/2*r,y+length);
    pen.lineTo(x-3/2*r,y-length);
    pen.moveTo(x-r,y+length);
    pen.lineTo(x-r,y-length);
    pen.moveTo(x-r/2,y+length);
    pen.lineTo(x-r/2,y-length);
    pen.moveTo(x-r/2,y+length);
    pen.lineTo(x-r/2,y-length);
    pen.moveTo(x+r/2,y+length);
    pen.lineTo(x+r/2,y-length);
    pen.moveTo(x+r,y+length);
    pen.lineTo(x+r,y-length);
    pen.moveTo(x+3/2*r,y+length);
    pen.lineTo(x+3/2*r,y-length);
    //ony
    pen.moveTo(x-length,y-r);
    pen.lineTo(x+length,y-r);
    pen.moveTo(x-length,y-1/2*r);
    pen.lineTo(x+length,y-1/2*r);
    pen.moveTo(x-length,y+1/2*r);
    pen.lineTo(x+length,y+1/2*r);
    pen.moveTo(x-length,y+r);
    pen.lineTo(x+length,y+r);
    pen.stroke();
    //put R
    pen.fillStyle = "black";
    pen.font = "15px Verdana";
    pen.fillText("-"+(1.5*Number(inputR)+"").substr(0,3), x-1.5*r-20, y+8*length);
    pen.fillText("-"+Number(inputR).toFixed(2)+"", x-r-10, y+8*length);
    pen.fillText("-"+(0.5*Number(inputR)).toFixed(2)+"", x-0.5*r-15, y+8*length);
    pen.fillText((0.5*Number(inputR)).toFixed(2)+"", x+0.5*r-10, y+8*length);
    pen.fillText((Number(inputR)).toFixed(2)+"", x+r-5, y+8*length);
    pen.fillText((1.5*Number(inputR)).toFixed(2)+"", x+1.5*r-15, y+8*length);

    pen.fillText((Number(inputR)).toFixed(2)+"",x+8,y-r+5);
    pen.fillText((0.5*Number(inputR)).toFixed(2)+"",x+8,y-0.5*r+5);
    pen.fillText("-"+(0.5*Number(inputR)).toFixed(2)+"",x+8,y+0.5*r+5);
    pen.fillText("-"+Number(inputR).toFixed(2)+"",x+8,y+r+5);
    pen.stroke();
    pen.closePath();
}
function updateInput(id){
    clearGraph(id);//delete graph and then redraw
    getForm();//read your visible form
    drawBackground(id);// redraw background(nor includes dots)
    drawDots(id);//draw all dots
}
//input real absolute coordinate to the frame
function getForm(){
    inputR = document.getElementById("requestForm:R_input").value;
    inputX = document.getElementById("requestForm:X_input").value
    inputX = inputX.replace(/,/,".");
    inputR = inputR.replace(/,/,".");
    inputR = Number(inputR).toFixed(2)+"";
    inputX = Number(inputX).toFixed(2)+"";
    if(document.getElementById("requestForm:Y").value!==null &&document.getElementById("requestForm:Y").value!=="") {
        inputY = document.getElementById("requestForm:Y").value;
        inputY = inputY.replace(/,/,".");
        inputY = Number(document.getElementById("requestForm:Y").value).toFixed(2) + "";
    }else {
        inputY = 10000;
    }
}
function getInvisibleForm(){
    inputR = Number(document.getElementById("canvasForm:canvasR").value).toFixed(2)+"";
    inputX = Number(document.getElementById("canvasForm:canvasX").value).toFixed(2)+"";
    inputY = Number(document.getElementById("canvasForm:canvasY").value).toFixed(2)+"";
}
function clearGraph(id){
    let canvas = document.getElementById(id);
    let rubbish = canvas.getContext("2d");
    rubbish.clearRect(0,0,2*x,2*y);
}
window.onload=function () {
    drawBackground("click-graph");
};
function updateClick(id){
    clearGraph(id);//delete graph and then redraw
    getInvisibleForm();//read your visible form
    drawBackground(id);// redraw background(nor includes dots)
    drawDots(id);//draw all dots
}
function clear(id){
    clearGraph(id);//delete graph and then redraw
    getForm();//read your visible form
    drawBackground(id);// redraw background(nor includes dots)
    dots =[];
}
