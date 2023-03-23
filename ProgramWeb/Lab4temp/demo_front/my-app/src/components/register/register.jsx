import React from "react";
import PropTypes from "prop-types";
import $ from "jquery";
import {getPassword, getUsername} from "../reduxStore/action/action";
import {connect} from "react-redux";

class RegisterBasic extends React.Component {
    render() {
        const {password, username,signUp,setUsername,setPassword} = this.props;
        return (
            <div>
            <form id={"register_form"} className={"form-horizontal"}>
                <div>
                    Now you can sign up your own account!
                </div>
                <div className={"form-group"}>
                    <label className={"col-xs-2 col-sm-1"}>
                        Name:
                    </label>
                    <div className={"col-xs-10 col-sm-2"}>
                        <input type="text" className={"form-control"} value={username} onChange={setUsername}/>
                    </div>
                </div>
                <div className={"form-group"}>
                    <label className={"col-xs-2 col-sm-1"}>
                     Password:
                    </label>
                    <div className={"col-xs-10 col-sm-2"}>
                        <input type="password" className={"form-control"} value={password} onChange={setPassword}/>
                    </div>
                </div>
                <button onClick={() => signUp(username, password)}>Sign up</button>
            </form><br/>
            <a href={"/"}>Home</a>
            </div>
        );
    }
}
RegisterBasic.propType = {
    password:PropTypes.string.isRequired,
    username:PropTypes.string.isRequired,
    signUp:PropTypes.func.isRequired,
    setPassword:PropTypes.func.isRequired,
    setUsername:PropTypes.func.isRequired
}
function mapStateToProps(state){
    return{
        password:state.account.password_account,
        username:state.account.username_account
    }
}
function mapDispatchToProps(dispatch){
    return{
        signUp:(username,password)=>register(username,password),
        setUsername:(event)=>dispatch(getUsername(event.target.value)),
        setPassword:(event)=>dispatch(getPassword(event.target.value))
    }
}
function register(username,password){
    $.ajax({
            url: "api/register",
            method:"POST",
            data:{
                password: password,
                username: username
            },
            async:false,
            success:function (res){
                if(res.success){
                    alert("success");
                }else {
                    alert(res.message);
                }
            }
        }
    );
}
export const Register = connect(mapStateToProps,mapDispatchToProps)(RegisterBasic);