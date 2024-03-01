import React from 'react';
import {Route,Routes} from 'react-router-dom';
import Main from "./main/main";
import SignIn from "./login/signin";
import SignUp from "./login/signup";
class App extends React.Component {
    render(){
        return(
            <div>
                <Routes>
                    <Route path="/" element={<SignIn/>}/>
                    <Route path={"/main"} element={<Main/>}/>
                    <Route path={"/signup"} element={<SignUp/>}/>
                </Routes>
            </div>
        )
    }
}
export default App;