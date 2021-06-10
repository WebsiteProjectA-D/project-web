$(document).ready(function() {

	$("#go").on('click', function() {

		
		var login = $("input[name=login]").val();
		var pass = $("input[name=pass]").val();
	
		$.ajax({
            type: "Get",
            url: "CnxAdmin",
            data: {login:login,pass:pass},
            success: function (data) {
            	var obj = JSON.parse(data);
				if(obj.res=="succ")
            	{
            		window.location.replace("Admin.jsp");
            	}
            	else 
            	{
            		toastr.error('vérifier email/password')
            	}
					
            }
        });

	});

});	
