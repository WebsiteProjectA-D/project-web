$("#verif").on('click',function()
{
	var cinm = $("#cinMed").val();
	var cinp = $("#cinP").val();
	var date = $("#datee").val();	
	var heure = $("#timee").val();	
	
	$.ajax({
			type: "GET",
            url: "VerifRendezVous",
            data : {cinm:cinm,cinp:cinp,date:date,heure:heure},
            success: function (data) {
            			var obj = JSON.parse(data);
            			if (obj.res=="succ")
            			{
            				toastr.success('vous pouvez prendre un rendez-vous')
            			}
            			else
            			{
            				toastr.error('vous ne pouvez pas prendre un rendez-vous')
            			}
            }
		});
		 
});

$("#saveRDV").on('click',function(){

	const Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });

	var cinm = $("#cinMed").val();
	var cinp = $("#cinP").val();
	var date = $("#datee").val();	
	var heure = $("#timee").val();
	

	$.ajax({
			type: "GET",
            url: "AddRendezVous",
            data : {cinm:cinm,cinp:cinp,date:date,heure:heure},
            success: function (data) {
            	var obj = JSON.parse(data);
            	if (obj.res=="succ")
            	{
            		
      					Toast.fire({
        				icon: 'success',
        				title: 'ajouté avec succès'
     					 })
    				$('#modal-default').modal('toggle');
            	}
            	else
            	{
            		Toast.fire({
        				icon: 'error',
        				title: "Erreur d'ajout"
     					 })
            	}
            }
		});

});