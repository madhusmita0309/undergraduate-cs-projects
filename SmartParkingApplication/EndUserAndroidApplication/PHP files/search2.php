<?php 
include('connection.php');
//$filter='All';
$filter=$_REQUEST["location"];

//echo $filter;
if($filter=='All')
{
 $sql="SELECT `pid`, `pname`,`available_slots` FROM `parkingarea`;";
// echo 'Mumbai';
}
else
{
	 $sql="SELECT `pid`, `pname`,`available_slots`,`price` FROM `parkingarea` WHERE area='$filter';";
}
$statement1 = $dbh->prepare($sql);
//echo $sql;
if($statement1->execute())
{
	$result=$statement1->fetchAll();
	$ans= array();
	foreach($result as $row)
	{
	//$a=$result['pid'];
	//$b=$result['pname'];
	//$c=$result['available_slots`'];
	//echo $a.' '.$b.' '.$c."<br>";
	//echo $row[0].' '.$row[1].' '.$row[2].'<br>';
	array_push($ans,
	           array('pid'=>$row[0],'pname'=>$row[1],'available_slots'=>$row[2],'price'=>$row[3]));
		}
	
	echo json_encode(array("result"=>$ans));
	
}
else
	echo 'Error occured';
?>