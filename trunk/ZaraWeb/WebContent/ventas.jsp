<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ventas</title>
<link href="css/styles.css" media="screen" rel="stylesheet" />
</head>
<body>
<f:view>
	<h:form>
	<fieldset>
		<legend>Datos de Factura</legend>
		
		<div class="facturaHeader">
			<div class="factLeft">
				<label for="cuit">CUIT/CUIL: </label>
				<h:inputText id="cuit" value=""/>
				</div> 
				
			
			<div class="factCenter">
				<label for="tipoFact">Tipo de Factura: </label>
				<h:selectOneMenu id="tipoFact">
					   <f:selectItem itemLabel="A" itemValue="A" />
                       <f:selectItem itemLabel="B" itemValue="B"/>
                       <f:selectItem itemLabel="C" itemValue="C"/>
				</h:selectOneMenu>				
			</div>
			
			<div class="factRight">
				Fecha: xx/xx/xxxx
			</div> 					
		</div>
		
		<div class="facturaHeader2">
			<div class="factLeft">				
				<label for="cliente">Cliente:</label>
				<h:inputText id="cliente" value=""/>
			</div>
			
			<div class="factCenter">
				<label for="razonSocial">Razon Social:</label>
				<h:inputText id="razonSocial" />
			</div>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Artículos</legend>
		
		<div class="factLeft">			
			<label for="referencia">ID: </label>
			<h:inputText id="referencia" value=""/>
			<h:commandButton value="Agregar"/>			
		</div>  
		
		<div class="factCenter" style="width: 66%">			
			<label for="detalles">Detalles: </label>
			<h:inputTextarea rows="5" id="detalles" value="" styleClass="detalles"/>						
		</div>
		<p/>
		<div class="facturaHeader2">
			<table cellpadding="0" cellspacing="0" class="grillaArticulos">			
			<thead>
				<tr>
					<th>Referencia</th>
					<th>Línea</th>
					<th>Descripción</th>
					<th>Precio</th>
					<th>Precio Oferta</th>
					<th>Cantidad</th>
					<th>Borrar</th>
				</tr>
			</thead>
			<tr>
				<td>xxx</td>
				<td>xxx</td>
				<td>xxxxx</td>
				<td>xxxx</td>
				<td><input type="checkbox"></td>
				<td>xxxx</td>
				<td><input type="button" value="OK"></td>
			</tr>
			<tr>
				<td>xxx</td>
				<td>xxx</td>
				<td>xxxxx</td>
				<td>xxxx</td>
				<td><input type="checkbox"></td>
				<td>xxxx</td>
				<td><input type="button" value="OK"></td>
			</tr>
		</table>
	</div>
	
	<div class="totales">
		SubTotal: 0.0 <br>
		IVA: 0.0 <br>
		TOTAL: 0.0 <br>
	</div>
	
			
		<div class="botones">
			<input type="submit" value="Generar Factura">
			
		</div>	
	

		
		<div class="botonVolver">
			<input type="submit" value="Volver">
			<p/>
		
		</div>	
	
	</fieldset>
	</h:form>
</f:view>	
</body>
</html>