<?php 
include('connection.php');
$uname=$_POST['username'];        /*'minla,; replace the constant with $_POST[''] */
//read data from user table
$sql1="SELECT `userid`,`contactno`,`dlicense` FROM `user` WHERE `uname`='$uname'";
  $stmt1 = $dbh->prepare($sql1);
  $stmt1->execute();
  $res1=$stmt1->fetch();
 // echo 'Userid : '.$res1['userid'].'<br>';
 // echo 'Contact no : '.$res1['contactno'].'<br>';
 // echo 'Driving license no : '.$res1['dlicense'].'<br>';
  $id=$res1['userid'];
//read data from user_cars table  
 $sql2="SELECT `carno` FROM `user_cars` WHERE `userid`='$id'";
  $stmt2 = $dbh->prepare($sql2);
  $stmt2->execute();
  $res2=$stmt2->fetch();
 // echo 'Car no : '.$res2['carno'];
 
 //packing data to send
 $ans= array();
 array_push($ans,
	           array('userid'=>$res1['userid'],'contactno'=>$res1['contactno'],'dlicense'=>$res1['dlicense'],'carno'=>$res2['carno']));

//var_dump($ans);
echo json_encode(array("result"=>$ans));

?>