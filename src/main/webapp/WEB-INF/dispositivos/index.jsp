<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>Registro Dispositivo</title>
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
				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>
				</nav>
				<!-- End of Topbar -->
				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Inicio registro -->
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">¡Registra un nuevo
												dispositivo!</h1>
										</div>
										<form class="user">
											<div class="form-group row">
												<div class="col-sm-6 mb-3 mb-sm-0">
													<input type="text" class="form-control form-control-user"
														id="nombreDispositivo"
														placeholder="Nombre del Dispositivo">
												</div>
												<div class="col-sm-6">
													<input type="text" class="form-control form-control-user"
														id="macDispositivo" placeholder="MAC">
												</div>
											</div>
											<div class="form-group">

												<input type="text" class="form-control form-control-user"
													id="ubicacion" placeholder="Ubicacion del dispositivo">

											</div>

											<div class="form-group">
												<div class="custom-control custom-checkbox small">
													<input type="checkbox" class="custom-control-input"
														id="customCheck"> <label
														class="custom-control-label" for="customCheck">Dispositivo
														publico</label>
												</div>
											</div>


											<a href="usuarios" class="btn btn-primary btn-user btn-block">
												Registrar dispositivo </a>
											<hr>
										</form>

									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Fin registro -->
					
					<!-- Inicio mantenedor -->
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Administrador de
												dispositivos</h1>
										</div>
										<div class="col-lg-12">
											<!-- DataTables Example -->
											<div class="card shadow mb-4">

												<div class="card-body">
													<div class="table-responsive">
														<table class="table table-bordered" id="dataTable"
															width="100%" cellspacing="0">
															<thead>
																<tr>
																	<th>Id</th>
																	<th>Nombre dispositivo</th>
																	<th>Mac Dispositivo</th>
																	<th>Ubicación</th>
																	<th>Público/Privado</th>
																	<th>Actualizar</th>
																	<th>Eliminar</th>
																</tr>
															</thead>
															<tfoot>
																<tr>
																	<th>Id</th>
																	<th>Nombre dispositivo</th>
																	<th>Mac Dispositivo</th>
																	<th>Ubicación</th>
																	<th>Público/Privado</th>
																	<th>Actualizar</th>
																	<th>Eliminar</th>
																</tr>
															</tfoot>
															<tbody>
																<tr>
																	<td>1</td>
																	<td>ESP8266-3</td>
																	<td>60:01:94:61:B1:FD</td>
																	<td>Puente Alto</td>
																	<td>Público</td>
																	<td><a href="dashboard"
																		class="btn btn-success btn-circle btn-sm"> <i
																			class="fas fa-arrow-right"></i>
																	</a></td>
																	<td><a href="#"
																		class="btn btn-danger btn-circle btn-sm"> <i
																			class="fas fa-trash"></i>
																	</a></td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
											<!--  Fin dataTables -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Fin mantenedor -->
					
				</div>
				<!-- End Page Content -->
			</div>
			<!-- End of Main Content -->

			<!-- Scroll to Top Button-->
			<a class="scroll-to-top rounded" href="#page-top"> <i
				class="fas fa-angle-up"></i>
			</a>

			<!-- Modal Logout -->
			<jsp:include page="../includes/modalLogout.jsp"></jsp:include>
			<!-- Modal Logout -->
		</div>
	</div>
	<!-- footer scripts -->
	<jsp:include page="../includes/footerscripts.jsp"></jsp:include>
	<!-- footer scripts -->
</body>

</html>
