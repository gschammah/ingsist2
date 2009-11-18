<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recibir EnvT</title>
<link href="css/styles.css" media="screen" rel="stylesheet" />
</head>
<body>	
	<div id="subContainer">
		<label for="lastUpdate">Ultima Actualización: </label>
		<input type="text" id="lastUpdate" value="xx/xx/xxxx" />
		<p/>
		<form method="post" action="confirmaEnvT.html" enctype="application/x-www-form-urlencoded">
			<label for="fileEnvT">Archivo: </label>
			<input id="fileEnvT" type="file" name="fileEnvT">
			<p>
			<input type="submit" value="Enviar" />
			</p>
		</form>

		<form action="javascript:history.go(-1)">	
		<div class="botonVolver">
			<input type="submit" value="Volver">
			<p/>
		
		</div>	
	</form>

	</div>

</body>
</html>