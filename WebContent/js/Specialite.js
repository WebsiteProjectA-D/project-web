$(document).ready(function() {

	function refreshSpec()
	{
		table = $('#listSpecialite').DataTable();
		$.getJSON( 'getSpec', null, function ( json ) {
	        table.destroy();
	 
	        table = $('#listSpecialite').DataTable( {
	        	"data": json,

			    "columns": [
				
			    { "data": "id", visible:false },
			    { "data": "nom" }		    
			    ]
	        } );   
	    } );
	}
	
	refreshSpec();
	
	$('#listSpecialite tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        $("#idSpec").val(data.id);
        $("#nomSpec").val(data.nom);
    } );
    
    function viderSpec()
    {
    	$("#idSpec").val("0");
        $("#nomSpec").val("");
    }
    
    $("#vidSpec").on('click',function(){
    	  viderSpec();
    });
	
	
	$("#saveSpec").on('click',function(){
	
	var idSpec = $("#idSpec").val();
	var nomSpec = $("#nomSpec").val();
	var url = "";
	if(idSpec=="0")
	{
		url="AddSpec";
	}
	else
	{
		url="updateSpec";
	}
	
	$.ajax({
            type: "GET",
            url: url,
            data : {idSpec:idSpec,nomSpec:nomSpec},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if(obj.res=="succ")
            	{
            		toastr.success('success');
            		viderSpec()
					refreshSpec();
            	}
            	else
            	{
            		toastr.error('erreur');
            	}
				
            }
        });
	
	});


});