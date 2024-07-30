export const Actions={
    GET_FORM_X:'GET_FORM_X',
    GET_FORM_Y:'GET_FORM_Y',
    GET_FORM_R:'GET_FORM_R',
    SUBMIT_FORM:'SUBMIT_FORM',
    ADD_DOT:'ADD_DOT',
    GET_USERNAME:'GET_USERNAME',
    GET_PASSWORD:'GET_PASSWORD',
    LOG_IN:'LOG_IN',
    READ_ACCOUNT:'READ_ACCOUNT',
    CLEAR_DOTS:'CLEAR_DOTS'
}
export function GetX(x){
    return{
        type:Actions.GET_FORM_X,
        x:x,//int
    }
}
export function GetY(y){
    return{
        type:Actions.GET_FORM_Y,
        y:y,//double
    }
}
export function GetR(r){
    return{
        type:Actions.GET_FORM_R,
        r:r,//int
    }
}
export function getUsername(username){
    return{
        type:Actions.GET_USERNAME,
        username:username,
    }
}
export function getPassword(password){
    return{
        type:Actions.GET_PASSWORD,
        password:password
    }
}
export function addDot(x,y,r,hit,date){
    return{
        type:Actions.ADD_DOT,
        x:x,
        y:y,
        r:r,
        hit:hit,
        date:date
    }
}
export function readAccount(username,password){
    return{
        type:Actions.READ_ACCOUNT,
        password:username,
        username:password
    }
}
export function clearDots() {
    return {
        type:Actions.CLEAR_DOTS
    }
}