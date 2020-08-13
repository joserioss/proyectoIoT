<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">

<head>
<title>Home</title>
<jsp:include page="../includes/head.jsp"></jsp:include>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Slidebar -->
		<jsp:include page="../includes/slidebar.jsp"></jsp:include>
		<!-- Slidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Menú superior -->
				<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
					<h1 class="h3 mb-0 text-gray-100">Sección central</h1>

					<ul class="navbar-nav ml-auto mr-0 mr-md-2">
						<!-- Menú usuario -->
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" id="userDropdown" href="#"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="userDropdown">
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/" data-toggle="modal"
									data-target="#logoutModal"><i class="fa fa-book fa-fw"></i>Logout</a>
								<!-- 								<a class="dropdown-item" href="/user"><i -->
								<!-- 									class="fas fa-fw fa-tachometer-alt"></i> Dashboard</a> -->
							</div></li>
						<!-- Menú usuario -->
					</ul>
				</nav>
				<!-- Menú superior -->
				<hr>
				<!-- Begin Page Content -->
				<hr class="sidebar-divider my-0">

				<div class="card o-hidden border-0 shadow-lg my-5">

					<div class="container-fluid">

						<!-- DataTales Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Dispositivos
									seleccionados</h6>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="95%"
										cellspacing="0">
										<thead>
											<tr>
												<th>Dispositivo</th>
												<th>Sensor</th>
												<th>MAC</th>
												<th>Ubicación</th>
												<th>Ver detalles</th>
												<th>Eliminar</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>Dispositivo</th>
												<th>Sensor</th>
												<th>MAC</th>
												<th>Ubicación</th>
												<th>Ver detalles</th>
												<th>Eliminar</th>
											</tr>
										</tfoot>
										<tbody>
											<c:forEach var="sensor" items="${sensores}">
												<c:if test="${sensor.getDispositivo() != null }">

													<tr>
														<td>${sensor.getDispositivo().getNombre()}</td>
														<td>${sensor.nombre}</td>
														<td>${sensor.dispositivo}</td>
														<td>${sensor.getDispositivo().getUbicacion()}</td>
														<td><a
															href="<c:url value = '/user?mac=${sensor.getDispositivo().getMac()}&nombre=${sensor.nombre}' />"
															class="btn btn-sm btn-primary">
																<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
														</a></td>
														<td><a
															href='<c:out value = "/home/eliminar?mac=${sensor.getDispositivo().getMac()}&nombre=${sensor.nombre}" />'
															class="btn btn-danger btn-circle btn-sm"> <i
																class="fas fa-trash"></i>
														</a></td>
													</tr>
												</c:if>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
						<hr>
					</div>
				</div>

				<hr class="sidebar-divider my-0">

				<div class="card o-hidden border-0 shadow-lg my-5">

					<div class="container-fluid">
						<hr>
						<!-- inicio Vinculacion -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Vinculación</h6>
							</div>
							<div class="card-body">

								<!-- Formulario vinculacion -->
								<form action="home" method="post">

									<div class="form-group">

										<div class="col-sm-10">
											<label for="dispositivo" class="col-sm-5 col-form-label">Dispositivo</label>
											<select name="mac" id="dispositivo" class="col-sm-5">
												<option value="" selected>Seleccione dispositivo...</option>
												<c:forEach var="dispo" items="${dispositivos}">
													<option value="${dispo.getMac()}">${dispo.getMac()}</option>
												</c:forEach>
											</select>

										</div>

										<div class="col-sm-10">
											<label for="sensor" class="col-sm-5 col-form-label">Sensor</label>
											<select name="nombre" id="sensor" class="col-sm-5">
												<option value="" selected>Seleccione sensor...</option>
												<c:forEach var="sensor" items="${sensores}">
													<option value="${sensor.getNombre()}">${sensor.getNombre()}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group"></div>

									<div class="form-group">

										<div class="col-sm-12">
											<button type="submit" class="btn btn-primary">Agregar</button>
										</div>
									</div>


								</form>

							</div>
						</div>
						<!--  Fin vinculacion -->
						<hr>
					</div>
					<!-- End of Main Content -->

				</div>

				<!-- End of Page Wrapper -->

				<!-- Scroll to Top Button-->
				<a class="scroll-to-top rounded" href="#page-top"> <i
					class="fas fa-angle-up"></i>
				</a>

				<!-- Modal Logout -->
				<jsp:include page="../includes/modalLogout.jsp"></jsp:include>
				<!-- Modal Logout -->
			</div>

			<!-- Footer -->
			<jsp:include page="../includes/footers.jsp"></jsp:include>
			<!-- End of Footer -->
		</div>

		<!-- footer scripts -->
		<jsp:include page="../includes/footerscripts.jsp"></jsp:include>
		<!-- footer scripts -->
		<!-- footer data Table -->
		<jsp:include page="../includes/footersDataTable.jsp"></jsp:include>
		<!-- footer data Table -->
</body>

</html>