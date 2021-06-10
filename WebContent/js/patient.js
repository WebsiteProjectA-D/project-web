$(document).ready(function() {

table = $('#listPat').DataTable();
		$.getJSON( 'listePatient', null, function ( json ) {
	        table.destroy();
	 
	        table = $('#listPat').DataTable( {
	        	"data": json,

			    "columns": [
				
			    { "data": "cinp",},
			    { "data": "nomPren" },
			    { "data": "adr" },
			    { "data": "tel" },
			    { "data": "daten" },
			    { "data": "sexe" },
			    {"defaultContent" : "<center><button type='button' class='btn btn-success btn-sm' id='dp'> <span class='fa fa-calendar'></span></button><center>"}
			    ]
	        });   
});
	    
$("#listPat tbody").on('click','#dp',function()
	{
		var data = table.row( $(this).parents('tr') ).data();
		
		$("#cindp").val(data.cinp);
		
		$("#contain").load("visitePatient.jsp");
    	$("#tit").html("");
    	$("#tit").html("liste des patients");
		 
});	    
	    
});