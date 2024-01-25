<?php

header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
header("Cache-Control: post-check=0, pre-check=0", false);
header("Pragma: no-cache");
?>
<?php 
session_start();
if(isset($_SESSION['id']) ) { ?>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Smart Park - Home</title>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="-1"> 
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Smart Park </title>
	<!-- core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.transitions.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
	<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
	<!--<script src="http://maps.googleapis.com/maps/api/js"></script>-->
</head><!--/head-->

<body id="home" class="homepage">

    <header id="header">
        <nav id="main-menu" class="navbar navbar-default navbar-fixed-top" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="images/sp1.png" alt="logo" width="169" height="57"></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="scroll active"><a href="#home">Home</a></li>
                        <li class="scroll"><a href="#features">Features</a></li>
                        <!--<li class="scroll"><a href="#services">Services</a></li>
                        <li class="scroll"><a href="#portfolio">Portfolio</a></li>-->
                        <li class="scroll"><a href="#about">About</a></li>
                        <!--<li class="scroll"><a href="#meet-team">Team</a></li>
                        <li class="scroll"><a href="#pricing">Pricing</a></li>-->
                        <li class="scroll"><a href="#blog">Blog</a></li> 
                        <li class="scroll"><a href="#get-in-touch">Contact</a></li>           
						<li class="scroll"><a href="logout.php">Logout</a></li> 
						<li style="font-family:Georgia,serif; font-size:15px; align:right"><?php echo 'Hello, '.$_SESSION['username'].'!';?></li>        
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
    </header><!--/header-->

    <section id="main-slider">
        <div class="owl-carousel">
            <div class="item" style="background-image: url(images/slider/smartpark2.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h2><br><span><br></span></h2>
                                    <p> <br></p>
                                   &nbsp &nbsp<!-- <a class="btn btn-primary btn-lg" href="#">Read More</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.item-->
             <div class="item" style="background-image: url(images/slider/smartpark3.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h2><br><span><br></span> <br></h2>
                                    <p><br><br> </p>
                                   <!-- <a class="btn btn-primary btn-lg" href="#">Read More</a> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.item-->
        </div><!--/.owl-carousel-->
    </section><!--/#main-slider-->

    <section id="features">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">Features</h2>
                <p class="text-center wow fadeInDown">Click on the links below to ADD, VIEW or EDIT a parking area.</p><br>
            </div>
            <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                    <img class="img-responsive" src="images/sp3.png" alt="" height="600px" width="800px">
                </div>
                <div class="col-sm-6">
                    <div class="media service-box wow fadeInRight">
                        <div class="pull-left">
                           <i class="fa fa-plus-circle"></i>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><a href="#add"><div class="scroll">ADD </div></a></h4>
                           </div>
                    </div>
<br>
                    <div class="media service-box wow fadeInRight">
                        <div class="pull-left">
                            <i class="fa fa-info-circle"></i>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><a href="#view"><div class="scroll">VIEW </div></a></h4>
                        							</div>
                    </div>
<br>
                    <div class="media service-box wow fadeInRight">
                        <div class="pull-left">
                            <i class="fa fa-pencil-square-o"></i>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><a href="#edit"><div class="scroll">EDIT</div></a></h4>   
                        </div>
                    </div>
<br>
                   
                </div>
            </div>
        </div>
    </section>

   	 <section id="add">
        <div class="container">
		<div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">Add a new parking area</h2>
                <p class="text-center wow fadeInDown">Kindly select the location in the map and fill the necessary parking area details in the form</p>
            </div>
   <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                  <!--<h3 class="column-title">Video Intro</h3> -->
                    <!-- 16:9 aspect ratio -->
				<!--	<div id="googleMap" style="width:450px;height:380px;"></div>-->
             <div id="googlemap1" style="width:450px;height:380px" data-latitude="19.07249772" data-longitude="72.87369159"></div>
                </div>

              <div class="col-sm-6 wow fadeInRight">
                   <!-- <h3 class="column-title">Multi Capability</h3> -->
				 
				 <div style="width:450px;height:380px;background: rgba(255, 255, 255, 0.8); padding: 20px;margin-top: 0px;">
				  
				 
				 
				<form action="add_exec.php" method="post" name="formadd" >
<table width="450px" height="380px" border="0" style="background: rgba(255, 255, 255, 0.8)">
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Name :</td> <td>&nbsp;<input type="text" name="name" size="25" required></font></td>
</tr>
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Address :</td> <td>&nbsp;<textarea rows="4" cols="25" type="text" name="address" size="25"  required></textarea></font></td>
</tr>
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Area :</td> <td>&nbsp;<input type="text" name="area" size="25" required></font></td>
</tr>
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Slots : </td> <td>&nbsp;<input type="number" min="1" step="1" name="slots" size="25" required></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Price:</td> <td>&nbsp;<input type="number" min="1.00" step="1" name="price" size="25" required></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Penalty:</td> <td>&nbsp;<input type="number" min="1.00" step="1" name="fine" size="25" required></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Latitude :</td> <td>&nbsp;<input type="number" name="lat" id="lati" size="25"></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Longitude:</td> <td>&nbsp;<input type="number" name="lon" size="25" id="longi" required></font></td>
</tr>



<tr>
  <td align="center"><input type="submit" name="Submit" value="Submit"></td><td align="left"><button type="reset" value="Reset">Reset</button></td>
</tr>
</table>

  </form>
 	</div>		   
				   
                    
                </div>
            </div>
        </div>
    </section><!--/#add-->


	<section id="view">
        <div class="container">
		<div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">View the Parking Area</h2>
		<div id="input" style="display: none"> 
		<?php
include('connection.php');	
//Initialize your first couple variables
$encodedString = ""; //This is the string that will hold all your location data
$x = 0; //This is a trigger to keep the string tidy
 
//Now we do a simple query to the database
//$result = mysql_query("SELECT * FROM `big-ten`");
$sql1 = "SELECT * FROM parkingarea";
$statement = $dbh->prepare($sql1);
$statement->execute();
$res1 = $statement->fetchAll(); 
//Multiple rows are returned
foreach($res1 as $row) {
    if ( $x == 0 )
    {
         $separator = "";
    }
    else
    {
         //Each row in the database is separated in the string by four *'s
         $separator = "****";
    }
    //Saving to the String, each variable is separated by three &'s
    $encodedString = $encodedString.$separator.
    "<p><b>Name:</b> ".$row[1].
    "<br><b>Address:</b> ".$row[2].
    "<br><b>Area:</b>".$row[3].
    "<br><b>Total slots: </b>".$row[4].
    "<br><b>Price: </b>".$row[6].
	 "<br><b>Penalty: </b>".$row[7].
	"<br><b>Lat: </b>".$row[8].
	"<br><b>Long: </b>".$row[9].
    "</p>&&&".$row[8]."&&&".$row[9];
    $x = $x + 1;
}
?>
           <input type="hidden" id="encodedString" name="encodedString" value="<?php echo $encodedString; ?>" /></div>
            </div>
   <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                  <!--<h3 class="column-title">Video Intro</h3> -->
                    <!-- 16:9 aspect ratio -->
				<!--	<div id="googleMap" style="width:450px;height:380px;"></div>-->
             <div id="googlemap3" style="width:1000px;height:470px" data-latitude="19.2184" data-longitude="73.0867"></div>
                </div>

            </div>
        </div>
    </section><!--/#view-->
	  

<section id="edit">
        <div class="container">
		<div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">Edit a Parking Area</h2>
                <p class="text-center wow fadeInDown">Kindly select the location in the map and edit the necessary parking area details in the form</p>
				<div id="input" style="display: none"> 
		<?php
include('connection.php');	
//Initialize your first couple variables
$encodedString4 = "";//This is the string that will hold all your location data
$encodedString5 = ""; 
$y = 0; //This is a trigger to keep the string tidy
$a= $_SESSION['id'];
//Now we do a simple query to the database
//$result = mysql_query("SELECT * FROM `big-ten`");
$sql4= "SELECT * FROM parkingarea where adminid=$a";
$statement4 = $dbh->prepare($sql4);
$statement4->execute();
$res4 = $statement4->fetchAll(); 
//var $row4=array();
//Multiple rows are returned
foreach($res4 as $row4) {
    if ( $y == 0 )
    {
         $separator4 = "";
    }
    else
    {
         //Each row in the database is separated in the string by four *'s
         $separator4 = "****";
    }
    //Saving to the String, each variable is separated by three &'s
    $encodedString4 = $encodedString4.$separator4.
    "<p><b>Name:</b> ".$row4[1].
    "<br><b>Address:</b> ".$row4[2].
    "<br><b>Area:</b>".$row4[3].
    "<br><b>Total slots: </b>".$row4[4].
    "<br><b>Price: </b>".$row4[6].
	"<br><b>Penalty: </b>".$row4[7].
	"<br><b>Lat: </b>".$row4[8].
	"<br><b>Long: </b>".$row4[9].
    "</p>&&&".$row4[8]."&&&".$row4[9];
	
	$encodedString5 = $encodedString5.$separator4.
    $row4[1]."#".$row4[2]."#".$row4[3]."#".$row4[4]."#".$row4[6]."#".$row4[7]."#".$row4[8]."#".$row4[9];
	
	
    $y= $y + 1;
}
?>
           <input type="hidden" id="encodedString4" name="encodedString4" value="<?php echo $encodedString4; ?>" />
		   <input type="hidden" id="encodedString5" name="encodedString5" value="<?php echo $encodedString5; ?>" /></div>
            </div>
   <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                  <!--<h3 class="column-title">Video Intro</h3> -->
                    <!-- 16:9 aspect ratio -->
				<!--	<div id="googleMap" style="width:450px;height:380px;"></div>-->
             <div id="googlemap4" style="width:450px;height:380px" data-latitude="19.07249772" data-longitude="72.87369159"></div>
                </div>

              <div class="col-sm-6 wow fadeInRight">
                   <!-- <h3 class="column-title">Multi Capability</h3> -->
				 
				 <div style="width:450px;height:380px;background:rgba(255, 255, 255, 0.8); padding: 20px;margin-top:0px">
				  
				 
				 
				<form  action="edit_exec.php" name="formedit" method="post">
<table width="450px" height="380px" border="0" style="background: rgba(255, 255, 255, 0.8)">
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Name :</td> <td>&nbsp;<input type="text" name="name1" id="name2" size="25" ></font></td>
</tr>
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Address :</td> <td>&nbsp;<textarea rows="4" cols="25" type="text" name="address1" id="addr2" size="25"  ></textarea></font></td>
</tr>
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Area :</td> <td>&nbsp;<input type="text" name="area1" id="area2" size="25" ></font></td>
</tr>
<tr><td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Slots : </td> <td>&nbsp;<input type="number" min="1" step="1" name="slots1" id="slots2" size="25" ></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Price:</td> <td>&nbsp;<input type="number" min="1.00" step="1" name="price1" id="price2" size="25" ></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Penalty:</td> <td>&nbsp;<input type="number" min="1.00" step="1" name="fine1" id="fine2" size="25" required></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Latitude :</td> <td>&nbsp;<input type="text" name="lat1" id="lat2" size="25"></font></td>
</tr>
<tr>
  <td>&nbsp;<font style="font-family: 'Roboto', sans-serif;font-size:21px;text-align:center;" color = "BLACK"> Longitude:</td> <td>&nbsp;<input type="text" name="lon1" size="25" id="lon2" ></font></td>
</tr>



<tr>
  <td align="center"><input type="submit" name="Submit" value="Submit"></td><td align="left"><button type="reset" value="Reset">Reset</button></td>
</tr>
</table>

  </form>
 	</div>		   
				   
                    
                </div>
            </div>
        </div>
    </section><!--/#edit-->		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    <section id="about">
        <div class="container">
		<div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">About Us</h2>
                <p class="text-center wow fadeInDown">Smart Park- a way to hassle-free parking. <br>
				Ours is a platform that allows collaboration between parking area owners and the general populace. It allows parking area owners to define the details in a central repository 
				and allows users to book the parking slots based on the availability. </p>
            </div>

  </div>
    </section>
 <section id="blog">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">Latest Blogs</h2>
                <p class="text-center wow fadeInDown"></p>
            </div>

            <div class="row">
                <div class="col-sm-6">
                    <div class="blog-post blog-large wow fadeInLeft" data-wow-duration="300ms" data-wow-delay="0ms">
                        <article>
                            <header class="entry-header">
                                <div class="entry-thumbnail">
                                    <img class="img-responsive" src="images/blog/image1.jpg" alt="" width="555" height="303">
                                    <span class="post-format post-format-video"><i class="fa fa-newspaper-o"></i></span>
                                </div>
                                <div class="entry-date">25 November 2014</div>
                                <h2 class="entry-title"><a href="#">The Future of Smart Cities- Opportunities,Solutions & Players</a></h2>
                            </header>

                            <div class="entry-content">
                                <P>Strategy Analysts forecast the urban advancement on a rise. With the development of IoT & Smart Parking, lighting smart cities are no far!</P>
                                <a class="btn btn-primary" href="#">Read More</a>
                            </div>

                            <footer class="entry-meta">
                                <span class="entry-author"><i class="fa fa-pencil"></i> <a href="#">Author</a></span>
                                <span class="entry-category"><i class="fa fa-folder-o"></i> <a href="#">NewsCorner</a></span>
                                <span class="entry-comments"><i class="fa fa-comments-o"></i> <a href="#">15</a></span>
                            </footer>
                        </article>
                    </div>
                </div><!--/.col-sm-6-->
                <div class="col-sm-6">
                    <div class="blog-post blog-media wow fadeInRight" data-wow-duration="300ms" data-wow-delay="100ms">
                        <article class="media clearfix">
                            <div class="entry-thumbnail pull-left">
                                <img class="img-responsive" src="images/blog/image2.png" alt="" width="263" height="301">
                                <span class="post-format post-format-gallery"><i class="fa fa-image"></i></span>
                            </div>
                            <div class="media-body">
                                <header class="entry-header">
                                    <div class="entry-date">01 December 2014</div>
                                    <h2 class="entry-title"><a href="#">Smart Park on the roll! </a></h2>
                                </header>

                                <div class="entry-content">
                                    <P>With the idea of smart cities catching up heat, Smart Park has opened a new chapter of advancement</P>
                                    <a class="btn btn-primary" href="#">Read More</a>
                                </div>

                                <footer class="entry-meta">
                                    <span class="entry-author"><i class="fa fa-pencil"></i> <a href="#">Campbell</a></span>
                                    <span class="entry-category"><i class="fa fa-folder-o"></i> <a href="#">Sci-TechNews</a></span>
                                    <span class="entry-comments"><i class="fa fa-comments-o"></i> <a href="#">20</a></span>
                                </footer>
                            </div>
                        </article>
                    </div>
                    <div class="blog-post blog-media wow fadeInRight" data-wow-duration="300ms" data-wow-delay="200ms">
                        <article class="media clearfix">
                            <div class="entry-thumbnail pull-left">
                                <img class="img-responsive" src="images/blog/image3.jpg" alt="" width="263" height="301">
                                <span class="post-format post-format-audio"><i class="fa fa-taxi"></i></span>
                            </div>
                            <div class="media-body">
                                <header class="entry-header">
                                    <div class="entry-date">03 November 2014</div>
                                    <h2 class="entry-title"><a href="#">Cisco Analysis on connected-city traffic</a></h2>
                                </header>

                                <div class="entry-content">
                                    <P>Traffic in urban cities on a rise.Solutions leading to smarter outlooks</P>
                                    <a class="btn btn-primary" href="#">Read More</a>
                                </div>

                                <footer class="entry-meta">
                                    <span class="entry-author"><i class="fa fa-pencil"></i> <a href="#">Ruth</a></span>
                                    <span class="entry-category"><i class="fa fa-folder-o"></i> <a href="#">SmartCity</a></span>
                                    <span class="entry-comments"><i class="fa fa-comments-o"></i> <a href="#">35</a></span>
                                </footer>
                            </div>
                        </article>
                    </div>
                </div>
            </div>

        </div>
    </section>
 <section id="get-in-touch">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">Get in Touch</h2>
                <p class="text-center wow fadeInDown"></p>
            </div>
        </div>
    </section><!--/#get-in-touch-->
    <section id="contact">
        <div id="googlemap2" style="height:650px" data-latitude="19.0514283" data-longitude="72.89072720000001"></div>
        <div class="container-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-8">
                        <div class="contact-form">
                            <h3>Contact Info</h3>

                            <address>
                              <strong>Smart Park, Inc.</strong><br>
                              793,Sindhi Society<br>
                              Chembur-74<br>
                              <abbr title="Phone">P:</abbr> 9833708599
                            </address>

                            <form id="main-contact-form" name="contact-form" method="post" action="#">
                                <div class="form-group">
                                    <input type="text" name="name" class="form-control" placeholder="Name" required>
                                </div>
                                <div class="form-group">
                                    <input type="email" name="email" class="form-control" placeholder="Email" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="subject" class="form-control" placeholder="Subject" required>
                                </div>
                                <div class="form-group">
                                    <textarea name="message" class="form-control" rows="8" placeholder="Message" required></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary">Send Message</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section><!--/#bottom-->

    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    &copy; 2016 Smart Park ,Inc.<!--<a target="_blank" href="http://shapebootstrap.net/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>-->
                </div>
                <!--<div class="col-sm-6">
                    <ul class="social-icons">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                        <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                        <li><a href="#"><i class="fa fa-behance"></i></a></li>
                        <li><a href="#"><i class="fa fa-flickr"></i></a></li>
                        <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-github"></i></a></li>
                    </ul>
                </div>-->
            </div>
        </div>
    </footer><!--/#footer-->

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/mousescroll.js"></script>
    <script src="js/smoothscroll.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/jquery.inview.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
<?php } else { 
header('Location:index.php');}
?>

