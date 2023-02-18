

function submitData() {
    dataCheck()

    document.getElementById("hiddenForm").submit();
}

function dataCheck() {
    let x, checkedX = false;
    let y, checkedY = false;
    let r, checkedR = false;

    let xRadio = document.getElementsByName("X");
    for (let i = 0; i < xRadio.length; i++) {
        if (xRadio[i].checked) {
            x = xRadio[i].value;
            checkedX = true;
        }
    }
    if (!checkedX) {
        document.getElementById("errorX").innerText = "Error: X can not be null!"
        return false;
    }

    let yText = document.getElementById("Y").value;
    if (yText === "" || yText === null || isNaN(yText)) {
        document.getElementById("errorY").innerText = "Error: Y can not be null!"
        return false;
    } else {
        if (yText < -5 || yText > 5){
            document.getElementById("errorY").innerText = "Error: Y out of range!"
            return false;
        } else {
            y = yText;
            checkedY = true;
        }
    }

    let rRadio = document.getElementsByName("R");
    for (let i = 0; i < rRadio.length; i++) {
        if (rRadio[i].checked) {
            r = rRadio[i].value;
            checkedR = true;
        }
    }
    if (!checkedR) {
        document.getElementById("errorR").innerText = "Error: R can not be null"
        return false;
    }

    if (checkedX || checkedY || checkedR) {
        setHiddenForm(x,y,r)
    }
}

function setHiddenForm(x,y,r) {
    x_hidden_id.value = x;
    y_hidden_id.value = y;
    r_hidden_id.value = r;

    //document.getElementById("x_hidden_id").value = x;
    //document.getElementById("y_hidden_id").value = y;
    //document.getElementById("r_hidden_id").value = r;
}