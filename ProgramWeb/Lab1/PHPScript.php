<?php
$X = array();
$Y = $R = "";
if($_SERVER["REQUEST_METHOD"] == "GET") {
    $X = $_GET["X"];//In the HTML file 'name = X[]', but here in the $_GET[] the name string can not involve symbol '[]'
    $Y = $_GET["Y"];
    $R = $_GET["R"];

    echo $X[0];
    echo $Y;
    echo $R;
}

