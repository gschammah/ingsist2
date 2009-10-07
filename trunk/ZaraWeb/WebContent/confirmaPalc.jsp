<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="server.VO.PALC.ItemPALCVO"%>
<%@page import="server.VO.articulos.ArticuloVO"%>
<%@page import="server.VO.PALC.PALCVO"%>
<%@page import="java.util.Collection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generar PALC</title>
<link href="css/styles.css" media="screen" rel="stylesheet" />
</head>
<body>
<div class="container">
	
	
	<table cellpadding="0" cellspacing="0" class="grilla">
		<caption>Art&iacute;culos Pedidos</caption>
		<thead>
			<tr>
				<th>Art&iacute;culo</th>
				<th>Descripci&oacute;n</th>
				<th>Cantidad Pedida</th>
			</tr>
		</thead>
				
		<%
			for (ItemPALCVO item: ((Collection<ItemPALCVO>) request.getSession().getAttribute("arts"))) {
    					    				
        	%>
			
			
			<tr>
				<td><%= item.getArticulo().getReferencia() %></td>	
				<td><%= item.getArticulo().getDescripcion() %></td>
				<td><%= item.getCantidadSolicitada() %></td>
			</tr>
			
			<%
						
			}
    		%>
		
	</table>
	
	

        <div class="botonSalir">
        	<form action="index.html">

        			<input type="submit" value="Salir">
        			<p/>
        	</form>
	</div>
</div>
</body>
</html>