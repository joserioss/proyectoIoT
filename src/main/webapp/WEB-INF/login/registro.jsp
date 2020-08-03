<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Jose Rios">



<!-- Custom fonts for this template-->
<link href="<c:out value='vendor/fontawesome-free/css/all.css'/>"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<c:out value='css/sb-admin-2.css'/>" rel="stylesheet">

<title>Registro de Usuario</title>

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">¡Registra tu nueva
									cuenta!</h1>
							</div>
							<!-- formulario de login -->

							<form class="mt-4" modelAttribute="usuario"
								action='<c:out value="/registro" />' method="post">
								<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											<input type="hidden" id="id" name="id" value="1" />
										</div>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<input class="form-control" type="text" id="nombre"
											name="nombre" placeholder="tu nombre">
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<input class="form-control" type="email" id="correo"
											name="correo" placeholder="tu correo">
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<input class="form-control" type="password" id="contrasenia"
											name="contrasenia" placeholder="tu contraseña">
									</div>
								</div>
								<div class="col-lg-12">
                                        <div class="form-group">
                                            <input class="form-control" type="password" id="contrasenia_"
                                                name="contrasenia_" placeholder="tu contraseña otra vez">
                                        </div>
                                    </div>
								<div class="col-lg-12 text-center">
									<button type="submit" class="btn btn-block btn-dark">Ingresar</button>
								</div>
								<hr>
							</form>
							<!-- formulario de login # -->

							<hr>
							<div class="text-center">
								<a class="small" href="/"> ¿Ya tienes una cuenta? ¡Iniciar
									sesión!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- footer scripts -->
	<jsp:include page="../includes/footerscripts.jsp"></jsp:include>
	<!-- footer scripts -->

</body>

</html>
