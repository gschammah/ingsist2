<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
  <json:property name="razon" value="${cliente.razonSocial}"/>
  <json:property name="nombre" value="${cliente.nombre}"/>  
  <json:property name="direccion" value="${cliente.direccion}"/>
</json:object>