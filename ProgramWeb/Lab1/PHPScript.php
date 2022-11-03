<?php
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

    function getX() {
        return $this->x;
    }

    function getY() {
        return $this->y;
    }

    function getR() {
        return $this->r;
    }

    function getCheck() {
        return $this->check;
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

//$X = array();
//$Y = $R = "";
$count = 0;

if($_SERVER["REQUEST_METHOD"] == "POST") {

    $X = $_POST["arrayX"];//In the HTML file 'name = X[]', but here in the $_GET[] the name string can not involve symbol '[]'
    $Y = $_POST["Y"];
    $R = $_POST["R"];

    //echo "<h1>Result</h1>";

    $table = "";
    //$table = "<table border='1'>";
    //$table .= "<tr>";
    //$table .= "<td>x</td>";
    //$table .= "<td>y</td>";
    //$table .= "<td>R</td>";
    //$table .= "<td>Result</td>";
    //$table .= "<td>time</td>";
    //$table .= "<td>time used</td>";
    //$table .= "</tr>";

    $checker = new Checker($Y,$R);

    for ($i = 0; $i < count($X); $i++) {

        $checker->setX($X[$i]);
        //$table .= "<tr>";
        //$table .= "<td>$X[$i]</td>";
        //$table .= "<td>$Y</td>";
        //$table .= "<td>$R</td>";
        if ($checker->check()) {
            $dot = new Dot($X[$i],$Y,$R,true);
        } else {
            $dot = new Dot($X[$i],$Y,$R,false);
        }
        //$table .= "</tr>";
        array_push($dots, $dot);
    }

    for ($i = 0; $i < sizeof($dots); $i++) {
        $table .= "<tr>";
        $table .= "<td>" . $dots[$i]->x . "</td>";
        $table .= "<td>" . $dots[$i]->y . "</td>";
        $table .= "<td>" . $dots[$i]->r . "</td>";

        if ($dots[$i]->check) {
            $table .= "<td>Coordinate in range</td>";
        } else {
            $table .= "<td>Coordinate out of range</td>";
        }

        $endTime = microtime(true);
        $runTime = ($endTime-$startTime)*1000 . ' ms';

        $table .= "<td>$runTime</td>";
        date_default_timezone_set("Europe/Moscow");
        $table .= "<td>" . date("d-m-Y H:i:s", time()) . "</td>";
        $table .= "</tr>";
    }

    $table .= "</table>";
    echo $table;

    //date_default_timezone_set("Europe/Moscow");
    //echo date("Y-m-d H:i:s", time());

    //echo $runTime;
}

