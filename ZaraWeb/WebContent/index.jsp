<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tienda Zara</title>
<link href="css/styles.css" media="screen" rel="stylesheet"/>
</head>
<body>
<f:view>
	<h:form>	
	<div id="container">
		<div><img src="img/logo.gif" /></div>
		<div><h:commandLink value="Venta de Articulos" action="ventas"></h:commandLink></div>
		<div><h:commandLink value="Recibir OFAD" action="ofad"></h:commandLink></div>
		<div><h:commandLink value="Generar PALC" action="palc"></h:commandLink></div>
		<div><h:commandLink value="Recibir ENVT" action="envt"></h:commandLink></div>		
	</div>
	</h:form>
</f:view>
</body>
</html>