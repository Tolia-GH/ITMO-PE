var dots = [];
class Dot {
    constructor(x,y,r) {
        this.x = parseFloat(x);
        this.y = parseFloat(y);
        this.r = parseFloat(r);
        this.hit = validateRange(this.x,this.y,this.r)
    }
}
function validateRange(x, y, r){
    //0<x<r,-r<y<0  forth
    if( (x > 0 && x < r) && (y < 0 && y > -r) ){
        return true;
    }//-r/2<x<=0,-2rx-r<y<=0 third
    else if( (x >= -r/2 && x <= 0) && (y<= 0 && y >= (-2*x-r) ) ){
        return true;
    }//y>0,x<0,x^2+y^2<r*r second
    else return (x <= 0) && (y >= 0) && (x*x + y*y <= r*r);
}

function validateValue(x, y,r){
    return (x >= -5 && x <= 5) && (y >= -3 && y <= 3) && (r >= 0.1 && r <= 3);
}

function drawDots(id){
    if(validateValue(Number(inputX),Number(inputY),Number(inputR))) {
        dots.push(new Dot(inputX, inputY, inputR));
    }
    for(let i = 0; i<dots.length;i++){
        drawDot(id, dots[i])
    }
}

function drawDot(id,dot) {
    let canvas = document.getElementById(id);
    let pen = canvas.getContext("2d");
    let xDraw = translateX(dot.x);
    let yDraw = translateY(dot.y);
    pen.globalAlpha = 1;
    pen.beginPath()
    //setting of color
    if(validateRange(dot.x,dot.y,Number(inputR))){
        pen.fillStyle = "blue";
    }else{
        pen.fillStyle = "green";
    }
    pen.fillRect(xDraw, yDraw, 4, 4);
    pen.fill();
    pen.stroke();
    pen.closePath();
}

//translate input to absolute
//parameters are input r/x/y
function translateY(iy){
    return y-r*iy/Number(inputR);
}
function translateX(ix){
    return (r*ix/Number(inputR))+x;
}
//add click
document.getElementById("click-graph").addEventListener("click",function (event) {
    let can = document.getElementById("click-graph");
    let browser = can.getBoundingClientRect();
    let browserLeft = browser.left;
    let browserTop = browser.top;
    //absolute x/y
    let ax = event.x-browserLeft;
    let ay = event.y-browserTop;
    inputR = (document.getElementById("requestForm:R_input").value).replace(/,/,".");
    //translation to coordinate
    let cx = ((ax-x)*Number(inputR.replace(/,/,"."))/r).toFixed(2);
    let cy = ((y-ay)*Number(inputR.replace(/,/,"."))/r).toFixed(2);
    document.getElementById("canvasForm:canvasX").value = (cx+"").replace(/,/,".");
    document.getElementById("canvasForm:canvasY").value = (cy+"").replace(/,/,".");
    document.getElementById("canvasForm:canvasR").value = inputR;
    document.getElementById("canvasForm:submitClick").click();
});