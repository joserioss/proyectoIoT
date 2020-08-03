<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cl.jrios.model.entity.Rol"%>

<!DOCTYPE html>
<html>
<head>
<title>Administrador</title>
<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Slidebar -->
		<ul
			class="navbar-nav bg-gradient-secondary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/home">
				<div class="sidebar-brand-icon">
					<i class="fa fa-home fa-fw"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Menú Administrador</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">
				Sesión: <br>
				<c:out value="${username}"></c:out>
			</div>


			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapsePages"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-cog"></i> <span>Sesión</span></a>
				<div id="collapsePages" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">

						<h6 class="collapse-header">Cuenta actual</h6>


						<a class="dropdown-item" href="/" data-toggle="modal"
							data-target="#logoutModal"> <i
							class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
							Cerrar sesión
						</a>

					</div>
				</div></li>


			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

			<!-- Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->
		</ul>
		<!-- Slidebar -->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Menú superior -->
				<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
					<h1 class="h3 mb-0 text-gray-100">Acceso privado</h1>

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

					<!-- Inicio mantenedor -->
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Administrador de
												usuarios</h1>
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
																	<th>Nombre</th>
																	<th>Correo</th>
																	<th>Contraseña</th>
																	<th>Rol</th>
																	<th>Eliminar</th>
																</tr>
															</thead>
															<tfoot>
																<tr>
																	<th>Id</th>
																	<th>Nombre</th>
																	<th>Correo</th>
																	<th>Contraseña</th>
																	<th>Rol</th>
																	<th>Eliminar</th>
																</tr>
															</tfoot>
															<tbody>

																<c:forEach var="usuario" items="${usuarioDto.usuarios}">
																	<tr>
																		<td>${usuario.id}</td>
																		<td>${usuario.nombre}</td>
																		<td>${usuario.correo}</td>
																		<td>${usuario.contrasenia.substring(0, 10)}***</td>
																		<td>${usuario.rol}</td>
																		<td><a
																			href='<c:out value="/admin/eliminar?id=${usuario.getId()}" />'
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
					<!-- Inicio registro -->
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<div class="row">
								<div class="col-lg-12">
									<main>
										<div class="container-fluid">
											<h1 class="mt-4">Administrador:</h1>

											<form action="<c:url value='/admin' />" method="post">

												<!-- nombre -->
												<div class="form-group">
													<label for="nombre">Nombre</label> <input type="text"
														class="form-control" id="nombre" name="nombre">
												</div>

												<!-- correo -->
												<div class="form-group">
													<label for="correo">Correo</label> <input type="email"
														class="form-control" id="correo" name="correo">
												</div>

												<!-- contraseña -->
												<div class="form-group">
													<label for="correo">Contraseña</label> <input
														type="password" class="form-control" id="contrasenia"
														name="contrasenia">
												</div>

												<div class="form-group">
													<label for="rol">Rol</label> <select class="form-control"
														id="rol" name="rol">
														<c:forEach var="rol" items="${Rol.values()}">
															<option value="${rol}">${rol}</option>
														</c:forEach>
													</select>
												</div>

												<button type="submit" class="btn btn-primary">Submit</button>
											</form>

										</div>
									</main>
								</div>
							</div>
						</div>
					</div>
					<!-- Fin registro -->
				</div>
				<!-- End Page Content -->

				<!-- Footer -->
				<jsp:include page="../includes/footers.jsp"></jsp:include>
				<!-- End of Footer -->
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
	<!-- footer data Table -->
	<jsp:include page="../includes/footersDataTable.jsp"></jsp:include>
	<!-- footer data Table -->

</body>
</html>