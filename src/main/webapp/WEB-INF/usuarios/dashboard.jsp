<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>Dashboard</title>
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

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
						<div class="btn-group" role="group">
							<button id="btnGroupDrop1" type="button"
								class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">Dispositivos
								disponibles</button>
							<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
								<a class="dropdown-item" href="dashboard">ESP8266-3</a>
								<a class="dropdown-item" href="dashboard">ESP8266-4</a>
							</div>
						</div>
					</div>

				</div>
				<!-- End of Main Content -->
				<div class="row">
					<div class="col-xl-1 col-lg-1"></div>
					<!-- Area Chart -->
					<div class="col-xl-10 col-lg-10">
						<div class="card shadow mb-4">
							<!-- Card Header - Dropdown -->
							<div
								class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
								<h6 class="m-0 font-weight-bold text-primary">Lectura en
									tiempo real</h6>

								<!-- Menu del grafico -->
								<div class="dropdown no-arrow">
									<a class="dropdown-toggle" href="#" role="button"
										id="dropdownMenuLink" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"> <i
										class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
									</a>
									<div
										class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
										aria-labelledby="dropdownMenuLink">
										<div class="dropdown-header">Dropdown Header:</div>
										<a class="dropdown-item" href="#">Action</a> <a
											class="dropdown-item" href="#">Another action</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#">Something else here</a>
									</div>
								</div>
								<!-- Menu del grafico -->
								
							</div>
							<!-- Card Body -->
							<div class="card-body">
								<div class="chart-area">
									<canvas id="myAreaChart"></canvas>
								</div>
							</div>
							<div class="col-xl-1 col-lg-1"></div>
						</div>
					</div>
				</div>

				<div class="col-xl-1 col-lg-1"></div>
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