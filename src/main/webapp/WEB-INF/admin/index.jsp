<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				href="/admin">
				<div class="sidebar-brand-icon">
					<i class="fa fa-home fa-fw"></i>
				</div>
				<div class="sidebar-brand-text mx-3">Menú Administrador</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Sesión</div>

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
																	<th>Alias</th>
																	<th>Email</th>
																	<th>Password</th>
																	<th>Actualizar</th>
																	<th>Eliminar</th>
																</tr>
															</thead>
															<tfoot>
																<tr>
																	<th>Id</th>
																	<th>Alias</th>
																	<th>Email</th>
																	<th>Password</th>
																	<th>Actualizar</th>
																	<th>Eliminar</th>
																</tr>
															</tfoot>
															<tbody>
																<tr>
																	<td>1</td>
																	<td>Jose</td>
																	<td>jose@mail.cl</td>
																	<td>1234</td>
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
					<!-- Inicio registro -->
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<div class="row">
								<div class="col-lg-12">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">Registrar nuevo
												usuario</h1>
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
													<input type="password"
														class="form-control form-control-user" id="inputPassword"
														placeholder="Password">
												</div>
												<div class="col-sm-6">
													<input type="password"
														class="form-control form-control-user" id="repeatPassword"
														placeholder="Repita Password">
												</div>
											</div>
											<a href="/" class="btn btn-primary btn-user btn-block">
												Registrar cuenta </a>
											<hr>
										</form>
										<hr>

									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Fin registro -->
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