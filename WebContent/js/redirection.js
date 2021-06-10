$("#xxx").click(function(){
    $("#con").load("annMed.jsp");
    $("#hed1").html("");
    $("#hed1").html("Annuaire Medecin");
});



$("#MRdv").click(function(){
    $("#con").load("RendezVous.jsp");
    $("#hed1").html("");
    $("#hed1").html("Mes Rendez-vous");
});

$("#calen").click(function(){
    $("#contain").load("calendar.jsp");
    $("#tit").html("");
    $("#tit").html("Liste des rendez-vous");
});

$("#dash").click(function(){
    $("#contain").load("dashboard.jsp");
    $("#tit").html("");
    $("#tit").html("Dashboard");
});

$("#pat").click(function(){
    $("#contain").load("patients.jsp");
    $("#tit").html("");
    $("#tit").html("liste des patients");
});


$("#M1").click(function(){
    $("#cont").load("Medicament.jsp");
    $("#hed2").html("");
    $("#hed2").html("Medicament");
});

$("#R1").click(function(){
    $("#cont").load("Region.jsp");
    $("#hed2").html("");
    $("#hed2").html("Region");
});

$("#S1").click(function(){
    $("#cont").load("Specialite.jsp");
    $("#hed2").html("");
    $("#hed2").html("Specialité");
});

