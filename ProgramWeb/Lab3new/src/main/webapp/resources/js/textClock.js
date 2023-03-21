window.onload=function (){
    let date = new Date();
    document.getElementById("text-clock").innerText = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate()+" "+format(date.getHours())+":"+format(date.getMinutes())+":"+format(date.getSeconds());
};
window.setInterval(function () {
    let date = new Date();
        document.getElementById("text-clock").innerText = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate()+" "+format(date.getHours())+":"+format(date.getMinutes())+":"+format(date.getSeconds());
    },
    1000
);
function format(time) {
    if (Number(time) < 10) {
        return "0" + time;
    } else return time;
}