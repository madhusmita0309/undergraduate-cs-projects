<?php
include('connection.php');	
//$error = '';
//$flag['code']=0;
 
$username = $_POST['username'];
$password = $_POST['password'];
 
$sql = "select userid,userpwd from user where uname='$username'";
 $statement = $dbh->prepare($sql);
 if($statement->execute())
 {
$result = $statement->fetch();


$passwd=$result["userpwd"];

	if((!empty($passwd))&&($passwd==$password)){
//session_start();
        //$flag['code']=1;
		echo 'success';
 }}
 else
	 echo 'failure';
 
?>
