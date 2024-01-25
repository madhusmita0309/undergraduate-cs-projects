<?php
 session_start();
$i=$_SESSION["id"];

try{
include('connection.php');
//update parking area
$pn=$_POST['name1'];
$sql1="SELECT `pid`,`total_slots` from `parkingarea` where adminid='$i' and pname='$pn'";
$statement1 = $dbh->prepare($sql1);

if($statement1->execute())
{   // successful reading of old number of parking slots
$res1=$statement1->fetch();
$pid=$res1['pid'];
$res1=$res1['total_slots'];   //old number of slots in res1
//echo for testing purposes
echo 'Old slots: '.$res1.'<br>';
$sql2 = "UPDATE `parkingarea` SET `pname`='".$_POST["name1"]."',`addr`='".$_POST["address1"]."',`area`='".$_POST["area1"]."',`total_slots`='".$_POST["slots1"]."',`available_slots`='".$_POST["slots1"]."',`price`='".$_POST["price1"]."',`fine`='".$_POST["fine1"]."',`lat`='".$_POST["lat1"]."',`lon`='".$_POST["lon1"]."'
WHERE pid='$pid'";
$statement2 = $dbh->prepare($sql2);

if ($statement2->execute()) 
{ //successful update in parkingarea
//updating parkinglots
$res2=$_POST['slots1'];   //updated number of slots in res2
//echo for testing purposes
echo 'New slots: '.$res2.'<br>';

if ($res2>$res1)  //slots increased
{
	$dif=$res2-$res1;
	for($a=($res1+1); $a<=$res2;$a++)
	{
		$sql3="INSERT INTO `parkinglots` (`pid`,`slot_no`)VALUES ('$pid','$a')";
      //$dbh->query($sql3);
        $statement3= $dbh->prepare($sql3);
        $statement3->execute();
	}
	//echo for testing purposes
		$msg=$dif.' new slots added';
	echo $msg;
}
elseif($res2<$res1)  //slots decreased
{
	$dif=$res1-$res2;
	$sql4="DELETE FROM `parkinglots` WHERE pid='$pid' AND slot_no>$res2";
      //$dbh->query($sql3);
        $statement4= $dbh->prepare($sql4);
        $statement4->execute();
	//echo for testing purposes	
	$msg=$dif.' slots removed';
	echo $msg;
}
else  //can be commented
{
	//echo for testing purposes
	$msg='No change in number of slots';
	echo $msg;
}

	?>

<script type= 'text/javascript'>
var c=confirm("Record Updated Successfully!");
if(c==true){window.location.assign("start.php")}
</script>

<?php
}
else{  //failure of query2
echo $statement1->errorCode().'<br>';
?>

<script type= 'text/javascript'>
var c=confirm("Record could not be updated succesfully. Try again in a while.");
if(c==true){window.location.assign("http://localhost/website6/start.php")}
</script>
<?php	
	
	
} // end of query 2
}
else{ 
//failure of query1

echo $statement1->errorCode().'<br>';
?>

<script type= 'text/javascript'>
var c=confirm("Record could not be updated succesfully. Try again in a while.");
if(c==true){window.location.assign("start.php")}
</script>
<?php
}
$dbh = null;
}
catch(PDOException $e)
{
echo $e->getMessage();
}
//header('Location: http://localhost/smartpark/index.html');

?>