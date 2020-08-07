<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cl.jrios.model.entity.PrivacidadDispositivo"%>

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
				<!-- Menú superior -->
				<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
					<h1 class="h3 mb-0 text-gray-100">Sección de dispositivos</h1>

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
									data-target="#logoutModal">Logout</a>
							</div></li>
						<!-- Menú usuario -->
					</ul>
				</nav>
				<!-- Menú superior -->
				<hr>
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
										<form action="<c:url value='/dispositivos' />" method="post">
											<div class="form-group row">
												<div class="col-sm-6 mb-3 mb-sm-0">
													<input type="text" class="form-control form-control-user"
														id="nombre" name="nombre"
														placeholder="Nombre del Dispositivo">
												</div>
												<div class="col-sm-6">
													<input type="text" class="form-control form-control-user"
														id="mac" name="mac" placeholder="MAC">
												</div>
											</div>
											<div class="form-group">

												<input type="text" class="form-control form-control-user"
													id="ubicacion" name="ubicacion"
												placeholder="Ubicacion del dispositivo">

											</div>

											<!-- 											<div class="form-group"> -->
											<!-- 												<select class="form-control form-control-user" id="sensores" -->
											<!-- 													name="macDispositivo"> -->
											<%-- 													<c:forEach var="sensor" items="${sensores}"> --%>
											<%-- 														<option value="${sensor}">${sensor}</option> --%>
											<%-- 													</c:forEach> --%>
											<!-- 												</select> -->
											<!-- 											</div> -->

											<div class="form-group">
												<select class="form-control form-control-user"
													id="privacidad" name="privacidad">
													<c:forEach var="privacidad"
														items="${PrivacidadDispositivo.values()}">
														<option value="${privacidad}">${privacidad}</option>
													</c:forEach>
												</select>
											</div>
											<button type="submit"
												class="btn btn-primary btn-user btn-block">Registrar
												sensor</button>
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


							<!-- Modal actualizar -->
							<div class="modal fade" id="modalActualizar" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<form action="/dispositivos/actualizar" method="post">
											<div class="modal-header">
												<h5 class="modal-title">
													Actualizar Dispositivo:
													<c:out value="${dispositivo.getId() }"></c:out>
												</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>

											<div class="modal-body">

												<div class="form-group">
													<input type="text" class="form-control" id="nombre"
														name="nombre" placeholder="Nombre del dispositivo"
														value="${dispositivo.getNombre() }">
												</div>

												<div class="form-group">
													<input type="text" class="form-control form-control-user"
														id="mac" name="mac" placeholder="Mac del dispositivo"
														value="${dispositivo.getMac() }">
												</div>

												<div class="form-group">
													<input type="text" class="form-control form-control-user"
														id="ubicacion" name="ubicacion"
														placeholder="Ubicacion del dispositivo"
														value="${dispositivo.getUbicacion() }">
												</div>

												<div class="form-group">
													<select class="form-control form-control-user"
														id="privacidad" name="privacidad">
														<c:forEach var="privacidad"
															items="${PrivacidadDispositivo.values()}">
															<option value="${privacidad}">${privacidad}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="modal-footer">
												<button type="submit" class="btn btn-primary">Guardar
													cambios sensor</button>

												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
											</div>
										</form>
									</div>
								</div>

							</div>

							<!-- Modal actualizar # -->

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
															width="95%" cellspacing="0">
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
																<c:forEach var="dispositivo" items="${dispositivos}">
																	<tr>
																		<td>${dispositivo.id}</td>
																		<td>${dispositivo.nombre}</td>
																		<td>${dispositivo.mac}</td>
																		<td>${dispositivo.ubicacion}</td>
																		<td>${dispositivo.privacidad}</td>
																		<td><a
																			href='<c:out value="/dispositivos/actualizar?id=${dispositivo.getId()}" />'
																			class="btn btn-success btn-circle btn-sm"
																			data-toggle="modal" data-target="#modalActualizar">
																				<i class="fas fa-arrow-right"></i>
																		</a></td>
																		<td><a
																			href='<c:out value="/dispositivos/eliminar?id=${dispositivo.getId()}" />'
																			class="btn btn-danger btn-circle btn-sm"> <i
																				class="fas fa-trash"></i>
																		</a></td>
																	</tr>
																</c:forEach>
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
			<!-- Footer -->
			<jsp:include page="../includes/footers.jsp"></jsp:include>
			<!-- End of Footer -->
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
	<!-- footer data Table -->
	<jsp:include page="../includes/footersDataTable.jsp"></jsp:include>
	<!-- footer data Table -->
</body>

</html>
