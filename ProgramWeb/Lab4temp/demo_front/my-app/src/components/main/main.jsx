import {MainForm} from "./mainForm";
import {MainGraph} from "./mainGraph";
import React from "react";
import '../../assets/css/page_style.css'
import {Link} from "react-router-dom";
import ResultTable from "./mainResult";

export class Main extends React.Component {
    render() {
        //document.getElementById("welcome_msg").innerText = window.sessionStorage.getItem("username");
        return (
            <div>
                <div className={"header_col"}>
                    <a id={"fork_me"} href={"https://github.com/Tolia-GH/ITMO-PE"}>
                        View on GitHub
                    </a>
                    <h1 id={"web_title"}>Lab4</h1>
                    <h2 id={"web_author"}>P32131 Чжоу Хунсян 13109</h2>
                </div>
                <Link className={"link"} to={"/"}><button id={"back"} className={"click_button"}>Back</button></Link>
                <MainGraph/>
                <MainForm/>
                <ResultTable/>
            </div>
        )
    }
}