<?php
session_start();//use session to store all the results
error_reporting(0);
?>

<!DOCTYPE html>
<html lang = "en">
    <head>
        <meta charset = "UTF-8">
        <title>Студент: Чжоу Хунсян P32131 Вариант: 1320</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>

    <body>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"></script>
        <script type="application/javascript">

            function check() {
                let checkBox = document.getElementsByName("arrayX[]");
                let arrayX = [];
                let pinX = 0;

                for (let i=0; i<checkBox.length; i++) {
                    if (checkBox[i].checked) {
                        arrayX[pinX++] = checkBox[i].value;
                    }
                }
                if (pinX === 0) {
                    alert("You should input at least 1 value of X!");
                    return false;
                }

                let Y = document.getElementById("valueOfY").value;
                if (Y === "" || Y === null || isNaN(Y)) {
                    alert("Y can not be null");
                    return false;
                } else if (Y > 3 || Y < -3) {
                    alert("Value out of range!");
                    return false;
                }

                let R=-1;
                let checkR = false
                let radioR = document.getElementsByName("R");

                for (let i=0; i<radioR.length; i++) {
                    if (radioR[i].checked) {
                        R=radioR[i].value;
                        checkR = true;
                    }
                }

                if (checkR === false) {
                    alert("R can not be null!");
                    return false;
                }

                //alert(pinX);
                return true;
            }

            $(function() {
                $('#myForm').submit(function (form_listener) {
                    form_listener.preventDefault();

                    $.ajax({
                        type : "GET",
                        url : "PHPScript.php",
                        data : $(this).serialize(),

                        success : function (data) {
                            $('#resultTable').html(data);
                        }
                    });
                });
            });
        </script>

        <h1>
            Студент: Чжоу Хунсян P32131 <br> Вариант: 1320
        </h1>

        <h2>
            Lab 1
        </h2>

        <form id = "myForm" method = "get" name="myForm" action="PHPScript.php">
            <fieldset>
                <legend class="InputX">
                    Please choose value of X<span class = "required">*</span>
                </legend>
                <div class = "InputX">
                    <label>
                        <input type="checkbox" value="-3" name="arrayX[]">-3
                        <input type="checkbox" value="-2" name="arrayX[]">-2
                        <input type="checkbox" value="-1" name="arrayX[]">-1
                        <input type="checkbox" value="0" name="arrayX[]">0
                        <input type="checkbox" value="1" name="arrayX[]">1
                        <input type="checkbox" value="2" name="arrayX[]">2
                        <input type="checkbox" value="3" name="arrayX[]">3
                        <input type="checkbox" value="4" name="arrayX[]">4
                        <input type="checkbox" value="5" name="arrayX[]">5
                    </label>
                </div>
            </fieldset>

            <fieldset>
                <legend class="inputY">
                    Please input value of Y<span class = "required">*</span>
                </legend>
                <div class = "inputY">
                    <label>
                        <input type="text" placeholder="from -3 to 3" id="valueOfY" name = "Y">
                    </label>
                </div>
            </fieldset>

            <fieldset>
                <legend class="InputR">
                    Please choose value of R<span class = "required">*</span>
                </legend>
                <div class = "InputR">
                    <label>
                        <input type="radio" value="1" name="R">1
                        <input type="radio" value="1.5" name="R">1.5
                        <input type="radio" value="2" name="R">2
                        <input type="radio" value="2.5" name="R">2.5
                        <input type="radio" value="3" name="R">3
                    </label>
                    
                </div>
            </fieldset>

            <div class="submit">
                <input type="submit" name="submit" value="Submit" onclick="return check()">
            </div>

        </form>

        <div class = "range">
            <img src="WX20221019-113638.png" alt="range">
        </div>

        <div class = "output">
            <p id="result">Result:</p>

            <div id="resultTable">
                <?php
                $currentTime = date("d-m-Y H:i:s", time());
                $tableResult = "<table id=\"main_table\" class=\"super_table\" border=\"3\">
                    <tr>
                        <th>X:</th>
                        <th>Y:</th>
                        <th>R:</th>
                        <th>Попадание:</th>
                        <th>Время работы:</th>
                    </tr>";
                foreach ($_SESSION['history'] as $line) {
                    $tableResult.=
                        "<tr>
                            <td>$line[0]</td>
                            <td>$line[1]</td>
                            <td>$line[2]</td>
                            <td>$line[3]</td>
                            <td>$line[4]</td>
                        </tr>";
                }
                $tableResult.="</table>";
                echo $tableResult;
                echo "<p>Current Time: $currentTime</p>";
                ?>
            </div>

        </div>
    </body>
</html>