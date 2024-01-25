<?php
//$connect=mysql_connect("localhost","root","") or die(mysql_error());

$dbh = new PDO('mysql:host=localhost;dbname=smartpark','root','');

//mysql_select_db("smartpark") or die(mysql_error());
//echo"Connection established";
?>