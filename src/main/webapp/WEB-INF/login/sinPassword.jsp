<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>Contraseña olvidada</title>
<jsp:include page="../includes/head.jsp"></jsp:include>
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
							<div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-2">¿Olvidaste tu
											contraseña?</h1>
										<p class="mb-4">Lo entendemos, pasan cosas. Solo ingresa
											tu dirección de correo electrónico a continuación y le
											enviaremos un enlace para restablecer su ¡contraseña!</p>
									</div>
									<form class="user">
										<div class="form-group">
											<input type="email" class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												placeholder="Ingresa tu correo electronico...">
										</div>
										<a href="/"
											class="btn btn-primary btn-user btn-block"> Resetear
											contraseña </a>
									</form>
									<hr>
									<div class="text-center">
										<a class="small" href="registro">Crear nueva cuenta</a>
									</div>
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

		</div>

	</div>

	<!-- footer scripts -->
	<jsp:include page="../includes/footerscripts.jsp"></jsp:include>
	<!-- footer scripts -->
</body>

</html>
