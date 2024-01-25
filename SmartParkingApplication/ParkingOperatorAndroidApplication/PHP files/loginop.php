<?php
include('connection.php');	
//$error = '';
//$flag['code']=0;
 
$username = $_POST['username'];
$password = $_POST['password'];
 
$sql = "select oppwd from operator where opname='$username'";
 $statement = $dbh->prepare($sql);
 if($statement->execute())
 {
$result = $statement->fetch();


$passwd=$result["oppwd"];

	if((!empty($passwd))&&($passwd==$password)){
//session_start();
        //$flag['code']=1;
		echo 'success';
 }}
 else
	 echo 'failure';
 
?>
