<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style type="text/css">
body {
	margin: 0;
	color: #6a6f8c;
	background: #f4f3ee;
	font: 600 12px/14px "Montserrat-SemiBold";
}

*, :after, :before {
	box-sizing: border-box
}

.ccsticky-nav {
	display: flex;
	width: 100%;
	height: 65px;
	position: fixed;
	top: 0;
	background-color: black;
}

#logo {
	display: inline;
	color: #f3f3f3;
	font: bold 'roboto';
	font-size: 50px;
	margin-left: 0px;
}

header {
	width: 100%;
	border-bottom: 1px solid #ccc;
	height: 38px;
	text-align: left;
}

i {
	color: black;
	font-size: 5rem;
	height: 28px;
	margin-top: 5px;
	position: absolute;
	text-decoration: none;
}

i:hover {
	color: red;
}


.signout{
	right: 3%;
	color: white;
	font-size: 2rem;
	height: 28px;
	margin-top: 15px;
	position: absolute;
}
.signout:hover{
    color:red;
}
.container{
	margin-top:13rem;
}

</style>
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cosmo/bootstrap.min.css" />
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>

	<header>
		<nav class="ccsticky-nav">

			<h1 id="logo">SousTalent Management system</h1>
			<a href="AdminServlet"><i class="fas fa-sign-out-alt signout"></i></a>
			
		</nav>
	</header>
	
	<div class="container">
		<div class="row">

				<div class="col-md-2"></div>
				<div class="col-md-3 ml-2"><a href="<%=request.getContextPath()%>/student"><i class="fa fa-graduation-cap"></i></a></div>
				<div class="col-md-3 ml-3"><a href="<%=request.getContextPath()%>/course"><i class="fas fa-book book"></i></a></div>
				<div class="col-md-3 ml-3"><a href="<%=request.getContextPath()%>/professor"><i class='fas fa-chalkboard-teacher'></i></a></div>
				<div class="col-md-1"></div>
			</div>
	</div>

</body>
</html>