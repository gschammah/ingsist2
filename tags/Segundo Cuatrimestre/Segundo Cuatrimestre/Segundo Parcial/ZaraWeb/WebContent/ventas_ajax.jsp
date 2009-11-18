<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<json:object>
  <json:property name="total">
  	<fmt:formatNumber type="number" maxFractionDigits="2" value="${total.total}" />
  </json:property>
  
  <json:property name="subtotal">
  	<fmt:formatNumber type="number" maxFractionDigits="2" value="${total.subTotal}" />
  </json:property>
  
  <json:property name="iva">
  	<fmt:formatNumber type="number" maxFractionDigits="2" value="${total.iva}" />
  </json:property>
  
</json:object>