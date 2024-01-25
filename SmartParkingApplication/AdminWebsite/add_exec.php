<?php
 session_start();
$i=$_SESSION["id"];

try{
include('connection.php');
//insert into parking area
$sql = "INSERT INTO `parkingarea`(`pname`, `addr`, `area`, `total_slots`, `available_slots`, `price`, `fine`,`lat`, `lon`, `adminid`) 
VALUES ('".$_POST["name"]."','".$_POST["address"]."','".$_POST["area"]."','".$_POST["slots"]."','".$_POST["slots"]."','".$_POST["price"]."','".$_POST["fine"]."','".$_POST["lat"]."','".$_POST["lon"]."','$i')";

$statement1 = $dbh->prepare($sql);

if ($statement1->execute()) { //successful insert in parkingarea
//insert into parkinglots
	
$count=$_POST['slots'];
$pn=$_POST['name'];
$sql2="SELECT pid FROM parkingarea WHERE adminid='$i' AND pname='$pn'";
$statement2 = $dbh->prepare($sql2);
$statement2->execute();
echo $i;
$result = $statement2->fetch();
$pid=$result['pid'];
for($a=1;$a<=$count;$a++)
{
  $sql3="INSERT INTO `parkinglots` (`pid`,`slot_no`)VALUES ('$pid','$a')";
  //$dbh->query($sql3);
  $statement3= $dbh->prepare($sql3);
$statement3->execute();
}	
?>

<script type= 'text/javascript'>
var c=confirm("New Record Inserted Successfully");
if(c==true){window.location.assign("start.php")}
</script>

<?php
}
else{ 
//failure

echo $statement1->errorCode();
?>

<script type= 'text/javascript'>
var c=confirm("Data could not be inserted succesfully. Try again in a while.");
if(c==true){window.location.assign("start.php")}
</script>
<?php  }
$dbh = null;
}
catch(PDOException $e)
{
echo $e->getMessage();
}
//header('Location: http://localhost/smartpark/index.html');

?>