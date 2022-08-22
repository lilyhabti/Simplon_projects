<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Space</title>
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
	background-color: black;
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
	background-color: black;
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

i {
	color: white;
	font-size: 2rem;
	height: 28px;
	margin-top: 15px;
	position: absolute;
	right: 5%;
}
.home {
	position: absolute;
	right: 10%;
}
.home:hover,.add:hover  {
	color:red;
}
</style>
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
</head>
<body>

	<header>
		<nav class="ccsticky-nav">
			<h1 id="logo">SousTalent Management system</h1>
			<a href="<%=request.getContextPath()%>/add"><i class="fa fa-plus add"></i></a>
			<a href="SpaceServlet"><i class="fas fa-home home"></i></a>
		</nav>
	</header>
	<div class="container">
		<form method='GET' action='StudentServlet'>
			<table class="styled-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Full Name</th>
						<th>Departement</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="professor" items="${listProfessors}">
						<tr>
							<td><c:out value="${professor.profid}" /></td>
							<td><c:out value="${professor.fullname}" /></td>
							<td><c:out value="${professor.departement}" /></td>
							<td><a href="edit?id=<c:out value='${course.profid}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${course.profid}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</form>
	</div>
</body>
</html>