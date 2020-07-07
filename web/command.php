<?php
	require (__DIR__ . '/SourceQuery/bootstrap.php');
	
	use xPaw\SourceQuery\SourceQuery;
	
	define('SQ_SERVER_ADDR', 'localhost');
	define('SQ_SERVER_PORT', 25575);
	define('SQ_TIMEOUT', 4000);
	define('SQ_ENGINE', SourceQuery::SOURCE);
	
	$Query = new SourceQuery();
	
	try
	{
		$Query->Connect(SQ_SERVER_ADDR, SQ_SERVER_PORT, SQ_TIMEOUT, SQ_ENGINE);
	
		$Query->SetRconPassword('asdf12345');
	
		if (isset($_GET['Command']))
		{
			var_dump($Query->Rcon($_GET['Command']));
		}
	}
	catch(Exception $e)
	{
		echo $e->getMessage();
	}
	finally
	{
		$Query->Disconnect();
	}
?>