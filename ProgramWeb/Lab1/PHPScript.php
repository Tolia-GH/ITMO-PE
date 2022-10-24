<?php
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
class Dot{
    var $x;
    var $y;
    var $r;

    function __construct($x,$y,$y)
    {
        $this->x = $x;
        $this->r = $r;
        $this->y = $y

    }
}
var $dots = array();
$startTime = microtime(true);

$X = array();
$Y = $R = "";
$count = 0;

if($_SERVER["REQUEST_METHOD"] == "GET") {

    $X = $_GET["arrayX"];//In the HTML file 'name = X[]', but here in the $_GET[] the name string can not involve symbol '[]'
    $Y = $_GET["Y"];
    $R = $_GET["R"];

    echo "<h1>Result</h1>";

    $table = "<table border='1'>";
    $table .= "<tr>";
    $table .= "<td>x</td>";
    $table .= "<td>y</td>";
    $table .= "<td>R</td>";
    $table .= "<td>Result</td>";
    $table .= "</tr>";

    $checker = new Checker($Y,$R);

    for ($i = 0; $i < count($X); $i++) {
        $checker->setX($X[$i]);
        $table .= "<tr>";
        $table .= "<td>$X[$i]</td>";
        $table .= "<td>$Y</td>";
        $table .= "<td>$R</td>";
        if ($checker->check()) {
            $table .= "<td>Coordinate in range</td>";
        } else {
            $table .= "<td>Coordinate out of range</td>";
        }
        $table .= "</tr>";
    }

    $table .= "</table>";
    echo $table;

    date_default_timezone_set("Europe/Moscow");
    echo date("Y-m-d H:i:s", time());


    $endTime = microtime(true);
    $runTime = "<br>Runtime:" . ($endTime-$startTime)*1000 . ' ms';

    echo $runTime;
}

