<?php 
include('connection.php');
//read form variables
$ssid=$_POST['sessionid']/*2*/;
$carno=$_POST['carno']/*'MH04BQ7186'*/;
try{
	 $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$dbh->beginTransaction();
//search reservation for reservatiom and retrieve status
$sql1="SELECT `status`,`pid`,`slot_no` FROM `parkingsession` WHERE `sessionid`='$ssid' AND `carno`='$carno'";
  $stmt1 = $dbh->prepare($sql1);
  $stmt1->execute();
  $res=$stmt1->fetch();
  $status=$res['status'];  //status found
  $pid=$res['pid'];
  $slotno=$res['slot_no'];
 
 if($status=='reserved')
 {
	 //update status in parking-session
	 $sql2="UPDATE `parkingsession` SET `intime`=NOW(),`status`='ongoing' WHERE sessionid='$ssid'";
  $stmt2 = $dbh->prepare($sql2);
  $stmt2->execute();
     //update status in parkinglots
	 $sql3="UPDATE `parkinglots` SET `status`='occupied' WHERE sessionid='$ssid' AND pid='$pid' AND slot_no='$slotno'";
  $stmt3 = $dbh->prepare($sql3);
  $stmt3->execute();
  
	 echo 'Session authenticated!';
 }
elseif($status=='cancelled')
{
	echo 'Session cancelled!';
}
else
{
	echo 'Session undefined';
}
 $dbh->commit();
}
catch(Exception $e)
{
 $dbh->rollBack();	
 echo 'Transaction failed. Try again!';
}

?>