<?php
	require (__DIR__ . '/SourceQuery/bootstrap.php');

	use xPaw\SourceQuery\SourceQuery;
	
	define( 'SQ_SERVER_ADDR', 'localhost' );
	define( 'SQ_SERVER_PORT', 25575 );
	define( 'SQ_TIMEOUT',	 4000 );
	define( 'SQ_ENGINE',	  SourceQuery::SOURCE );
	
	$Query = new SourceQuery( );
	
	try
	{
		$Query->Connect( SQ_SERVER_ADDR, SQ_SERVER_PORT, SQ_TIMEOUT, SQ_ENGINE );
		
		$Query->SetRconPassword( 'asdf12345' );
		
		if(isset($_GET['Command'])) {
			var_dump( $Query->Rcon( $_GET['Command'] ) );
		}
		
	}
	catch( Exception $e )
	{
		echo $e->getMessage( );
	}
	finally
	{
		$Query->Disconnect( );
	}
?>

<!--
marker.setDescription("<form action=\"index.php\" method=\"get\">\r\n" + 
		"	<b>Command:</b>" + 
		"	<input type=\"text\" name=\"Command\"><br>\r\n" + 
		"	<input type=\"submit\">\r\n" + 
		"</form>");
-->

<!DOCTYPE html>
<html lang="en">
<head>

	<title>Minecraft Dynamic Map</title>

	<meta charset="utf-8" />
	<meta name="keywords" content="minecraft, map, dynamic" />
	<meta name="description" content="Minecraft Dynamic Map" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
	<!-- These 2 lines make us fullscreen on apple mobile products - remove if you don't like that -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />	

	<link rel="icon" href="images/dynmap.ico" type="image/ico" />

	<script type="text/javascript" src="js/jquery-1.11.0.js?_=3.1-beta-1-367"></script>
	<link rel="stylesheet" type="text/css" href="css/leaflet.css?_=3.1-beta-1-367" />
	<script type="text/javascript" src="js/leaflet.js?_=3.1-beta-1-367"></script>

	<script type="text/javascript" src="js/custommarker.js?_=3.1-beta-1-367"></script>

	<script type="text/javascript" src="js/dynmaputils.js?_=3.1-beta-1-367"></script>
	<script type="text/javascript" src="js/sidebarutils.js?_=3.1-beta-1-367"></script>

	<!--<link rel="stylesheet" type="text/css" href="css/embedded.css" media="screen" />-->
	<link rel="stylesheet" type="text/css" href="css/standalone.css?_=3.1-beta-1-367" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/dynmap_style.css?_=3.1-beta-1-367" media="screen" />
	<!-- <link rel="stylesheet" type="text/css" href="css/override.css" media="screen" /> -->

	<script type="text/javascript" src="version.js?_=3.1-beta-1-367"></script>
	<script type="text/javascript" src="js/jquery.json.js?_=3.1-beta-1-367"></script>
	<script type="text/javascript" src="js/jquery.mousewheel.js?_=3.1-beta-1-367"></script>
	<script type="text/javascript" src="js/minecraft.js?_=3.1-beta-1-367"></script>
	<script type="text/javascript" src="js/map.js?_=3.1-beta-1-367"></script>
	<script type="text/javascript" src="js/hdmap.js?_=3.1-beta-1-367"></script>
	<script type="text/javascript" src="standalone/config.js?_=3.1-beta-1-367"></script>

	<script type="text/javascript">
			$(document).ready(function() {
				window.dynmap = new DynMap($.extend({
					container: $('#mcmap')
				}, config));
			});
	</script>
	
	<script>
		function sendCommand(command) {
			$.get("command.php?Command=" + command );
			return false;
		}
		function sendWithoutVal() {
			$.get("command.php?Command=say " + $("input").val() );
			
			return false;
		}
	</script>
</head>
<body>



<noscript>
 For full functionality of this site it is necessary to enable JavaScript.
 Here are the <a href="http://www.enable-javascript.com/" target="_blank">
 instructions how to enable JavaScript in your web browser</a>.
</noscript>

	<div id="mcmap"></div>
</body>
</html>