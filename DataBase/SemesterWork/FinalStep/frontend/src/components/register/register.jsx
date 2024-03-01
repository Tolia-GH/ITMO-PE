import React from "react";
import PropTypes from "prop-types";
import $ from "jquery";
import {getPassword, getUsername} from "../reduxStore/action/action";
import {connect} from "react-redux";
import '../../assets/css/page_style.css';
import {Link} from "react-router-dom";

class RegisterBasic extends React.Component {
    render() {
        const {password, username, signUp, setUsername, setPassword} = this.props;
        return (
            <div>
                <div className={"header_col"}>
                    <a id={"fork_me"} href={"https://github.com/Tolia-GH/ITMO-PE"}>
                        View on GitHub
                    </a>
                    <h1 id={"web_title"}>Smart Home</h1>
                    <h2 id={"web_author"}>P33131 Чжоу Хунсян 13109</h2>
                </div>
                <div className={"form_block"}>
                    <form id={"register_form"} className={"form-horizontal"}>
                        <h3>
                            Create new account
                        </h3>
                        <fieldset className={"form-field"}>

                            <div className={"form-group"}>
                                <label>
                                    Username:
                                </label>
                                <input type="text" className={"form_input"} value={username} onChange={setUsername}/>
                            </div>
                            <div className={"form-group"}>
                                <label>
                                    Password:
                                </label>
                                <input type="password" className={"form_input"} value={password} onChange={setPassword}/>
                            </div>
                            <button id={"sign_up"} onClick={() => signUp(username, password)}>Sign up</button>
                        </fieldset>
                    </form>

                    <Link className={"link"} to={"/"}><button id={"back"} className={"click_button"}>Back</button></Link>
                </div>
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
            success:function (res) {
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