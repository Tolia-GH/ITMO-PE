import React from "react";
import $ from "jquery";
import PropTypes, {element} from 'prop-types';
import {connect} from "react-redux";
import {addDot, clearDots, GetR, GetX, GetY} from "../reduxStore/action/action";
import {Link} from "react-router-dom";

//pure ui component,which only deal with view
class CanvasForm extends React.Component{
    render(){
        const {X,Y,R,getX,getY,getR,submitForm} = this.props;
        let username = window.sessionStorage.getItem("username");
        if(username===null||username===""){
            return (<div>Ah,ha. Seems that you try to bypass login</div>);
        }else {
            //alert("Welcome! " + username);
            return (
                <div className={"form_block"}>
                    <fieldset className={"form-field"}>
                        <form id={"canvas_form"} role={"form"}>
                            <div className={"form-group"}>
                                <label>
                                    Please input X:
                                </label>
                                <div>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(-4)}>-4</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(-3)}>-3</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(-2)}>-2</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(-1)}>-1</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(0)}>0</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(1)}>1</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(2)}>2</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(3)}>3</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getX(4)}>4</button>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <label>
                                    Please input Y:
                                </label>
                                <div className={"col-xs-10 col-sm-2"}>
                                    <input type={"text"} name={"Y"} className={"form_input"} value={Y} placeholder={"from -5 to 5"} onChange={getY}/>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <label>
                                    Please input R:
                                </label>
                                <div>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getR(-4)}>-4</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getR(-3)}>-3</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getR(-2)}>-2</button>
                                    <button type={"button"} name={"X"} className={"X"} onClick={() => getR(-1)}>-1</button>
                                    <button type={"button"} name={"R"} className={"R"} onClick={() => getR(0)}>0</button>
                                    <button type={"button"} name={"R"} className={"R"} onClick={() => getR(1)}>1</button>
                                    <button type={"button"} name={"R"} className={"R"} onClick={() => getR(2)}>2</button>
                                    <button type={"button"} name={"R"} className={"R"} onClick={() => getR(3)}>3</button>
                                    <button type={"button"} name={"R"} className={"R"} onClick={() => getR(4)}>4</button>
                                </div>
                            </div>
                            <div className={"form-group"}>
                                <button id={"submit"} onClick={(event) => submitForm(X, Y, R, event)}>Submit</button>
                            </div>
                        </form>
                    </fieldset>
                </div>
            );
        }
    }
}

CanvasForm.propTypes = {
    X:PropTypes.number.isRequired,
    Y:PropTypes.string.isRequired,
    R:PropTypes.number.isRequired,
    getX:PropTypes.func.isRequired,
    getY:PropTypes.func.isRequired,
    getR:PropTypes.func.isRequired,
    submitForm:PropTypes.func.isRequired,
}

function mapStateToPros(state){
    return{
        X:state.dot.X,
        Y:state.dot.Y,
        R:state.dot.R,
    }
}

function mapDispatchToProps(dispatch){
    return{
        getX:(x)=>dispatch(GetX(x)),
        getR:(R)=>dispatch(GetR(R)),
        getY:(event)=>dispatch(GetY(event.target.value)),
        submitForm:(x,y,r,event)=>{
            event.preventDefault();
            $.ajax({
                url: "api/getDot",
                method:"POST",
                data:{
                    X:x,
                    Y:y,
                    R:r,
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


                        //alert("x="+res.x+" y="+res.y+" r="+res.r+" hit="+res.hit+" date="+res.date);
                    }
                }
            })
        }
    }
}

export const MainForm = connect(mapStateToPros,mapDispatchToProps)(CanvasForm);