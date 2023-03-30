import React from "react";
import PropTypes from "prop-types";
import {connect} from "react-redux";
import $ from "jquery";
import {addDot, clearDots} from "../reduxStore/action/action";

//pure ui
const x = 155;
const y = 155;
const r = 100;
class CanvasGraphComponent extends React.Component {
    componentDidMount() {
        const {R,clearCanvas,drawBackground} = this.props;
        let username = window.sessionStorage.getItem("username");
        if(!(username===null||username==="")) {
            clearCanvas(this.refs.canvas.getContext("2d"));
            drawBackground(this.refs.canvas.getContext("2d"), R);
        }
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        const {R,clearCanvas,drawBackground,drawDots,Dots} = this.props;
        let username = window.sessionStorage.getItem("username");
        if(!(username===null||username==="")) {
            clearCanvas(this.refs.canvas.getContext("2d"));
            drawBackground(this.refs.canvas.getContext("2d"), R);
            if (Dots.length > 0 || R > 0) {
                drawDots(Dots, this.refs.canvas.getContext("2d"), R);
            }
        }
    }

    render() {
        const {clickGraph,R} = this.props;
        let username = window.sessionStorage.getItem("username");
        if(username===null||username===""){
            return (<div> </div>);
        }
        return (
            <canvas ref={"canvas"} id={"click_graph"} width={310} height={310} onClick={(event)=>{
            clickGraph(document.getElementById("click_graph").getBoundingClientRect(),event,R);}}/>
            );
    }
}

CanvasGraphComponent.propTypes = {
    R:PropTypes.number.isRequired,
    Dots:PropTypes.array.isRequired,
    drawBackground:PropTypes.func.isRequired,
    clearCanvas:PropTypes.func.isRequired,
    drawDots:PropTypes.func.isRequired,
    clickGraph:PropTypes.func.isRequired
}
function mapStateToProps(state){
    return{
        R:state.dot.R,
        Dots:state.dot.Dots,
        }
}
//functions won't change state, so here don't use dispatcher and reducer
function mapDispatchToProps(dispatch){
    return(
        {
            drawBackground:(refs,R)=>drawBackground(refs,R),
            clearCanvas:(refs)=>clearCanvas(refs),
            drawDots:(Dots,refs,R)=>drawDots(Dots,refs,R),
            //refs should be this.refs
            clickGraph:(browser,event,R)=>{
                let cx = translateClickX(browser,event.clientX,R);
                let cy = translateClickY(browser,event.clientY,R);
                $.ajax({
                    url: "api/getDot",
                    method:"POST",
                    data:{
                        X:cx,
                        Y:cy,
                        R:R,
                        Password:window.sessionStorage.getItem("password"),
                        Username:window.sessionStorage.getItem("username")
                    },
                    async:false,
                    success:function (res){
                        if(res.wrong) {
                            alert(res.message);
                        }else {
                            let listContent = "";
                            dispatch(clearDots());
                            res.dotList.map((ele) => {
                                //listContent = listContent + "\n" + ele.x + ", " + ele.y + ", " + ele.r + ", " + ele.hit + ", " + ele.date;
                                dispatch(addDot(ele.x,ele.y+"",ele.r,ele.hit,ele.date));
                            })
                            //alert(listContent);
                            window.sessionStorage.setItem("list",JSON.stringify(res.dotList));

                            //dispatch(addDot(res.x,res.y+"",res.r,res.hit,res.date));
                            //alert("x="+res.x+" y="+res.y+" r="+res.r+" hit="+res.hit+" date="+res.date);
                        }
                    }
                })
            }
        }
    )
}

function drawBackground(refs,R){
    const pen = refs;
    //background
    pen.fillStyle = "#f6f8fa" ;
    pen.beginPath();
    pen.clearRect(0,0,2*x,2*y);
    pen.rect(0,0,2*x, 2*y);
    pen.closePath();
    pen.fill();

    //axis
    pen.strokeStyle = "#f6f8fa";
    pen.strokeRect(0,0,2*x,2*y);
    pen.beginPath();
    pen.strokeStyle = "#373737";
    pen.font = "20px Arial";

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

    //clear a range and set its transparency
    pen.fillStyle = "#2f9aff";
    pen.globalAlpha = 0.8;

    //fourth quadrant
    pen.beginPath();
    pen.rect(x,y-r,r,r);
    pen.closePath();
    pen.fill();

    //first quadrant
    pen.beginPath();
    pen.moveTo(x, y);
    pen.arc(x, y,r/2,0.5 * Math.PI, Math.PI);
    pen.closePath();
    pen.fill();

    //third quadrant
    pen.beginPath();
    pen.moveTo(x, y);
    pen.lineTo(x,y-r);
    pen.lineTo(x-r/2, y);
    pen.fill();
    pen.closePath();

    //find R
    //onx
    const length = 2.5
    pen.beginPath();
    pen.font = "20px Arial";
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
    pen.fillStyle = "#373737";
    pen.font = "15px Arial";
    //pen.fillText(-1.5*R+"", x-1.5*r-20, y+8*length);
    pen.fillText(-1*R+"", x-r-10, y+8*length);
    pen.fillText(-0.5*R+"", x-0.5*r-15, y+8*length);
    pen.fillText(0.5*R+"", x+0.5*r-10, y+8*length);
    pen.fillText("0", x-10, y+8*length);
    pen.fillText(1*R+"", x+r-5, y+8*length);
    //pen.fillText(1.5*R+"", x+1.5*r-15, y+8*length);

    pen.fillText(R+"",x+8,y-r+5);
    pen.fillText(0.5*R+"",x+8,y-0.5*r+5);
    pen.fillText(-0.5*R+"",x+8,y+0.5*r+5);
    pen.fillText(-R+"",x+8,y+r+5);
    pen.stroke();
    pen.closePath();
}
function clearCanvas(refs){
    const x = 155;
    const y = 155;
    refs.clearRect(0,0,2*x,2*y);
}
function drawDots(Dots,refs,R){
    const pen = refs;
    pen.globalAlpha = 1;
    Dots.forEach((ele,key)=>{
        drawDot(ele,pen,R);
    });
}
//length of x,y,r
function drawDot(Dot,pen,R){
    pen.beginPath()
    if(Dot.hit){
        pen.fillStyle = "green";
    }else {
        pen.fillStyle = "red";
    }
    let xDraw = translateInputX(Dot.x,R,x,r);
    let yDraw = translateInputY(Number(Dot.y),R,y,r);
    pen.arc(xDraw, yDraw, 3, 0,360,false);
    pen.fill();
    //pen.stroke();
    pen.closePath();
}
function translateInputY(inputY,inputR,coordinateY,coordinateR){
    return coordinateY-coordinateR*inputY/inputR;
}
function translateInputX(inputX,inputR,coordinateX,coordinateR){
    return (coordinateR*inputX/inputR)+coordinateX;
}
function translateClickY(browser,eventY,R){
    let browserTop = browser.top;
    //absolute y
    let ay = eventY-browserTop;
    //coordinate y
    return ((y-ay)*R/r).toFixed(2);
}
function translateClickX(browser,eventX,R){
    let browserLeft = browser.left;
    //absolute x
    let ax = eventX-browserLeft;
    //coordinate y
    return ((ax-x)*R/r).toFixed(2);
}

export const MainGraph = connect(mapStateToProps,mapDispatchToProps)(CanvasGraphComponent);