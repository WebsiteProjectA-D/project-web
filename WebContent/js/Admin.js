$(document).ready(function() {

function refreshMed()
	{
		table = $('#listMedic').DataTable();
		$.getJSON( 'getMedicament', null, function ( json ) {
	        table.destroy();
	 
	        table = $('#listMedic').DataTable( {
	        	"data": json,

			    "columns": [
				
			    { "data": "id", visible:false },
			    { "data": "nom" }		    
			    ]
	        } );   
	    } );
	}
	
	
	
	
	refreshMed();
	
	
	$('#listMedic tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        $("#idMed").val(data.id);
        $("#nomMed").val(data.nom);
    } );
    
    function viderMed()
    {
    	$("#idMed").val("0");
        $("#nomMed").val("");
    }
    
    $("#vidMed").on('click',function(){
    	  viderMed();
    });
	
	
	$("#saveMed").on('click',function(){
	
	var idMed = $("#idMed").val();
	var nomMed = $("#nomMed").val();
	var url = "";
	if(idMed=="0")
	{
		url="AddMedicament";
	}
	else
	{
		url="updateMedicament";
	}
	
	$.ajax({
            type: "GET",
            url: url,
            data : {idMed:idMed,nomMed:nomMed},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if(obj.res=="succ")
            	{
            		toastr.success('success');
            		viderMed()
					refreshMed();
            	}
            	else
            	{
            		toastr.error('erreur');
            	}
				
            }
        });
	
	});


});