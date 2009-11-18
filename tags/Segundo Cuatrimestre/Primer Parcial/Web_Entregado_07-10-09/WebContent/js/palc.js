$(function(){
	$(".check").click(function(){
		if ($(this).attr("checked")) {
			$("#" + this.id + "_cant").removeAttr("disabled");
		} else {
			$("#" + this.id + "_cant").attr("disabled", "disabled");
		}
	});
});