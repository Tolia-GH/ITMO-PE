import * as React from 'react';
import PropTypes from "prop-types";
import {connect} from "react-redux";
import {createBrowserHistory} from "history";
class Table extends React.Component{
    render() {
        const {Dots,Home} = this.props;
        let username = window.sessionStorage.getItem("username");
        if(username===null||username===""){
            return (<div> </div>);
        }
        return(
            <div>
                <a onClick={Home} href={"/"}>Home</a>
                <table className={"table table-striped table-bordered table-hover table-condensed"}>
                    <thead>
                    <tr>
                        <th>X</th>
                        <th>Y</th>
                        <th>R</th>
                        <th>Hit</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        Dots.map((ele,key)=>{
                            return <tr key={key}>
                                <th width={60}>{ele.x}</th>
                                <th width={60}>{ele.y}</th>
                                <th width={60}>{ele.r}</th>
                                <th width={60}>{ele.hit+""}</th>
                                <th width={200}>{ele.date}</th>
                            </tr>
                        })
                    }
                    </tbody>
                </table>
            </div>
        );
    }
}
Table.propTypes={
    Dots:PropTypes.array.isRequired,
    Home:PropTypes.func.isRequired
}
function mapStateToProps(state){
    return{
        Dots:state.dot.Dots,
    };
}
function mapFunToProps(dispatch){
    return{
        Home:()=>{
            window.sessionStorage.clear();
        }
    }
}
export const MainTable = connect(mapStateToProps,mapFunToProps)(Table);

