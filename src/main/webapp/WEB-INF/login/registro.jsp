<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>Registro de Usuario</title>
<jsp:include page="../includes/head.jsp"></jsp:include>
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
							<form class="user">
								<div class="form-group row">
									<input type="text" class="form-control form-control-user"
										id="exampleFirstName"
										placeholder="Nombre de nuevo usuario (Alias)">
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										id="inputEmail" placeholder="Email del nuevo usuario">
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											id="inputPassword" placeholder="Password">
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											id="repeatPassword" placeholder="Repita Password">
									</div>
								</div>
								<a href="/" class="btn btn-primary btn-user btn-block">
									Registrar cuenta </a>
								<hr>
							</form>
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
