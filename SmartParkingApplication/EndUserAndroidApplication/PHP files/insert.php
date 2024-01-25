<?php
	include('connection.php');
	$name=$_REQUEST['name'];
	$password=$_REQUEST['password'];
$carno=$_REQUEST['carno'];
$conno=$_REQUEST['contactno'];
$licno=$_REQUEST['licno'];


	$flag['code']=0;
    $sql="INSERT INTO `user`(`userpwd`, `uname`, `contactno`, `dlicense`) VALUES ('$password','$name','$conno','$licno')";
	$statement1 = $dbh->prepare($sql);
	$statement1->execute();
	$id=$dbh->lastInsertId();
	
	$sql2="INSERT INTO `user_cars`(`userid`, `carno`) VALUES ('$id','$carno')";
	$statement2 = $dbh->prepare($sql2);

if ($statement2->execute())

	
	{
		$flag['code']=1;
		echo"hi";
	}

	print(json_encode($flag));
	$dbh = null;
?>
