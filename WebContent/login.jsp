<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page language="java" import="model.*" %>
<%
Patient p = (Patient) session.getAttribute("patient");
Medecin m = (Medecin) session.getAttribute("medecin");
if(p!=null)
{
request.getRequestDispatcher("index.jsp").forward(request,response);	
}
else if (m != null)
{
	request.getRequestDispatcher("test.jsp").forward(request,response);
}
else
{
%>
<!DOCTYPE html>
<html>
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
  <link rel="stylesheet" href="plugins/toastr/toastr.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href=""><b>Rendez-Vous Medecin</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Sign in to start your session</p>

      <form action="" method="post" id="myForm">
        <div class="input-group mb-3">
          <input type="email" class="form-control" placeholder="Email" name="login">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="Mot de passe" name="pass">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row" style="margin-left: 5px;">
                   <div class="col-sm-4">
                   <label>Vous étes</label>
                   </div>
                   <div class="col-sm-4">
                   	<div class="form-group">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="rrr" value="p">
                          <label class="form-check-label">Patient</label>
                        </div>
                         </div>
                   </div>
                   <div class="col-sm-4">
                   	<div class="form-group">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="rrr" value="m">
                          <label class="form-check-label">Medecin</label>
                        </div>
                         </div>
                   </div>
                   </div>
        <div class="row">

          <!-- /.col -->
          <div class="mb-3" style="margin-left: 130px;">
            <button type="button" class="btn btn-primary btn-block" id="go">Sign In</button>
          </div>
          <!-- /.col -->
        </div>
      </form>


      
      <p class="mb-0">
        <a href="register.jsp" class="text-center">créer un nouveau compte</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<script src="js/Login.js"></script>
<script src="plugins/toastr/toastr.min.js"></script>
	<script src="plugins/sweetalert2/sweetalert2.min.js"></script>
</body>
</html>
<%}%>