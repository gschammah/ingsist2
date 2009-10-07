<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/styles.css" media="screen" rel="stylesheet" />
<title>Factura</title>
</head>
<body>

<fieldset>
		<legend>Datos de Factura</legend>
		
		<div class="facturaHeader">
			<div class="factLeft">
				CUIT/CUIL: ${venta.cliente.cuit}
			</div> 
			
			<div class="factCenter">
				Tipo de Factura: ${venta.tipoFactura}
			</div>
			
			<div class="factRight">
				Fecha: ${venta.fecha}
			</div> 					
		</div>
		
		<div class="facturaHeader2">
			<div class="factLeft">
				Cliente: ${venta.cliente.nombre}				
			</div>
			
			<div class="factCenter">
				Razon Social: ${venta.cliente.razonSocial}
			</div>
			
			<div class="factRight">
				Direcci&oacute;n: ${venta.cliente.direccion}
			</div> 		
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Artículos</legend>
			
		<div class="facturaHeader2">
			<table cellpadding="0" cellspacing="0" class="grillaArticulos">			
			<thead>
				<tr>
					<th>Referencia</th>
					<th>Cantidad</th>
					<th>Descripción</th>
					<th>Precio Unitario</th>
					<th>Total</th>					
				</tr>
			</thead>
			<c:forEach items="${venta.items}" var="item">
			<tr>
				<td>${item.articulo.referencia}</td>
				<td>${item.cantidad}</td>
				<td>${item.articulo.descripcion}</td>
				<td>${item.precio}</td>				
				<td>${item.precio * item.cantidad}</td>
			</tr>
			</c:forEach>			
		</table>
	</div>
	
	<div class="totales">
		SubTotal: ${venta.subTotal} <br>
		IVA: ${venta.iva} <br>
		TOTAL: ${venta.total} <br>
	</div>
	
	<form action="tml/index">		
		<div class="botonSalir">
			<input type="submit" value="Salir">			
		</div>	
	</form>
	</fieldset>


</body>
</html>