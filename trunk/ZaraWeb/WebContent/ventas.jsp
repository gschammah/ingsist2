<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
<%@page import="java.util.Collection"%>
<%@page import="server.VO.articulos.ArticuloVO"%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<html>
<head>
<script src="js/jquery-1.3.2.min.js"></script>
<script src="js/ventas.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="css/styles.css" media="screen" rel="stylesheet" />
<title>Ventas</title>
</head>
<body>
<form method="POST" action="ventas">    
	<fieldset>
		<legend>Datos de Factura</legend>
		
		<div class="facturaHeader">
			<div class="factLeft">
				<label for="cuit">CUIT/CUIL: </label>
				<input type="text" id="cuit" name="cuit"/>				
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
				Fecha: <input type="text" name="fecha" readonly="readonly"
				value = '<fmt:formatDate type="date" value="${now}" />' />
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
			
			<div class="factRight">
				<label for="direccion">Direcci&oacute;n:</label>
				<input id="direccion" name="direccion"/>
			</div>
		</div>
	</fieldset>
	
	<fieldset>
		<legend>Art&iacute;culos</legend>
		
		<div class="factLeft">			
			<label for="referencia">ID: </label>
			<input style="width:90px" type="text" name="referencia" id="referencia"/>
			Cant.<input style="width: 25px"type="text" name="cantidad" id="cantidad"/>
			<input type="submit" name="agregar" value="Agregar" /><br>
			<c:out value="${error}"/>
					
		</div>  
		
		<div class="factCenter" style="width: 66%">			
			<label for="detalles">Detalles: </label>
			<span style="float: left; padding-left: 5px"><c:out escapeXml="false" value="${currentArt}"/></span>			
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
		
			<c:forEach items="${articulos}" var="item">	
			<tr>
				<td>${item.articulo.referencia}</td>
				<td>${item.articulo.linea}</td>
				<td>${item.articulo.descripcion}</td>
				<td>${item.precio}</td>
				<td><input type="checkbox" <c:if test="${item.articulo.precioLista != item.precio}">checked</c:if> class="check" name="${item.articulo.referencia}"/></td>
				<td>${item.cantidad}</td>
				<td><input type="button" value="OK" onClick="location.href='ventas?cmd=del&id=${item.articulo.referencia}'"/></td>
			</tr>
			</c:forEach>					
		</table>
	</div>
	
	<div class="totales">
		SubTotal: $<span id="subtotal"><fmt:formatNumber type="number" maxFractionDigits="2" value="${total.subTotal}" /></span> <br/>
		IVA: $<span id="iva"><fmt:formatNumber type="number" maxFractionDigits="2" value="${total.iva}" /></span> <br/>
		TOTAL: $<span id="total"> <fmt:formatNumber type="number" maxFractionDigits="2" value="${total.total}" /> </span><br/>
	</div>
	
			
		<div class="botones">
			<input name="generar" type="submit" value="Generar Factura" />
			<input type="button" value="Cancelar" onClick="location.href='tml/index'" />
		</div>	
	
	</fieldset>
	</form>

</body>
</html>