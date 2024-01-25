<?php 
include('connection.php');
$ssid=$_POST['sessionid']/*2*/;
$carno=$_POST['carno']/*'MH04BQ7186'*/;

$sql="SELECT `status` from `parkingsession` WHERE sessionid='$ssid' AND carno='$carno'";
  $stmt = $dbh->prepare($sql);
  $stmt->execute();
  $res=$stmt->fetch();
  $status=$res['status'];
  if($status=='ongoing')
  {	  
  try{
$dbh->beginTransaction();
//enter out time for session
$sql1="UPDATE `parkingsession` SET `outtime`=NOW(),`status`='finished' WHERE sessionid='$ssid' AND status='ongoing'";
  $stmt1 = $dbh->prepare($sql1);
  $stmt1->execute();
//retrieve intime, outtime and pid  
$sql2="SELECT `pid`,`slot_no`,`intime`,`outtime`,HOUR(`duration`) as hr, MINUTE(`duration`) as mn from `parkingsession` WHERE sessionid='$ssid'";
  $stmt2 = $dbh->prepare($sql2);
  $stmt2->execute();
  $res=$stmt2->fetch();
  $pid=$res['pid'];
  $slotno=$res['slot_no'];
  $in=$res['intime'];
  $out=$res['outtime'];
  $hr=$res['hr'];
  $mn=$res['mn'];
 //  echo $in.' '.$out.'<br>';
//retrieve price per hour   
   $sql3="SELECT `price`,`penalty` FROM `parkingarea` WHERE pid='$pid'";
  $stmt3 = $dbh->prepare($sql3);
  $stmt3->execute(); 
  $res2=$stmt3->fetch();
  $price=$res2['price'];  
  $penalty=$res2['penalty'];
//echo 'Price per hour : '.$price.'<br>';
//echo 'Penalty per hour : '.$penalty.'<br>';
 //calculate bill 
   $in=strtotime($in);
   $out=strtotime($out);
   $duration=$hr*60+$mn;
   $diff=$out-$in;   //in seconds
   $diff=(int)($diff/60);  //in minutes round off
   if($diff<60)
   {
	   $hrs=0;
	   $min=$diff;
	}
	else
	{
		$hrs=(int)($diff/60);
		$min=$diff%60;
	}
 //  echo 'Hours : '.$hrs.'<br>';
 //  echo 'Minutes : '.$min.'<br>';
 //  echo 'Duration : '.$duration.'<br>';
 //  echo 'Diff : '.$diff.'<br>';
   
   $tot=($hrs*$price)+($min/60)*$price;
   $msg='Usage charge : '.$tot.'<br>';
   //check for penalty
   if($diff>$duration)
   { $p=(($diff-$duration)/60)*$penalty;
     $tot=$tot+$p;
    $msg=$msg.'Penalty imposed : '.$p.'<br>';
	}
   $tot=round($tot);
   $msg=$msg.'Total Bill : '.$tot.'<br>';  
//store bill amount
   $sql4="UPDATE `parkingsession` SET `billamt`='$tot' WHERE sessionid='$ssid'";
  $stmt4 = $dbh->prepare($sql4);
  $stmt4->execute();
  //update parkingarea - increase slots by 1
   $sql5="UPDATE `parkingarea` SET `available_slots`=available_slots+1 WHERE pid='$pid'";
  $stmt5 = $dbh->prepare($sql5);
  $stmt5->execute();
   //update parkinglots - change status
   $sql6="UPDATE `parkinglots` SET `status`='available' WHERE pid='$pid' AND slot_no='$slotno'";
  $stmt6 = $dbh->prepare($sql6);
  $stmt6->execute();
// $dbh->commit();
 
 echo $msg;
}
catch(Exception $e)
{
 $dbh->rollBack();	
 echo 'Transaction failed. Try again!';
}  
  }
  else
	  echo 'Invalid session';

?>