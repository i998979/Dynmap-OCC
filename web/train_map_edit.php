<!DOCTYPE html>
<html>
	<head>
		<script src="https://code.jquery.com/jquery-latest.js"></script>
	</head>
    
	<body>
		<a href="#" onclick="sendCommand('say hyperlink');">Submit preset val</a>
        
		<form id="form1" action="javascript:sendCommand('docc %train_id% setName ' + input1.value);" method="get">
			<label for="input1">Train ID:</label>
			<input id="input1" type="text" size=5 value="%train_id%" />
			<input id="submit1" type="submit" value="Update" />
		</form>
        
		<form id="form2" action="javascript:sendCommand('docc %train_id% setDestination ' + input2.value);" method="get">
			<label for="input2">Destination:</label>
			<input id="input2" type="text" size=5 value="%train_dest%" />
			<input id="submit2" type="submit" value="Update" />
		</form>
        
		<form id="form3" action="javascript:sendCommand('docc %train_id% setSpeedLimit ' + input3.value);" method="get">
			<label for="input3">Target speed:</label>
			<input id="input3" type="text" size=5 value="%train_target_speed%" />
			<input id="submit3" type="submit" value="Update" />
            <input type ="button" onclick="javascript:sendCommand('docc %train_id% setTurboAction');" value="Turbo action"></input>
		</form>
        
		<form id="form4" action="javascript:sendCommand('docc %train_id% setWaitDistance ' + input4.value);" method="get">
			<label for="input4">Wait distance:</label>
			<input id="input4" type="text" size=4 value="%train_wait_distance%" />
			<input id="submit" type="submit" value="Update" />
		</form>
        
		<script>
			function sendCommand(command) {
			    $.get("command.php?Command=" + command );
			    return false;
			}
		</script>
	</body>
</html>