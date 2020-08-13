<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">

<head>
<title>Dashboard</title>
<jsp:include page="../includes/head.jsp"></jsp:include>

<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
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
					<h1 class="h3 mb-0 text-gray-100">Dashboard</h1>

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

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800"></h1>

						<select name="mac" id="dispositivo" class="col-sm-5">
							<option value="" selected>Seleccione dispositivo...</option>
							<c:forEach var="dispo" items="${sensores}">
							
								<option value="${dispo.getDispositivo().getMac()}">${dispo.getDispositivo().getMac()} - ${dispo.getNombre()}</option>
							</c:forEach>
						</select> 
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
				<!-- Footer -->
				<jsp:include page="../includes/footers.jsp"></jsp:include>
				<!-- End of Footer -->
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

	<!-- Script para grafica de dashboard -->
	<script src="../vendor/chart.js/Chart.min.js"></script>
	<script src="../js/dashboard.js"></script>

</body>

</html>