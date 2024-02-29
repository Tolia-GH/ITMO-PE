import React from 'react';
import {Route,Routes} from 'react-router-dom';
import {LoginPage} from "./login/login";
import {Main} from "./main/main";
import {Register} from "./register/register";
class App extends React.Component {
    render(){
        return(
            <div>
                <Routes>
                    <Route path="/" element={<LoginPage/>}/>
                    <Route path={"/main"} element={<Main/>}/>
                    <Route path={"/register"} element={<Register/>}/>
                </Routes>
            </div>
        )
    }
}
export default App;