$(document).ready(function() {

	function refreshReg()
	{
		table = $('#listRegion').DataTable();
		$.getJSON( 'getRegion', null, function ( json ) {
	        table.destroy();
	 
	        table = $('#listRegion').DataTable( {
	        	"data": json,

			    "columns": [
				
			    { "data": "id", visible:false },
			    { "data": "nom" }		    
			    ]
	        } );   
	    } );
	}
	
	refreshReg();
	
	$('#listRegion tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        $("#idReg").val(data.id);
        $("#nomReg").val(data.nom);
    } );
    
    function viderReg()
    {
    	$("#idReg").val("0");
        $("#nomReg").val("");
    }
    
    $("#vidReg").on('click',function(){
    	  viderReg();
    });
	
	
	$("#saveReg").on('click',function(){
	
	var idReg = $("#idReg").val();
	var nomReg = $("#nomReg").val();
	var url = "";
	if(idReg=="0")
	{
		url="AddRegion";
	}
	else
	{
		url="updateRegion";
	}
	
	$.ajax({
            type: "GET",
            url: url,
            data : {idReg:idReg,nomReg:nomReg},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if(obj.res=="succ")
            	{
            		toastr.success('success');
            		viderReg()
					refreshReg();
            	}
            	else
            	{
            		toastr.error('erreur');
            	}
				
            }
        });
	
	});


});