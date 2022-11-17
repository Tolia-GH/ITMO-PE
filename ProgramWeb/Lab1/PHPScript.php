<?php
session_start();
error_reporting(0);
date_default_timezone_set('Europe/Moscow');

class Dot {
    var $x;
    var $y;
    var $r;
    var $check;

    function __construct($x, $y, $r, $check) {
        $this->x = $x;
        $this->r = $r;
        $this->y = $y;
        $this->check = $check;
    }
}

class Checker {
    var $X;
    var $Y;
    var $R;

    function __construct($Y, $R) {
        $this->Y = $Y;
        $this->R = $R;
    }

    function setX($X) {
        $this->X = $X;
    }

    function check() {
        if ($this->X <= 0 && $this->Y >= 0 && pow($this->R,2) > (pow($this->X,2)+pow($this->Y,2))) {
            return true;
        } else if ($this->X >= 0 && $this->Y >= 0 && $this->X + $this->Y <= $this->R) {
            return true;
        } else if ($this->X <= $this->R && $this->Y <= ($this->R)/2) {
            return true;
        } else{
            return false;
        }

    }
}


$startTime = microtime(true);
$dots = array();

$X = array();
$Y = $R = "";
$count = 0;

if($_SERVER["REQUEST_METHOD"] == "GET") {

    $X = $_GET["arrayX"];//In the HTML file 'name = X[]', but here in the $_GET[] the name string can not involve symbol '[]'
    $Y = $_GET["Y"];
    $R = $_GET["R"];
    $delete = $_GET["delete"];

    if ($delete) {
        echo "delete";
    }

    $checker = new Checker($Y,$R);

    for ($i = 0; $i < count($X); $i++) {

        $checker->setX($X[$i]);

        if ($checker->check()) {
            $dot = new Dot($X[$i],$Y,$R,true);
        } else {
            $dot = new Dot($X[$i],$Y,$R,false);
        }

        $dots[] = $dot;
    }

    $tableResult = "";

    for ($i = 0; $i < sizeof($dots); $i++) {

        $endTime = microtime(true);
        $runTime = ($endTime-$startTime)*1000 . ' ms';
        $currentTime = date("d-m-Y H:i:s", time());

        $after_all = [$dots[$i]->x,$dots[$i]->y,$dots[$i]->r, $dots[$i]->check ? "Есть" : "Нет", $runTime];

        //建表需要把这些数据全部传过来，最好存放在session里面
        $_SESSION['history'][] = $after_all;
        $_SESSION['time']['0'] = $currentTime;
        $tableResult = "<table id=\"main_table\" class=\"super_table\" border=\"3\"><tr><th>X:</th><th>Y:</th><th>R:</th><th>Попадание:</th><th>Время работы:</th></tr>";
        foreach ($_SESSION['history'] as $line) {
            $tableResult.="<tr><td>$line[0]</td><td>$line[1]</td><td>$line[2]</td><td>$line[3]</td><td>$line[4]</td></tr>";
        }

        $tableResult .= "</table>";
        $tableResult .= "<p>Current Time: $currentTime</p>";
    }

    echo $tableResult;
    //echo $table;

    //date_default_timezone_set("Europe/Moscow");
    //echo date("Y-m-d H:i:s", time());

    //echo $runTime;
}

