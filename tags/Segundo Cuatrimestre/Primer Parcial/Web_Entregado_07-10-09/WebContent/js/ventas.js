$(function(){

	$("#tipoFact").change(function(){
		if ($(this).val() == "A") {
			$("#cuit, #cliente, #razonSocial, #direccion").removeAttr("readonly");
			$("#cuit").val("").blur();			
		} else {
			$("#cuit, #cliente, #razonSocial, #direccion").attr("readonly", "readonly");
			$("#cuit").val("0").blur();
		}
		$.getJSON("ventas", {json: 1, tipoFact: this.value}, function(json){
			$("#total").html(json.total);
			$("#subtotal").html(json.subtotal);			
			$("#iva").html(json.iva);
		});				 
	});
	
	$("#cuit").blur(function(){
		$.getJSON("ajax", {cuit: this.value}, function(json){
			$("#cliente").val(json.nombre);
			$("#razonSocial").val(json.razon);			
			$("#direccion").val(json.direccion);
		});
	});
	
	$(".check").click(function(){		
		var check = this.checked ? 1 : 0;			
		location.href = "ventas?cmd=precio&checked=" + check + "&ref=" + this.name + "&tipoFact=" + $("#tipoFact").val();
	});
	
	$("form").submit(function(){
		if (!$("#referencia").val() && (!$("#cuit").val() || !$("#cliente").val() || !$("#razonSocial").val() || !$("#direccion").val())) {
			alert("Por favor complete todos los datos de la factura");
			return false;
		}
	});

});