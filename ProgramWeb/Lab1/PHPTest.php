<?php
echo "Hello";

$X=array();
$Y=$R="";
$delete=false;

if($_SERVER["REQUEST_METHOD"] == "GET") {
    $X = $_GET["arrayX"];
    $Y = $_GET["Y"];
    $R = $_GET["R"];
    $delete = $_GET["delete"];
    echo $X[0];
    echo $Y;
    echo $R;
    echo $delete;
}

