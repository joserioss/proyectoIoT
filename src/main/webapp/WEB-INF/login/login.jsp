<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Jose Rios">
<meta name="author" content="">

<title>IoT - Login</title>

<!-- Custom fonts for this template-->
<link href="<c:out value='/vendor/fontawesome-free/css/all.min.css'/>"
	rel="stylesheet">
<!-- Custom fonts for this template-->

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:out value='/css/sb-admin-2.min.css'/>" rel="stylesheet">
<!-- <link href="css/sb-admin-2.min.css" rel="stylesheet"> -->

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-3"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Inicio de sesión</h1>
									</div>
									<!--|== Inicio - Mensaje error ======================|-->
									<c:if test="${error}">
										<div class="alert alert-warning alert-dismissible fade show"
											role="alert">
											<strong>¡Error!</strong> credenciales inválidas
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
									</c:if>
									<!--|== Fin - Mensaje error =========================|-->
									
									<!-- Inicio Formulario de login 	 -->
									<form action="<c:url value='/login'/>" method="post">
										<div class="form-group">
											<label class="small mb-1" for="correo">Correo</label> <input
												id="correo" name="correo" class="form-control py-4"
												id="inputEmailAddress" type="email"
												placeholder="Ingrese su correo" />
										</div>

										<div class="form-group">
											<label class="small mb-1" for="inputPassword">Contraseña</label>
											<input id="contrasenia" name="contrasenia"
												class="form-control py-4" type="password"
												placeholder="Ingrese su contraseña" />
										</div>
										<div
											class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
											<button class="btn btn-primary btn-user btn-block"
												type="submit">Login</button>
										</div>

									</form>
									<!-- formulario de login # -->
									<hr>
									<div class="text-center">
										<a class="small" href="registro">¡Registrate gratis!</a>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="../js/sb-admin-2.min.js"></script>

	<!-- Script para grafica de dashboard -->
	<script src="../vendor/chart.js/Chart.min.js"></script>
	<script src="../js/dashboard.js"></script>


</body>

</html>