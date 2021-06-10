$(document).ready(function() {

	$.ajax({
            type: "GET",
            url: "NombrePatients",
            success: function (data) {
            	var obj = JSON.parse(data);
				$("#nbP").html(obj.nb);
            }
        });
        
        
        $.ajax({
            type: "GET",
            url: "NombreRDV",
            success: function (data) {
            	var obj = JSON.parse(data);
				$("#nbR").html(obj.nbR);
            }
        });
        
        $.ajax({
            type: "GET",
            url: "LastRdv",
            success: function (data) {
            	$("#lstrdv").html("");
            	for(var i=0;i<data.length;i++)
            	{
            		var ligne=$("<li class='item'></li>");  
            		ligne.append("<div class='product-info'>");
            		ligne.append("<a href='#' class='product-title'>"+data[i].nompp+" <span class='badge badge-warning float-right'>"+data[i].heure+"</span></a>");
            		$("#lstrdv").append(ligne);
            	}
            }
        });

});