import {Actions} from "../action/action";
import {AccountRegisterState, DotsState} from "../state/state";
import {combineReducers} from "redux";

function addDotReducer(state=DotsState,action){
    switch (action.type) {
        //浅拷贝
        case Actions.CLEAR_DOTS:
            return {...state, Dots: []}
        case Actions.GET_FORM_X:
            return Object.assign({},state,{X:action.x});
        case Actions.GET_FORM_Y:
            return Object.assign({},state,{Y:action.y});
        case Actions.GET_FORM_R:
            return Object.assign({},state,{R:action.r});
        case Actions.GET_PASSWORD:
            return Object.assign({},state,{password:action.password});
        case Actions.GET_USERNAME:
            return Object.assign({},state,{username:action.username});
        case Actions.READ_ACCOUNT:
            return Object.assign({},state,{username:action.username,password:action.username});
        case Actions.ADD_DOT:
            let dot = {
                x:action.x,
                y:action.y,
                r:action.r,
                hit:action.hit,
                date:action.date
            }
            /*let string = "";
            state.Dots.forEach((ele,key)=>{
                string = string+ele.x;
            });
            alert(string);*/
            return Object.assign({},state,{Dots:state.Dots.concat([dot])});
        default:
            return state
    }
}
function accountRegisterReducer(state=AccountRegisterState,action) {
    switch (action.type) {
        case Actions.GET_PASSWORD:
            return Object.assign({}, state, {password_account: action.password});
        case Actions.GET_USERNAME:
            return Object.assign({}, state, {username_account: action.username});
        case Actions.READ_ACCOUNT:
            return Object.assign({}, state, {username_account: action.username, password_account: action.username});
        default:
            return state;
    }
}
export const allReducers = combineReducers({
    account:accountRegisterReducer,
    dot:addDotReducer
}
);