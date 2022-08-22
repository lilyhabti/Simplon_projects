
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Long Leaders</title>
<style type="text/css">
body {
	margin: 0;
	color: #6a6f8c;
	background: #c8c8c8;
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
	background-color: #A25B5B;
}

#logo {
	display: inline;
	color: #f3f3f3;
	font: bold 'roboto';
	font-size: 50px;
	margin-top: 20px;
	margin-left: 0px;
}

header {
	width: 100%;
	border-bottom: 1px solid #ccc;
	height: 38px;
	text-align: left;
}

.styled-table {
	border-collapse: collapse;
	margin-top: 100px;
	max-width: 90%;
	width: 800px;
	font-size: 0.9em;
	font-family: "Montserrat-SemiBold";
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
	margin-left: auto;
	margin-right: auto;
}

.styled-table thead tr {
	background-color: #A25B5B;
	color: #ffffff;
	text-align: center;
}

.styled-table th, .styled-table td {
	padding: 12px 15px;
	font-size: 1.5em;
}

.styled-table tbody tr {
	border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
	background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
	border-bottom: 2px solid rgba(40, 57, 101, .9);
}

.styled-table tbody tr.active-row {
	font-weight: bold;
	color: rgba(40, 57, 101, .9);
	text-align: center;
}

tr td a img {
	height: 25px;
	padding: 5px;
}

tr td a:hover img {
	height: 35px;
}

.ccsticky-nav ul {
	padding: 5px;
	margin: 0;
	padding-left: 20%;
	margin-right: 20px;
	list-style: none;
	text-align: right;
}

.ccsticky-nav ul li {
	display: inline;
	margin: 0;
}

.ccsticky-nav ul li a {
	padding: 5px;
	transition: all 0.2s ease;
}

i {
	color: #f3f3f3;
	font-size: 2rem;
	height: 28px;
	margin-top: 5px;
	position: absolute;
	right: 5%;
}

i:hover {
	color: #6a6f8c;
	font-size: 2.5rem;
	height: 28px;
	margin-top: 5px;
	position: absolute;
	right: 5%;
}

.par {
	position: absolute;
	right: 10%;
}

.par:hover {
	position: absolute;
	right: 10%;
}
.add{
position: absolute;
	right: 15%;
}
.add:hover {
	position: absolute;
	right: 15%;
}
</style>
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
</head>
<body>

	<header>
		<nav class="ccsticky-nav">
			<h1 id="logo">Long Leaders</h1>
			<ul>
				<li><a href="<%=request.getContextPath()%>/add"><i class="fa fa-plus add"></i></a></li>
				<li><a href="<%=request.getContextPath()%>/profile"><i class="fa fa-cog par"></i></a></li>
				<li><a href="Login"><i class="fas fa-sign-out-alt"></i></a></li>
			</ul>
		</nav>
	</header>
	<div class="container">
		<form method='GET' action='Main'>
			<table class="styled-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Full Name</th>
						<th>Email</th>
						<th>Departement</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${listEmployees}">
						<tr>
							<td><c:out value="${employee.id}" /></td>
							<td><c:out value="${employee.fullname}" /></td>
							<td><c:out value="${employee.email}" /></td>
							<td><c:out value="${employee.departement}" /></td>
							<td><a href="edit?id=<c:out value='${employee.id}' />"><i
									class="fa-solid fa-user-pen"></i></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${employee.id}' />"><i
									class="fa-solid fa-circle-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</form>
	</div>
</body>
</html>