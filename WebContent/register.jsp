<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Alo Medecin</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
    <link rel="stylesheet" href="plugins/toastr/toastr.min.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href=""><b>Alo Medecin</b></a>
  </div>

  <div class="card">
    <div class="card-body register-card-body">
      <p class="login-box-msg">créer un nouveau compte</p>

      <form action="../../index.html" method="post" id="myForm">
      				 <div class="form-group">
                        <label>Vous étes</label>
                        <select class="form-control" id="ve">
                          <option></option>
                          <option value="p">Patient</option>
                          <option value="m">Medecin</option>
                        </select>
                      </div>
     			  <div class="form-group">
                     <input type="text" class="form-control" id="cin" placeholder="CIN">
                  </div>
                  <div class="form-group">
                     <input type="text" class="form-control" id="nom" placeholder="nom">
                  </div>
                  <div class="form-group">
                     <input type="text" class="form-control" id="prenom" placeholder="prénom">
                  </div>
                  <div class="form-group">
                     <input type="date" class="form-control" id="datenaissance">
                  </div>
                  <div class="form-group">
                     <input type="text" class="form-control" id="tel" placeholder="Telephone">
                  </div>
                  <div class="form-group">
                     <input type="text" class="form-control" id="adr" placeholder="Adresse">
                  </div>
                 
                     
                  
                   <div class="row">
                   <div class="col-sm-2">
                   <label>Sexe:</label>
                   </div>
                   <div class="col-sm-4">
                   	<div class="form-group">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="radio1" value="Homme">
                          <label class="form-check-label">Homme</label>
                        </div>
                         </div>
                   </div>
                   <div class="col-sm-4">
                   	<div class="form-group">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="radio1" value="Femme">
                          <label class="form-check-label">Femme</label>
                        </div>
                         </div>
                   </div>
                   </div>
                  <div class="form-group">
                     <input type="email" class="form-control" id="email" placeholder="Email">
                  </div>
                  <div class="form-group">
                     <input type="password" class="form-control" id="password" placeholder="password">
                  </div>
                  <div class="form-group">
                     <input type="text" class="form-control" id="telc" placeholder="Téléphone cabinet">
                  </div>
                  <div class="form-group" id="divsp">
                        <label>Spécialité</label>
                        <select class="form-control" id="spec">
                          
                        </select>
                  </div>
                  <div class="form-group" id="divrg">
                        <label>Région</label>
                        <select class="form-control" id="reg">
                         
                        </select>
                  </div>
                  <div class="row">
          <div class="mb-3" style="margin-left: 10px;">
            <button type="button" class="btn btn-primary btn-block" id="valid">Inscription</button>
          </div>
          <!-- /.col -->
        </div>
      </form>



      <a href="login.jsp" class="text-center">J'ai déjà un compte</a>
    </div>
    <!-- /.form-box -->
  </div><!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<!-- AdminLTE App -->
<script src="plugins/toastr/toastr.min.js"></script>
	<script src="plugins/sweetalert2/sweetalert2.min.js"></script>
<script src="dist/js/adminlte.min.js"></script>
<script src="js/register.js"></script>
</body>
</html>
