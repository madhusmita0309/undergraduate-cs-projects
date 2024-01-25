<?php 
include('connection.php');
//$filter='All';
$uname=$_REQUEST["username"];

//retrieve userid

 $sql1="SELECT `userid` FROM `user` WHERE uname='$uname'";
 $stmt1 = $dbh->prepare($sql1);
 $stmt1->execute();
 $id=$stmt1->fetch();
 $id=$id['userid'];
 
// echo 'Mumbai';

	 $sql2="SELECT parkingsession.sessionid,parkingarea.pname, parkingsession.status from parkingarea, parkingsession where parkingsession.userid='$id' AND parkingarea.pid=parkingsession.pid AND parkingsession.ts =(SELECT ts from parkingsession order by ts desc limit 1)";
     $stmt2=$dbh->prepare($sql2);
	 
	 

//echo $sql;
$ans= array();
if($stmt2->execute())
{
	$result=$stmt2->fetchAll();
	
	foreach($result as $row)
	{
	//$a=$result['pid'];
	//$b=$result['pname'];
	//$c=$result['available_slots`'];
	//echo $a.' '.$b.' '.$c."<br>";
	//echo $row[0].' '.$row[1].' '.$row[2].'<br>';
	array_push($ans,
	           array('sessionid'=>$row[0],'pname'=>$row[1],'status'=>$row[2]));
		}
	
}
else
	{
	$def='NULL';
	array_push($ans,
	           array('pname'=>$def,'status'=>$def));
	}
	
	echo json_encode(array("result"=>$ans));
?>