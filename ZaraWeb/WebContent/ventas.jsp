<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="css/styles.css" media="screen" rel="stylesheet" />
<title>Ventas</title>
</head>
<body>
<form method="POST">    
	<fieldset>
		<legend>Datos de Factura</legend>
		
		<div class="facturaHeader">
			<div class="factLeft">
				<label for="cuit">CUIT/CUIL: </label>
				<input type="text" id="cuit" name="cuit" value="cuit"/>
			</div>             
			
			<div class="factCenter">
				<label for="tipoFact">Tipo de Factura: </label>
				<select name="tipoFact" id="tipoFact">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
				</select>
			</div>
			
			<div class="factRight">
				Fecha: ${currentTime}
			</div> 					
		</div>
		
		<div class="facturaHeader2">
			<div class="factLeft">
				<label for="cliente">Cliente:</label>
				<input id="cliente" name="cliente"/>
			</div>
			
			<div class="factCenter">
				<label for="razonSocial">Raz&oacute;n Social:</label>
				<input id="razonSocial" name="razonSocial"/>
			</div>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Art&iacute;culos</legend>
		
		<div class="factLeft">			
			<label for="referencia">ID: </label>
			<input type="text" name="referencia" id="referencia" value="referencia"/>
			<input type="submit" name="agregar" value="Agregar" />
		</div>  
		
		<div class="factCenter" style="width: 66%">			
			<label for="detalles">Detalles: </label>
			<textarea rows="5" id="detalles" class="txtDetalles"></textarea>			
		</div>
		<p/>
		<div class="facturaHeader2">
			<table cellpadding="0" cellspacing="0" class="grillaArticulos">			
			<thead>
				<tr>
					<th>Referencia</th>
					<th>L&iacute;nea</th>
					<th>Descripci&oacute;n</th>
					<th>Precio</th>
					<th>Precio Oferta</th>
					<th>Cantidad</th>
					<th>Borrar</th>
				</tr>
			</thead>			
			<tr>
				<td>${item.referencia}</td>
				<td>${item.linea}</td>
				<td>${item.descripcion}</td>
				<td>${item.precioLista}</td>
				<td><input type="checkbox" /></td>
				<td></td>
				<td><input type="button" value="OK" /></td>
			</tr>					
		</table>
	</div>
	
	<div class="totales">
		SubTotal: 0.0 <br/>
		IVA: 0.0 <br/>
		TOTAL: 0.0 <br/>
	</div>
	
			
		<div class="botones">
			<input type="submit" value="Generar Factura" />
			<input type="button" value="Cancelar" />
		</div>	
	
	</fieldset>
	</form>

</body>
</html>