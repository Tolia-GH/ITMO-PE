<?php
echo "Hello";

$X=array();
$Y=$R="";

if($_SERVER["REQUEST_METHOD"] == "GET") {
    $X = $_GET["arrayX"];
    $Y = $_GET["Y"];
    $R = $_GET["R"];
    echo $X[0];
    echo $Y;
    echo $R;
}

