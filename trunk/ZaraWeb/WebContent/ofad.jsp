<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recibir OFAD</title>
<link href="css/styles.css" media="screen" rel="stylesheet" />
</head>
<body>	
	<div id="subContainer">
		<label for="lastUpdate">Ultima Actualización: </label>
		<input type="text" id="lastUpdate" value="xx/xx/xxxx" />
		<p/>
		<form method="post" action="confirmaOfad.html" enctype="application/x-www-form-urlencoded">
			<label for="fileOfad">Archivo: </label>
			<input id="fileOfad" type="file" name="fileOfad">
			<p>
			<input type="submit" value="Enviar" />
			</p>
		</form>

                <div class="botonVolver">
			<input type="button" value="Volver" onClick="javascript:history.go(-1)">
		</div>
	</div>

	

</body>
</html>