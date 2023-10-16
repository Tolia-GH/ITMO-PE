import React, { Component } from 'react';

class ResultTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: []
        };
    }

    componentDidMount() {
        const data = JSON.parse(window.sessionStorage.getItem('list'));
        if (data) {
            this.setState({ data });
        }

        this.interval = setInterval(() => {
            const newData = JSON.parse(window.sessionStorage.getItem('list'));
            if (newData) {
                this.setState({ data: newData });
            }
        }, 500);
    }

    componentWillUnmount() {
        clearInterval(this.interval);
    }

    render() {
        return (
            <div  className={"table_block"}>
                <table  className={"result_table"}>
                    <thead>
                    <tr>
                        <th width={60}>X</th>
                        <th width={60}>Y</th>
                        <th width={60}>R</th>
                        <th width={60}>Hit</th>
                        <th width={200}>Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.data.map((ele) => (
                        <tr>
                            <th width={60}>{ele.x}</th>
                            <th width={60}>{ele.y}</th>
                            <th width={60}>{ele.r}</th>
                            <th width={60}>{ele.hit+""}</th>
                            <th width={200}>{ele.date}</th>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

        );
    }
}

export default ResultTable;
