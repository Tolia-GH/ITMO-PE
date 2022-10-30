<?php
echo "Hello";

$X=array();
$Y=$R="";

if($_SERVER["REQUEST_METHOD"] == "POST") {
    $X = $_POST["arrayX[]"];
    $Y = $_POST["Y"];
    $R = $_POST["R"];
    echo $Y;
}

