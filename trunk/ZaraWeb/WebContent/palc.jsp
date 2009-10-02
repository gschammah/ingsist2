<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PALC</title>
<link href="css/styles.css" media="screen" rel="stylesheet" />
</head>
<body>




<fieldset>
		<legend>Artículos</legend>
		
		<div class="factLeft">			
			<label for="referencia">ID: </label>
			<input id="referencia" name="referencia"/>
			<input type="submit" value="OK" />
		</div>


		<p />
		<br />

		<div class="facturaHeader2">
			<table cellpadding="0" cellspacing="0" class="grillaArticulos">			
			<thead>
				<tr>
					<th>Referencia</th>			
					<th>Descripción</th>
					<th>Ventas</th>
					<th>Pend d/env</th>
					<th>Stock</th>
					<th>PdP</th>
					<th>Pedir</th>
					<th>Cant.</th>
				</tr>
			</thead>
			<tr>
				<td>xxx</td>	
				<td>xxxxx</td>
				<td>xxxx</td>
				<td>xxxx</td>
				<td>xxxx</td>
				<td>xxxx</td>
				<td><input type="checkbox"></td>
				<td>xxxx</td>
			</tr>
			<tr>
				<td>xxx</td>	
				<td>xxxxx</td>
				<td>xxxx</td>
				<td>xxxx</td>
				<td>xxxx</td>
				<td>xxxx</td>
				<td><input type="checkbox"></td>
				<td>xxxx</td>
			</tr>
		</table>
	</div>

        <p />
	<form action="confirmaPaLC.html">
		<div class="botones">
			<input type="submit" value="Generar PALC">
			<input type="button" value="Volver" onClick="javascript:history.go(-1)">
			<p/>

		</div>
	</form>



	</fieldset>
	

</body>
</html>