import React from "react";
import $ from 'jquery';
import {createBrowserHistory} from "history";
import PropTypes from 'prop-types';
import {addDot, clearDots, getPassword, getUsername} from "../reduxStore/action/action";
import {connect} from "react-redux";
import '../../assets/css/page_style.css';

class Login extends React.Component {
    render() {
        const {password,username,setPassword,setUsername,login,toRegister}=this.props;
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
                    <form id={"login_form"} className={"form-horizontal"}>
                        <fieldset className={"form-field"}>
                            <div className={"form-group"}>
                                <label className={"var_label"}>
                                    Username:
                                </label>
                                <input className={"form_input"} type="text" value={username} onChange={setUsername}/>
                            </div>
                            <div className={"form-group"}>
                                <label className={"var_label"}>
                                    Password:
                                </label>
                                <input className={"form_input"} type="password" value={password} onChange={setPassword}/>
                            </div>
                            <div id={"buttons_set"}>
                                <button onClick={()=>login(username, password)} id={"login"} className={"click_button"}>Log in</button>
                                <button onClick={()=>toRegister()} id={"signup"} className={"click_button"}>Sign up</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
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
// function sendAccount(username,password){
//     $.ajax({
//             url: "api/main",
//             method:"POST",
//             data:{
//                 password: password,
//                 username: username
//             },
//             async:false,
//             success:function (res){
//                 if(res.success) {
//                     let listContent = "";
//                     //dispatch(clearDots());
//                     res.dotList.map((ele) => {
//                         listContent = listContent + "\n" + ele.x + ", " + ele.y + ", " + ele.r + ", " + ele.hit + ", " + ele.date;
//                     //     //dispatch(addDot(ele.x,ele.y+"",ele.r,ele.hit,ele.date));
//                      })
//                     alert(listContent);
//                     //window.sessionStorage.setItem("list",res.dotList)
//
//                     window.sessionStorage.setItem("username",username);
//                     window.sessionStorage.setItem("password",password);
//                     const history = createBrowserHistory();
//                     history.push('/main');
//                 }else {
//                     //dispatch(clearAccount());
//                     alert(res.message);
//                 }
//             }
//         }
//     );
// }
function doDispatchToProps(dispatch){
    return({
        setUsername:(event)=>dispatch(getUsername(event.target.value)),
        setPassword:(event)=>dispatch(getPassword(event.target.value)),
        login:(username,password)=>{
            //sendAccount(username,password,dispatch);
            $.ajax({
                    url: "api/main",
                    method:"POST",
                    data:{
                        password: password,
                        username: username
                    },
                    async:false,
                    success:function (res){
                        if(res.success) {
                            //let listContent = "";

                            //alert(listContent);
                            window.sessionStorage.setItem("list",JSON.stringify(res.dotList));

                            window.sessionStorage.setItem("username",username);
                            window.sessionStorage.setItem("password",password);
                            const history = createBrowserHistory();
                            history.push('/main');

                            dispatch(clearDots());
                            res.dotList.map((ele) => {
                                //listContent = listContent + "\n" + ele.x + ", " + ele.y + ", " + ele.r + ", " + ele.hit + ", " + ele.date;
                                dispatch(addDot(ele.x,ele.y+"",ele.r,ele.hit,ele.date));
                            })
                        }else {
                            //dispatch(clearAccount());
                            alert(res.message);
                        }
                    }
                }
            );

        },
        toRegister:()=>{
            const history = createBrowserHistory();
            history.push('/register');
        }
    })
}
export const LoginPage = connect(mapStateToProps,doDispatchToProps)(Login);