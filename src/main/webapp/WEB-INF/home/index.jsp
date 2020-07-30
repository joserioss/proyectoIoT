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
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Bienvenido:</h1>


						<a href="<c:url value = "home/dashboard"/>"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
						</a>
					</div>

				</div>

				<hr class="sidebar-divider my-0">
				<div class="card o-hidden border-0 shadow-lg my-5">

					<div class="container-fluid">

						<hr>

						<!-- DataTales Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Dispositivos
									seleccionados</h6>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
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
											<tr>
												<td>ESP8266-3</td>
												<td>Movimiento</td>
												<td>60:01:94:61:B1:FD</td>
												<td>Puente Alto</td>
												<td><a href="<c:url value = "home/dashboard"/>"
													class="btn btn-success btn-circle btn-sm"> <i
														class="fas fa-arrow-right"></i>
												</a></td>
												<td><a href="#"
													class="btn btn-danger btn-circle btn-sm"> <i
														class="fas fa-trash"></i>
												</a></td>
											</tr>
											<tr>
												<td>ESP8266-4</td>
												<td>Movimiento</td>
												<td>2C:3A:E8:42:0E:53</td>
												<td>Rancagua</td>
												<td><a href="<c:url value = "home/dashboard"/>"
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
						<hr>
					</div>
				</div>

				<hr class="sidebar-divider my-0">

				<div class="card o-hidden border-0 shadow-lg my-5">

					<div class="container-fluid">
						<hr>
						<!-- DataTables Example -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Sensores
									disponibles</h6>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>Dispositivo</th>
												<th>Sensor</th>
												<th>MAC</th>
												<th>Ubicación</th>
												<th>Selección</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th>Dispositivo</th>
												<th>Sensor</th>
												<th>MAC</th>
												<th>Ubicación</th>
												<th>Selección</th>
											</tr>
										</tfoot>
										<tbody>
											<tr>
												<td>ESP8266-1</td>
												<td>Ultrasonico</td>
												<td>2B:3A:E1:42:02:53</td>
												<td>Puente Alto</td>
												<td><a href="#" class="btn btn-primary btn-icon-split">
														<span class="icon text-white-50"> <i
															class="fas fa-check"></i>
													</span>
												</a></td>
											</tr>
											<tr>
												<td>ESP8266-2</td>
												<td>Velocidad del viento</td>
												<td>2B:3A:11:42:0B:52</td>
												<td>Rancagua</td>
												<td><a href="#" class="btn btn-primary btn-icon-split">
														<span class="icon text-white-50"> <i
															class="fas fa-check"></i>
													</span>
												</a></td>
											</tr>
											<tr>
												<td>ARDUINO-1</td>
												<td>Presencia</td>
												<td>5B:3A:E1:42:02:58</td>
												<td>Renca</td>
												<td><a href="#" class="btn btn-primary btn-icon-split">
														<span class="icon text-white-50"> <i
															class="fas fa-check"></i>
													</span>
												</a></td>
											</tr>
											<tr>
												<td>ARDUINO-2</td>
												<td>Ultrasonico</td>
												<td>70:3A:E1:42:02:51</td>
												<td>Peñalolen</td>
												<td><a href="#" class="btn btn-primary btn-icon-split">
														<span class="icon text-white-50"> <i
															class="fas fa-check"></i>
													</span>
												</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!--  Fin dataTables -->
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
		</div>

		<!-- footer scripts -->
		<jsp:include page="../includes/footerscripts.jsp"></jsp:include>
		<!-- footer scripts -->
</body>

</html>