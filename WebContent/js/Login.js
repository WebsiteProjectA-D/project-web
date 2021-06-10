$(document).ready(function() {

	$("#go").on('click', function() {

		
		var login = $("input[name=login]").val();
		var pass = $("input[name=pass]").val();
		
		var type = $('input[name=rrr]:checked', '#myForm').val();
		
		$.ajax({
            type: "POST",
            url: "LoginController",
            data: {login:login,pass:pass,type:type},
            success: function (data) {
            	var obj = JSON.parse(data);
				if(obj.res=="succ")
            	{
            		if(type=="p")
            		{
            			window.location.replace("index.jsp");
            		}
            		else if(type=="m")
            		{
            				window.location.replace("test.jsp");
            		}
            	}
            	else 
            	{
            		toastr.error('vérifier email/password')
            	}
					
            }
        });

	});

});	
