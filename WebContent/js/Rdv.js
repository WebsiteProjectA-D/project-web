$(document).ready(function() {

	var cinp = $("#cinP").val();
	
	
	table = $('#tMrdv').DataTable();
	$.ajax({
			type: "GET",
            url: "Mrdv",
             data : {cinp:cinp},
            success: function (datas) {
            	table.destroy();
            	table = $('#tMrdv').DataTable( {
	        	"data": datas,

			    "columns": [
				
			    { "data": "date" },
			    { "data": "heure" },
			    { "data": "nompren" },
			    { "data": "tel" },
			    { "data": "adresse" }
			    ]
	        } ); 
            	
            }
		});
		
});