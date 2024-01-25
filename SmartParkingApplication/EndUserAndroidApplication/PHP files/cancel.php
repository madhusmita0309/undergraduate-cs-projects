<?php 
include('connection.php');
$id=$_REQUEST['sessionid'];

$sql="UPDATE `parkingsession` SET status='cancelled' WHERE `sessionid`='$id'";
$st=$dbh->prepare($sql);
if($st->execute())
	echo 'success';
else
	echo 'failure';


?>
