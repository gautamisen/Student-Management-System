<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Admin Dashboard</title>
<meta content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
	name="viewport" />
<link rel="icon" href="/img/kaiadmin/favicon.ico" type="image/x-icon" />

<!-- Fonts and icons -->
<script src="/js/plugin/webfont/webfont.min.js"></script>
<script>
	WebFont.load({
		google : {
			families : [ "Public Sans:300,400,500,600,700" ]
		},
		custom : {
			families : [ "Font Awesome 5 Solid", "Font Awesome 5 Regular",
					"Font Awesome 5 Brands", "simple-line-icons", ],
			urls : [ "/css/fonts.min.css" ],
		},
		active : function() {
			sessionStorage.fonts = true;
		},
	});
</script>

<!-- CSS Files -->
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/plugins.min.css" />
<link rel="stylesheet" href="/css/kaiadmin.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- CSS Just for demo purpose, don't include it in your project -->
<link rel="stylesheet" href="/css/demo.css" />
</head>
<body>
	<div class="wrapper">
		<!-- Sidebar -->
		<jsp:include page="component/sidebar.jsp" />
		<!-- End Sidebar -->

		<div class="main-panel">
			<div class="main-header">
				<div class="main-header-logo">
					<!-- Logo Header -->
					<div class="logo-header" data-background-color="dark">
						<a href="index.html" class="logo"> <img
							src="/img/kaiadmin/logo_light.svg" alt="navbar brand"
							class="navbar-brand" height="20" />
						</a>
						<div class="nav-toggle">
							<button class="btn btn-toggle toggle-sidebar">
								<i class="gg-menu-right"></i>
							</button>
							<button class="btn btn-toggle sidenav-toggler">
								<i class="gg-menu-left"></i>
							</button>
						</div>
						<button class="topbar-toggler more">
							<i class="gg-more-vertical-alt"></i>
						</button>
					</div>
					<!-- End Logo Header -->
				</div>
				<!-- Navbar Header -->
				<jsp:include page="component/navbar.jsp" />
				<!-- End Navbar -->
			</div>

			<!-- Table Start -->
			<div class="container">
				<div class="page-inner">
					<div class="page-header">
						<h3 class="fw-bold mb-3">Student List</h3>
						
					</div>
					<div class="mt-3">
							<table class="table table-striped">

								<thead class="text-center">
									<tr>
										<td>SRNo</td>
										<td>Name</td>
										<td>Address</td>
										<td>Section</td>
										<td>Standard</td>
										<td>Marathi</td>
										<td>English</td>
										<td>Science</td>
										<td>Hindi</td>
										<td>Geography</td>
										<td>Total</td>
										<td>Percentage</td>
										<td>Grade</td>
										<td>Result</td>
										<td>Action</td>
									</tr>
								</thead>
								<tbody class="text-center">
								<c:forEach var="student" items="${studentList}" varStatus="loop">
									<tr>
										<td>${loop.index+1}</td>
										<td>${student.name}</td>
										<td>${student.address}</td>
										<td>${student.section}</td>
										<td>${student.standard}</td>
										<td>${student.marathi}</td>
										<td>${student.english}</td>
										<td>${student.science}</td>
										<td>${student.hindi}</td>
										<td>${student.geography}</td>
										<td>${student.total}</td>
										<td>${student.percentage}</td>
										<td>${student.grade}</td>
										<td>${student.result}</td>
										<td>
										<a href="/updateStudent/${student.id }">
										<button class="btn btn-success mb-2">Edit</button>
										</a>
										<a href="/deletestudent/${student.id}">
										<button class="btn btn-warning ">Delete</button>
										</a>
										
										</td>
									</tr>
								</c:forEach>
								</tbody>

							</table>
						</div>
				</div>
			</div>

			<!-- Table End -->


			<footer class="footer">
				<div class="container-fluid d-flex justify-content-between">
					<nav class="pull-left">
						<ul class="nav">
							<li class="nav-item"><a class="nav-link"
								href="http://www.themekita.com"> ThemeKita </a></li>
							<li class="nav-item"><a class="nav-link" href="#"> Help
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">
									Licenses </a></li>
						</ul>
					</nav>
					<div class="copyright">
						2024, made with <i class="fa fa-heart heart text-danger"></i> by <a
							href="http://www.themekita.com">ThemeKita</a>
					</div>
					<div>
						Distributed by <a target="_blank" href="https://themewagon.com/">ThemeWagon</a>.
					</div>
				</div>
			</footer>
		</div>

		<!-- Custom template | don't include it in your project! -->
		<div class="custom-template">
			<div class="title">Settings</div>
			<div class="custom-content">
				<div class="switcher">
					<div class="switch-block">
						<h4>Logo Header</h4>
						<div class="btnSwitch">
							<button type="button" class="selected changeLogoHeaderColor"
								data-color="dark"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="blue"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="purple"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="light-blue"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="green"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="orange"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="red"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="white"></button>
							<br />
							<button type="button" class="changeLogoHeaderColor"
								data-color="dark2"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="blue2"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="purple2"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="light-blue2"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="green2"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="orange2"></button>
							<button type="button" class="changeLogoHeaderColor"
								data-color="red2"></button>
						</div>
					</div>
					<div class="switch-block">
						<h4>Navbar Header</h4>
						<div class="btnSwitch">
							<button type="button" class="changeTopBarColor" data-color="dark"></button>
							<button type="button" class="changeTopBarColor" data-color="blue"></button>
							<button type="button" class="changeTopBarColor"
								data-color="purple"></button>
							<button type="button" class="changeTopBarColor"
								data-color="light-blue"></button>
							<button type="button" class="changeTopBarColor"
								data-color="green"></button>
							<button type="button" class="changeTopBarColor"
								data-color="orange"></button>
							<button type="button" class="changeTopBarColor" data-color="red"></button>
							<button type="button" class="selected changeTopBarColor"
								data-color="white"></button>
							<br />
							<button type="button" class="changeTopBarColor"
								data-color="dark2"></button>
							<button type="button" class="changeTopBarColor"
								data-color="blue2"></button>
							<button type="button" class="changeTopBarColor"
								data-color="purple2"></button>
							<button type="button" class="changeTopBarColor"
								data-color="light-blue2"></button>
							<button type="button" class="changeTopBarColor"
								data-color="green2"></button>
							<button type="button" class="changeTopBarColor"
								data-color="orange2"></button>
							<button type="button" class="changeTopBarColor" data-color="red2"></button>
						</div>
					</div>
					<div class="switch-block">
						<h4>Sidebar</h4>
						<div class="btnSwitch">
							<button type="button" class="changeSideBarColor"
								data-color="white"></button>
							<button type="button" class="selected changeSideBarColor"
								data-color="dark"></button>
							<button type="button" class="changeSideBarColor"
								data-color="dark2"></button>
						</div>
					</div>
				</div>
			</div>
			<div class="custom-toggle">
				<i class="icon-settings"></i>
			</div>
		</div>
		<!-- End Custom template -->
	</div>
	<!--   Core JS Files   -->
	<script src="/js/core/jquery-3.7.1.min.js"></script>
	<script src="/js/core/popper.min.js"></script>
	<script src="/js/core/bootstrap.min.js"></script>

	<!-- jQuery Scrollbar -->
	<script src="/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>

	<!-- Chart JS -->
	<script src="/js/plugin/chart.js/chart.min.js"></script>

	<!-- jQuery Sparkline -->
	<script src="/js/plugin/jquery.sparkline/jquery.sparkline.min.js"></script>

	<!-- Chart Circle -->
	<script src="/js/plugin/chart-circle/circles.min.js"></script>

	<!-- Datatables -->
	<script src="/js/plugin/datatables/datatables.min.js"></script>

	<!-- Bootstrap Notify -->
	<script src="/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>

	<!-- jQuery Vector Maps -->
	<script src="/js/plugin/jsvectormap/jsvectormap.min.js"></script>
	<script src="/js/plugin/jsvectormap/world.js"></script>

	<!-- Sweet Alert -->
	<script src="/js/plugin/sweetalert/sweetalert.min.js"></script>

	<!-- Kaiadmin JS -->
	<script src="/js/kaiadmin.min.js"></script>

	<!-- Kaiadmin DEMO methods, don't include it in your project! -->
	<script src="/js/setting-demo.js"></script>
	<script src="/js/demo.js"></script>
	<script>
		$("#lineChart").sparkline([ 102, 109, 120, 99, 110, 105, 115 ], {
			type : "line",
			height : "70",
			width : "100%",
			lineWidth : "2",
			lineColor : "#177dff",
			fillColor : "rgba(23, 125, 255, 0.14)",
		});

		$("#lineChart2").sparkline([ 99, 125, 122, 105, 110, 124, 115 ], {
			type : "line",
			height : "70",
			width : "100%",
			lineWidth : "2",
			lineColor : "#f3545d",
			fillColor : "rgba(243, 84, 93, .14)",
		});

		$("#lineChart3").sparkline([ 105, 103, 123, 100, 95, 105, 115 ], {
			type : "line",
			height : "70",
			width : "100%",
			lineWidth : "2",
			lineColor : "#ffa534",
			fillColor : "rgba(255, 165, 52, .14)",
		});
	</script>
</body>
</html>
