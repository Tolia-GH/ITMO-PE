let x,y,r;
let checkedX=false;
let checkedY=false;
let checkedR=false

function init() {
    drawGraphic();
    let table = document.getElementById("result_table");

    for (var i = 1; i < table.rows.length; i++) {
        console.log("drawing point: " +
            table.rows[i].cells[0].innerHTML + ", " +
            table.rows[i].cells[1].innerHTML + ", " +
            table.rows[i].cells[2].innerHTML + ", " +
            table.rows[i].cells[3].innerHTML + ", " +
            table.rows[i].cells[4].innerHTML + ". "
        )
        drawPoints(
            table.rows[i].cells[1].innerHTML,
            table.rows[i].cells[2].innerHTML,
            table.rows[i].cells[3].innerHTML,
            table.rows[i].cells[4].innerHTML
        )
    }
}

function submitData() {

    document.getElementById("errorR").innerText = "";
    document.getElementById("errorX").innerText = "";
    document.getElementById("errorY").innerText = "";

    console.log("Submitting data...");
    clearHiddenForm();

    let xRadio = document.getElementsByName("X");
    let yText = document.getElementById("Y").value;
    let rRadio = document.getElementsByName("R");

    if (dataCheck(xRadio,yText,rRadio)) {
        document.getElementById("hiddenForm").submit();
        console.log("Data submitted.");
        storePoint(x,y,r);
        drawPoints(x,y,r);
    }

    checkedX = false;
    checkedY = false;
    checkedR = false;
}

function dataCheck(xRadio,yText,rRadio) {

    console.log("Checking data...")

    getX(xRadio);
    getY(yText);
    getR(rRadio);

    if (checkedX && checkedY && checkedR) {
        setHiddenForm(x,y,r);
        console.log("Setting data: x=" + x + ", y=" + y + ", r=" + r);

        return true;
    } else {
        console.log("Data error!")
    }
    return false;
}

function getX(radio) {
    for (let i = 0; i < radio.length; i++) {
        if (radio[i].checked) {
            x = radio[i].value;
            checkedX = true;
            return true;
        }
    }
    if (checkedX === false) {
        document.getElementById("errorX").innerText = "Error: X can not be null!"
    }

    return false;
}

function getY(Text) {
    if (Text === "" || Text === null || isNaN(Text)) {
        document.getElementById("errorY").innerText = "Error: Y can not be null!"
        return false;
    } else {
        if (Text < -5 || Text > 5){
            document.getElementById("errorY").innerText = "Error: Y out of range!"
            return false;
        } else {
            y = Text;
            checkedY = true;
            return true;
        }
    }
}

function getR(radio) {
    for (let i = 0; i < radio.length; i++) {
        if (radio[i].checked) {
            r =  radio[i].value;
            checkedR = true;
        }
    }
    if (checkedR === false) {
        document.getElementById("errorR").innerText = "Error: R can not be null!"
    }

    return false;
}

function setHiddenForm(x,y,r) {
    document.getElementById("x_hidden_id").value = x;
    document.getElementById("y_hidden_id").value = y;
    document.getElementById("r_hidden_id").value = r;
}

function clearHiddenForm() {
    document.getElementById("x_hidden_id").value = null;
    document.getElementById("y_hidden_id").value = null;
    document.getElementById("r_hidden_id").value = null;
}

function setRadioValue(element) {
    r = element.value;
}