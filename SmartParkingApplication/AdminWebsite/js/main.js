jQuery(function($) {'use strict';

	// Navigation Scroll
	$(window).scroll(function(event) {
		Scroll();
	});

	$('.navbar-collapse ul li a').on('click', function() {  
		$('html, body').animate({scrollTop: $(this.hash).offset().top - 5}, 1000);
		return false;
	});

	// User define function
	function Scroll() {
		var contentTop      =   [];
		var contentBottom   =   [];
		var winTop      =   $(window).scrollTop();
		var rangeTop    =   200;
		var rangeBottom =   500;
		$('.navbar-collapse').find('.scroll a').each(function(){
			contentTop.push( $( $(this).attr('href') ).offset().top);
			contentBottom.push( $( $(this).attr('href') ).offset().top + $( $(this).attr('href') ).height() );
		})
		$.each( contentTop, function(i){
			if ( winTop > contentTop[i] - rangeTop ){
				$('.navbar-collapse li.scroll')
				.removeClass('active')
				.eq(i).addClass('active');			
			}
		})
	};

	$('#tohash').on('click', function(){
		$('html, body').animate({scrollTop: $(this.hash).offset().top - 5}, 1000);
		return false;
	});

	// accordian
	$('.accordion-toggle').on('click', function(){
		$(this).closest('.panel-group').children().each(function(){
		$(this).find('>.panel-heading').removeClass('active');
		 });

	 	$(this).closest('.panel-heading').toggleClass('active');
	});

	//Slider
	$(document).ready(function() {
		var time = 7; // time in seconds

	 	var $progressBar,
	      $bar, 
	      $elem, 
	      isPause, 
	      tick,
	      percentTime;
	 
	    //Init the carousel
	    $("#main-slider").find('.owl-carousel').owlCarousel({
	      slideSpeed : 500,
	      paginationSpeed : 500,
	      singleItem : true,
	      navigation : true,
			navigationText: [
			"<i class='fa fa-angle-left'></i>",
			"<i class='fa fa-angle-right'></i>"
			],
	      afterInit : progressBar,
	      afterMove : moved,
	      startDragging : pauseOnDragging,
	      //autoHeight : true,
	      transitionStyle : "fadeUp"
	    });
	 
	    //Init progressBar where elem is $("#owl-demo")
	    function progressBar(elem){
	      $elem = elem;
	      //build progress bar elements
	      buildProgressBar();
	      //start counting
	      start();
	    }
	 
	    //create div#progressBar and div#bar then append to $(".owl-carousel")
	    function buildProgressBar(){
	      $progressBar = $("<div>",{
	        id:"progressBar"
	      });
	      $bar = $("<div>",{
	        id:"bar"
	      });
	      $progressBar.append($bar).appendTo($elem);
	    }
	 
	    function start() {
	      //reset timer
	      percentTime = 0;
	      isPause = false;
	      //run interval every 0.01 second
	      tick = setInterval(interval, 10);
	    };
	 
	    function interval() {
	      if(isPause === false){
	        percentTime += 1 / time;
	        $bar.css({
	           width: percentTime+"%"
	         });
	        //if percentTime is equal or greater than 100
	        if(percentTime >= 100){
	          //slide to next item 
	          $elem.trigger('owl.next')
	        }
	      }
	    }
	 
	    //pause while dragging 
	    function pauseOnDragging(){
	      isPause = true;
	    }
	 
	    //moved callback
	    function moved(){
	      //clear interval
	      clearTimeout(tick);
	      //start again
	      start();
	    }
	});

	//Initiat WOW JS
	new WOW().init();
	//smoothScroll
	smoothScroll.init();

	// portfolio filter
	$(window).load(function(){'use strict';
		var $portfolio_selectors = $('.portfolio-filter >li>a');
		var $portfolio = $('.portfolio-items');
		$portfolio.isotope({
			itemSelector : '.portfolio-item',
			layoutMode : 'fitRows'
		});
		
		$portfolio_selectors.on('click', function(){
			$portfolio_selectors.removeClass('active');
			$(this).addClass('active');
			var selector = $(this).attr('data-filter');
			$portfolio.isotope({ filter: selector });
			return false;
		});
	});

	$(document).ready(function() {
		//Animated Progress
		$('.progress-bar').bind('inview', function(event, visible, visiblePartX, visiblePartY) {
			if (visible) {
				$(this).css('width', $(this).data('width') + '%');
				$(this).unbind('inview');
			}
		});

		//Animated Number
		$.fn.animateNumbers = function(stop, commas, duration, ease) {
			return this.each(function() {
				var $this = $(this);
				var start = parseInt($this.text().replace(/,/g, ""));
				commas = (commas === undefined) ? true : commas;
				$({value: start}).animate({value: stop}, {
					duration: duration == undefined ? 1000 : duration,
					easing: ease == undefined ? "swing" : ease,
					step: function() {
						$this.text(Math.floor(this.value));
						if (commas) { $this.text($this.text().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,")); }
					},
					complete: function() {
						if (parseInt($this.text()) !== stop) {
							$this.text(stop);
							if (commas) { $this.text($this.text().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,")); }
						}
					}
				});
			});
		};

		$('.animated-number').bind('inview', function(event, visible, visiblePartX, visiblePartY) {
			var $this = $(this);
			if (visible) {
				$this.animateNumbers($this.data('digit'), false, $this.data('duration')); 
				$this.unbind('inview');
			}
		});
	});

	// Contact form
	var form = $('#main-contact-form');
	form.submit(function(event){
		event.preventDefault();
		var form_status = $('<div class="form_status"></div>');
		$.ajax({
			url: $(this).attr('action'),
			beforeSend: function(){
				form.prepend( form_status.html('<p><i class="fa fa-spinner fa-spin"></i> Email is sending...</p>').fadeIn() );
			}
		}).done(function(data){
			form_status.html('<p class="text-success">Thank you for contact us. As early as possible  we will contact you</p>').delay(3000).fadeOut();
		});
	});

	//Pretty Photo
	$("a[rel^='prettyPhoto']").prettyPhoto({
		social_tools: false
	});

	//Google Map 
	var latitude1 = $('#googlemap1').data('latitude');
	var longitude1 = $('#googlemap1').data('longitude');
	var latitude2 = $('#googlemap2').data('latitude');
	var longitude2 = $('#googlemap2').data('longitude');
	var latitude3 = $('#googlemap3').data('latitude');
	var longitude3 = $('#googlemap3').data('longitude');
	var latitude4 = $('#googlemap4').data('latitude');
	var longitude4 = $('#googlemap4').data('longitude');
	var marker1,map1;
	 var geocoder;
	 var geocoder4;
        var map3;
		var marker3;
        var markers3 = [];
		
        var infoWindowContent3 = [];
		var map4;
		var marker4;
        var markers4 = [];
		 var infoWindowContent4 = [];
	function initialize_map() {
		var myLatlng1 = new google.maps.LatLng(latitude1,longitude1);
		var myLatlng2 = new google.maps.LatLng(latitude2,longitude2);
		var myLatlng3 = new google.maps.LatLng(latitude3,longitude3);
		var myLatlng4 = new google.maps.LatLng(latitude4,longitude4);
		
		
		var bounds = new google.maps.LatLngBounds();
		var bounds4 = new google.maps.LatLngBounds();
    geocoder = new google.maps.Geocoder();
	    geocoder4 = new google.maps.Geocoder();
		var mapOptions1 = {
			zoom: 10,
			scrollwheel: false,
			center: myLatlng1
		};
		var mapOptions2 = {
			zoom: 10,
			scrollwheel: false,
			center: myLatlng2
		};
		var mapOptions3 = {
			  zoom: 10,
			  scrollwheel:false,
			  center: myLatlng3,
              mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		var mapOptions4 = {
			zoom: 10,
			scrollwheel: false,
			center: myLatlng4,
			mapTypeId:google.maps.MapTypeId.ROADMAP
		};
		map1 = new google.maps.Map(document.getElementById('googlemap1'), mapOptions1);
		
		
		
		google.maps.event.addListener(map1, 'click', function(event) {
    placeMarker1(event.latLng);
	
  });
  
		var map2 = new google.maps.Map(document.getElementById('googlemap2'), mapOptions2);
		
		var map3 = new google.maps.Map(document.getElementById('googlemap3'), mapOptions3);
		var map4 = new google.maps.Map(document.getElementById('googlemap4'), mapOptions4);
		
		
		var marker2 = new google.maps.Marker({
			position: myLatlng2,
			map: map2
		});
		
		marker2.setMap(map2);
	
 //Initialize the encoded string
        var encodedString;
        //Initialize the array that will hold the contents of the split string
        var stringArray = [];
        //Get the value of the encoded string from the hidden input
        encodedString = document.getElementById("encodedString").value;
        //Split the encoded string into an array the separates each location
        stringArray = encodedString.split("****");
 
        var x;
        for (x = 0; x < stringArray.length; x = x + 1)
        {
            var addressDetails = [];
            var marker;
            //Separate each field
            addressDetails = stringArray[x].split("&&&");
            //Load the lat, long data
            var position = new google.maps.LatLng(addressDetails[1], addressDetails[2]);
            //Create a new marker and info window
            marker3 = new google.maps.Marker({
                map: map3,
                position: position,
                //Content is what will show up in the info window
                content: addressDetails[0]
            });
            //Pushing the markers into an array so that it's easier to manage them
            markers3.push(marker3);
            google.maps.event.addListener( marker3, 'click', function () {
                closeinfoWindowContent3();
				
                var info = new google.maps.InfoWindow({content: this.content});
                //On click the map will load the info window
                info.open(map3,this);
                infoWindowContent3[0]=info;
            });
           //Extends the boundaries of the map to include this new location
           bounds.extend(position);
        }
        //Takes all the lat, longs in the bounds variable and autosizes the map
        map3.fitBounds(bounds);
 
 //edit
//Initialize the encoded string
        var encodedString4;
		var encodedString5;
        //Initialize the array that will hold the contents of the split string
        var stringArray4 = [];
		var stringEdit = [];
        //Get the value of the encoded string from the hidden input
        encodedString4 = document.getElementById("encodedString4").value;
		encodedString5= document.getElementById("encodedString5").value;
        //Split the encoded string into an array the separates each location
        stringArray4 = encodedString4.split("****");
		stringEdit=encodedString5.split("#");
 
        var y;
        for (y = 0; y < stringArray4.length; y = y + 1)
        {
            var addressDetails4 = [];
            var marker4;
            //Separate each field
            addressDetails4 = stringArray4[y].split("&&&");
            //Load the lat, long data
			
            var positions = new google.maps.LatLng(addressDetails4[1], addressDetails4[2]);
            //Create a new marker and info window
            marker4= new google.maps.Marker({
                map: map4,
                position: positions,
                //Content is what will show up in the info window
                content: addressDetails4[0]
            });
            //Pushing the markers into an array so that it's easier to manage them
            markers4.push(marker4);
            google.maps.event.addListener( marker4, 'click', function () {
				loadFormData(addressDetails4,stringEdit);
                closeinfoWindowContent4();
                var info4 = new google.maps.InfoWindow({content: this.content});
                //On click the map will load the info window
                info4.open(map4,this);
                infoWindowContent4[0]=info4;
            });
           //Extends the boundaries of the map to include this new location
           bounds4.extend(positions);
        }
        //Takes all the lat, longs in the bounds variable and autosizes the map
        map.fitBounds(bounds4);

	
	}
	
	//function for add section	
	function placeMarker1(location) {
  marker1 = new google.maps.Marker({
    position: location,
    map: map1,
	
  });
  document.getElementById("lati").value = location.lat();
  document.getElementById("longi").value = location.lng();
 /* var infowindow = new google.maps.InfoWindow({
    content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
  });
  infowindow.open(map,marker);*/
} 

   //Manages the info windows for view
        function closeinfoWindowContent3(){
       if(infoWindowContent3.length > 0){
          infoWindowContent3[0].set("marker3",null);
          infoWindowContent3[0].close();
          infoWindowContent3.length = 0;
       }
        }
		
		 //Manages the info windows for view
        function closeinfoWindowContent4(){
       if(infoWindowContent4.length > 0){
          infoWindowContent4[0].set("marker4",null);
          infoWindowContent4[0].close();
          infoWindowContent4.length = 0;
       }
        }
  
        function loadFormData(address,edit){
	document.getElementById("name2").value = edit[0];
document.getElementById("addr2").value = edit[1];
document.getElementById("area2").value = edit[2];
document.getElementById("slots2").value = edit[3];
document.getElementById("price2").value = edit[4];	
document.getElementById("fine2").value = edit[5];

			
  document.getElementById("lat2").value = address[1];
  document.getElementById("lon2").value = address[2];
 
			
			
		}
  
  
	google.maps.event.addDomListener(window, 'load', initialize_map);


});