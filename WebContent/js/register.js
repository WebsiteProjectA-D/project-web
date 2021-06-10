$(document).ready(function() {

	document.getElementById("telc").style.display = "none";
	document.getElementById("divsp").style.display = "none";
	document.getElementById("divrg").style.display = "none";


	$("#ve").on('change', function() {

		var v = $(this).val();
		if (v == "m") {
			document.getElementById("telc").style.display = "block";
			document.getElementById("divsp").style.display = "block";
			document.getElementById("divrg").style.display = "block";
		}
		else {
			document.getElementById("telc").style.display = "none";
			document.getElementById("divsp").style.display = "none";
			document.getElementById("divrg").style.display = "none";
		}
	});
	
	$.ajax({
				type: "GET",
	            url: "getSpec",
	            success: function (datas) {
	            	$("#spec").select2("");
	            	for (var c = 0; c < datas.length; c++) {
	                   $("#spec").append('<option value="' + datas[c].id + '">' + datas[c].nom + '</option>');
	                   
	                }
	            	
	            }
	            
			});
			
			
			$.ajax({
				type: "GET",
	            url: "getRegion",
	            success: function (datas) {
	            	$("#reg").select2("");
	            	for (var c = 0; c < datas.length; c++) {
	                   $("#reg").append('<option value="' + datas[c].id + '">' + datas[c].nom + '</option>');
	                   
	                }
	            	
	            }
	            
			});
	

	$("#valid").on('click', function() {

		var type = $("#ve").val();

		var cin = $("#cin").val();
		var nom = $("#nom").val();
		var prenom = $("#prenom").val();
		var daten = $("#datenaissance").val();
		var tel = $("#tel").val();
		var adr = $("#adr").val();
		var sexe = $('input[name=radio1]:checked', '#myForm').val();
		var email = $("#email").val();
		var pass = $("#password").val();

		if (type == "m") {
			var telc = $("#telc").val();
			var specialite = $("#spec").val();
			var region = $("#reg").val();
			
			$.ajax({
            type: "POST",
            url: "addMed",
            data: {cin:cin,nom:nom,prenom:prenom,tel:tel,daten:daten,adr:adr,sexe:sexe,email:email,pass:pass,telc:telc,specialite:specialite,region:region},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if(obj.res=="succ")
            	{
            		window.location.href="login.jsp";
            	}
            	else
            	{
            		toastr.error('vérifier vos données')
            	}
            	
            }
        });
			
		}
		else if (type == "p") {
			$.ajax({
            type: "POST",
            url: "addPatient",
            data: {cin:cin,nom:nom,prenom:prenom,tel:tel,daten:daten,adr:adr,sexe:sexe,email:email,pass:pass},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if(obj.res=="succ")
            	{
            		window.location.href="login.jsp";
            	}
            	else
            	{
            		toastr.error('vérifier vos données')
            	}
            }
        });
		}

	});

});