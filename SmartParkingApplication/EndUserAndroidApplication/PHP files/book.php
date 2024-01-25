<?php 
include('connection.php');
$userid=/*11*/ $_POST['userid'];
$carno=/*'MH04BQ7186'*/ $_POST['carno'];
$h=$_POST['hrs'];
$m=$_POST['mins'];
//$duration=/*'02:00:00'*/ $_POST['duration'];
$pid=/*1*/ $_POST['locationid'];
$ok='null';
if($m>=0 && $m<60)
{if($m==0)
	{if($h>0 && $h<5)
		$ok='yes';
	else
		$ok='no';}
	else
	{if($h>0 && $h<4)
		$ok='yes';
	else
		$ok='no';}
}
  if($ok=='yes'){
	  $duration=$h.':'.$m;
	  
$sql="SELECT COUNT(*) AS ct FROM `parkingsession` where userid='$userid' and status='reserved'";
  $stmt = $dbh->prepare($sql);
  $stmt->execute();
  $a=$stmt->fetch();
  $a=$a['ct'];
 if($a==0){ 
$sql1="SELECT `available_slots` FROM `parkingarea` WHERE pid='$pid'";
  $stmt1 = $dbh->prepare($sql1);
  $stmt1->execute();
  $b=$stmt1->fetch();
  $b=$b['available_slots'];
  //echo 'Slots available: '.$a.'<br>';
  if($b>0){
  try{
  $dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$dbh->beginTransaction();
//decrease availability - parking area
  $sql1="UPDATE `parkingarea` SET available_slots=available_slots-1 WHERE pid='$pid'";
  $stmt1 = $dbh->prepare($sql1);
  $stmt1->execute();
 
 //search for 1st available slot in parkinglots
 $sql2="SELECT `slot_no` FROM `parkinglots` WHERE pid='$pid' AND status='available'";
  $stmt2 = $dbh->prepare($sql2);
  $stmt2->execute();
  $b=$stmt2->fetch();
  $b=$b['slot_no'];  //selected slot no
 // echo 'Available slot_no: '.$b.'<br>';
  //update status of location slot 'b'
  $sql3="UPDATE `parkinglots` SET status='booked' WHERE pid='$pid' AND slot_no='$b'";
  $stmt3 = $dbh->prepare($sql3);
  $stmt3->execute();
   //make reservation in parking session
   $sql4="INSERT INTO `parkingsession`(`userid`, `carno`, `duration`, `logged`,`pid`, `slot_no`) VALUES ('$userid','$carno','$duration',NOW(),'$pid','$b')";
  $stmt4 = $dbh->prepare($sql4);
  $stmt4->execute();
  //retrieve session id of new session
  $id=$dbh->lastInsertId();   //session id
 // echo 'Session id : '.$id.'<br>';
    //update parkinglots session id
  $sql5="UPDATE `parkinglots` SET `sessionid`='$id' WHERE `pid`='$pid' AND `slot_no`='$b'";
  $stmt5 = $dbh->prepare($sql5);
  $stmt5->execute(); 
  echo $id;
   
  $dbh->commit();
  }

 catch (Exception $e) {
  $dbh->rollBack();
  //echo "Failed: " . $e->getMessage();
  echo '0';
   }
  }
  else
	  echo 'noslots';
 }
 else
	 echo 'invalid';
  }
  else 'badtime';
?>