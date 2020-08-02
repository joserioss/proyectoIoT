<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- dataTable a espaÃ±ol -->
<script>
	const cdn = "//cdn.datatables.net/plug-ins/1.10.21/i18n/Spanish.json"
	$(document).ready(function() {
		$('#dataTable').DataTable({
			"language" : {
				"url" : cdn
			}
		});
	});
</script>
<!-- dataTable a espaÃ±ol #-->
<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
	crossorigin="anonymous"></script>
<script src="assets/demo/datatables-demo.js"></script>