import {MainForm} from "./mainForm";
import {MainGraph} from "./mainGraph";
import {MainTable} from "./mainTable";
import React from "react";
export class Main extends React.Component {
    render() {
        return (
            <div>
                <MainGraph/>
                <MainForm/>
                <MainTable/>
            </div>
        )
    }
}