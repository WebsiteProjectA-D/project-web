$(document).ready(function() {

function refresh()
	{
		table = $('#listMed').DataTable();
		$.getJSON( 'listeMedecin', null, function ( json ) {
	        table.destroy();
	 
	        table = $('#listMed').DataTable( {
	        	"data": json,

			    "columns": [
				
			    { "data": "cinmed", visible:false },
			    { "data": "nomPren" },
			    { "data": "adr" },
			    { "data": "telc" },
			    { "data": "spec" },
			    { "data": "region" },
			    {"defaultContent" : "<center><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#modal-default' id='medrdv'> <span class='fa fa-calendar'></span></button><center>"}
			    
			    ]
	        } );   
	    } );
	}

/* Main */

refresh();

$("#listMed tbody").on('click','#meddt',function()
	{
		var data = table.row( $(this).parents('tr') ).data();
		alert(data.cinmed);
		 
});

$("#listMed tbody").on('click','#medrdv',function()
	{
		var data = table.row( $(this).parents('tr') ).data();
		$("#cinMed").val(data.cinmed);
		$("#nomMed").html(data.nomPren);
		 
});

$('#timepicker').datetimepicker({
      format: 'H:mm'
    })
    
});
  


