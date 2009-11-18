$(function(){
	$(".check").click(function(){
		if ($(this).attr("checked")) {
			$("#" + this.id + "_cant").removeAttr("disabled");
		} else {
			$("#" + this.id + "_cant").attr("disabled", "disabled");
		}
	});		
	
	
	$("form").submit(function(){
		var flag = true;	
		$("[id$='cant']").each(function(){
			if (!isValidDigit(this.value)) {				
				flag = false;
				return;	
			}
		});
		if (!flag) {
			alert("Por favor verifique que las cantidades ingresadas sean numéricas");
			return false;
		}
	});
	
	function isDigit (c)
           {return ((c >= "0") && (c <= "9"));}

  function isValidDigit (s)
    {
    	for (var i = 0; i < s.length; i++){
    		var c = s.charAt(i);
            if (!isDigit(c)) 
            	return false;
        }
                return true;
    }	
});