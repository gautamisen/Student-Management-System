<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">
.footer {
	position: fixed;
	bottom: 0;
	left: 0;
	text-align: center;
	width: 100%;
	height: 40px;
}

.color {
	background-color: aqua;
}

.left-me-ja {
	margin-left: 1140px;
}

.jara-nicha-aao-ji {
	margin-top: 100px;
}
</style>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<!-- Navbar --> 
	<section>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">Home
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Service</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">AboutUs</a>
					</li>
					<li class="nav-item"><a class="nav-link " href="#">Contact</a>
					</li>

				</ul>
				<span class="left-me-ja">
					<a href="/signin" class="text-decoration-none text-white">
					<button class="btn btn-primary ">  SignIn</button></a>
				</span>
			</div>
		</nav>
	</section>


	<!-- Hero layout -->

	
	<div id="carouselExampleControls " class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="/images/school1.jpg" class="d-block w-50" alt="...">
			</div>
			<div class="carousel-item">
				<img src="/images/school1.jpg" class="d-block w-50" alt="...">
			</div>
			<div class="carousel-item">
				<img src="/images/school1.jpg" class="d-block w-50" alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>



	<!-- footer -->
	<section>
		<footer class="footer">
			<span>Student Management System</span> <span>&copy;</span> <span
				id="currentyear"></span> <span>All Rigths are Reserved</span>
		</footer>
	</section>
	<script type="text/javascript">
		const year = document.getElementById("currentyear");
		const date = new Date();
		const c = date.getFullYear();
		year.textContent = c;
	</script>
</body>
</html>