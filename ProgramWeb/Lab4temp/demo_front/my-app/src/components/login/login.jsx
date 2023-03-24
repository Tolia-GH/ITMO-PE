import React from "react";
import $ from 'jquery';
import {createBrowserHistory} from "history";
import PropTypes from 'prop-types';
import {getPassword,getUsername} from "../reduxStore/action/action";
import {connect} from "react-redux";
import '../../assets/css/user_entry.css';

class Login extends React.Component {
    render() {
        const {password,username,setPassword,setUsername,login,toRegister}=this.props;
        return (
            <div className={"form_field"}>
                <form id={"login_form"} className={"form-horizontal"}>
                    <div className={"form-group"}>
                        <label className={"col-xs-2 col-sm-1"}>
                            Username:
                        </label>
                        <div className={"col-xs-10 col-sm-2"}>
                            <input className={"form-control"} type="text" value={username} onChange={setUsername}/>
                        </div>
                    </div>
                    <div className={"form-group"}>
                        <label className={"col-xs-2 col-sm-1"}>
                            Password:
                        </label>
                        <div className={"col-xs-10 col-sm-2"}>
                            <input className={"form-control"} type="password" value={password} onChange={setPassword}/>
                        </div>
                    </div>
                    <div>
                        <button onClick={()=>login(username,password)} className={"col-xs-2 col-sm-1 .btn-primary margin_but"}>Log in</button>
                        <button onClick={()=>toRegister()} className={"col-xs-2 col-sm-1 .btn-primary"}>register</button>
                    </div>
                </form>
            </div>

        );
    }
}
Login.propTypes={
    username:PropTypes.string.isRequired,
    password:PropTypes.string.isRequired,
    setPassword:PropTypes.func.isRequired,
    setUsername:PropTypes.func.isRequired,
    login:PropTypes.func.isRequired,
    toRegister:PropTypes.func.isRequired
}
function mapStateToProps(state){
    return(
        {
            username:state.dot.username,
            password:state.dot.password
        }
    )
}
function sendAccount(username,password){
    $.ajax({
            url: "api/main",
            method:"POST",
            data:{
                password: password,
                username: username
            },
            async:false,
            success:function (res){
                if(res.success){
                    window.sessionStorage.setItem("username",username);
                    window.sessionStorage.setItem("password",password);
                    const history = createBrowserHistory();
                    history.push('/main');
                }else {
                    //dispatch(clearAccount());
                    alert(res.message);
                }
            }
        }
    );
}
function doDispatchToProps(dispatch){
    return({
        setUsername:(event)=>dispatch(getUsername(event.target.value)),
        setPassword:(event)=>dispatch(getPassword(event.target.value)),
        login:(username,password)=>{
            sendAccount(username,password,dispatch);
        },
        toRegister:()=>{
            const history = createBrowserHistory();
            history.push('/register');
        }
    })
}
export const LoginPage = connect(mapStateToProps,doDispatchToProps)(Login);