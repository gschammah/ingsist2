<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="server.VO.PALC.PalcPropuestoVO"%>
<%@page import="java.util.Collection"%>
<%@page import="server.VO.articulos.ArticuloVO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PALC</title>
<link href="css/styles.css" media="screen" rel="stylesheet" />
</head>
<body>




<fieldset>
		<legend>Art&iacute;culos</legend>
		
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
					<th>Descripci&oacute;n</th>
					<th>Ventas</th>
					<th>Pend d/env</th>
					<th>Stock</th>
					<th>PdP</th>
					<th>Pedir</th>
					<th>Cant.</th>
				</tr>
			</thead>
			
				
			<c:forEach  items="${palc}" var="item">
     		<tr>
				<td>${item.articulo.referencia}</td>	
				<td>${item.articulo.descripcion}</td>
				<td>${item.ventas}</td>
				<td>${item.pendientes}</td>
				<td>${item.articulo.stock}</td>
				<td>${item.articulo.puntoReposicion}</td>
				<td><input name="pedir_"" type="checkbox"></td>
				<td><input name="cantidad_" /></td>
			</tr>
			
			</c:forEach>
			
			
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