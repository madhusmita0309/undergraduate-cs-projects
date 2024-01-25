<?php
	//Start session
 
	session_start();	
	//Unset the variables stored in session
	unset($_SESSION['adminid']);
	unset($_SESSION['adminpwd']);
	   
session_name('LoginForm');

include('connection.php');	
?>
<!DOCTYPE html>	
<head>
	<title>Smart Park - Login</title>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="-1"> 
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
		<!--//webfonts-->
</head>
<body>
<?php

	$error = '';
if(isset($_POST['is_login'])){
$i=$_POST['adminid'];
  $p=$_POST['adminpwd'];
 
$query = "SELECT id,adminpwd FROM admin WHERE adminid='$i'";
$statement = $dbh->prepare($query);
$statement->execute();
$result = $statement->fetch();
$passwd=$result["adminpwd"];

	if((!empty($passwd))&&($passwd==$p)){
//session_start();
$_SESSION['id']=$result["id"];
$_SESSION['username']=$i;
header('Location: start.php');
exit();
}
else{
			$error = 'Wrong Username or Password.';
	}}
?>
<!-----start-main---->
				<div class="login-form">
					<div class="head">
						<img src="images/prof.png" alt=""/>
						
					</div>


				<form name="loginform" action="index.php" method="post">
				<input type="hidden" name="is_login" value="1">
					<li>
						<input type="text" class="text" id="idadmin" name="adminid" placeholder="USERNAME" required /><a href="#" class=" icon user"></a>
					</li>
					<li>
					
						<input type="password" name="adminpwd" id="idpwd"  placeholder="PASSWORD" required /><a href="#" class=" icon lock"></a>
					</li>
				<?php if($error) { ?>
	                	<em>
					<label for="idadmin" style="display: block;"><?php echo $error ?></label>
				</em>
				<?php } ?>
					<div class="p-container">
								
								<input type="submit" value="SIGN IN" >
							<div class="clear"> </div>
					</div>
				</form>
			</div> 
</body>
</html>