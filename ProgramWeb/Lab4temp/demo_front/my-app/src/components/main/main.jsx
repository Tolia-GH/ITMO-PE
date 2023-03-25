import {MainForm} from "./mainForm";
import {MainGraph} from "./mainGraph";
import {MainTable} from "./mainTable";
import React from "react";
import '../../assets/css/page_style.css'

export class Main extends React.Component {
    render() {
        return (
            <div>
                <div className={"header_col"}>
                    <a id={"fork_me"} href={"https://github.com/Tolia-GH/ITMO-PE"}>
                        View on GitHub
                    </a>
                    <h1 id={"web_title"}>Lab4</h1>
                    <h2 id={"web_author"}>P32131 Чжоу Хунсян 13109</h2>
                </div>
                <MainGraph/>
                <MainForm/>
                <MainTable/>
            </div>
        )
    }
}