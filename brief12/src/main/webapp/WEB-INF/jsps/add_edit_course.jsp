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
i {
	color: white;
	font-size: 2rem;
	height: 28px;
	margin-top: 15px;
	position: absolute;
	right: 5%;
}
.home:hover  {
	color:red;
}
.center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 600px;
	height:400px;
	background: white;
	border-radius: 10px;
	box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.05);
	margin:10px 0 0 0;
}
.center h2 {
	text-align: center;
	padding: 20px 0;
	border-bottom: 1px solid silver;
}
.center form {
	padding: 0 40px;
	box-sizing: border-box;
}
form .txt_field {
	position: relative;
	border-bottom: 2px solid #adadad;
	margin: 30px 0;
}
.txt_field input {
	width: 100%;
	padding: 0 5px;
	height: 40px;
	font-size: 16px;
	border: none;
	background: none;
	outline: none;
}
.txt_field label {
	position: absolute;
	top: 50%;
	left: 5px;
	color: #adadad;
	transform: translateY(-50%);
	font-size: 16px;
	pointer-events: none;
	transition: .5s;
}
.txt_field span::before {
	content: '';
	position: absolute;
	top:40px;
	left: 0;
	width: 0%;
	height: 2px;
	background: #2691d9;
	transition: .5s;
}
.txt_field input:focus ~ label, .txt_field input:valid ~ label {
	top: -5px;
	color: black;
}
.txt_field input:focus ~ span::before, .txt_field input:valid ~ span::before
	{
	width: 100%;
}
input[type="submit"] {
	width: 100%;
	height: 50px;
	border: 1px solid;
	background: black;
	border-radius: 25px;
	font-size: 18px;
	color: #e9f4fb;
	font-weight: 700;
	cursor: pointer;
	outline: none;
}
input[type="submit"]:hover {
	border-color: grey;
	transition: .5s;
}
</style>
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
</head>
<body>

	<header>
		<nav class="ccsticky-nav">
			<h1 id="logo">SousTalent Management system</h1>
			<a href="SpaceServlet"><i class="fas fa-home home"></i></a>
		</nav>
	</header>
	 <div class="center">
    
        <c:if test="${existingCourse.courseid != null}">
			 <form action="update" method="post">
	    </c:if>
	    
		<c:if test="${existingCourse.courseid == null}">
			 <form action="insert" method="post">
		</c:if>	
		
		<caption>
			 <h2>
				<c:if test="${existingCourse.courseid != null}">Edit Course </c:if>
				<c:if test="${existingCourse.courseid == null}">Add New Course</c:if>
			 </h2>
		</caption>
		    <c:if test="${existingCourse.courseid != null}">
					<input type="hidden" name="id" value="<c:out value='${existingCourse.courseid}' />" />
				</c:if>
			<div class="txt_field">
				<input type="text" value="<c:out value='${existingCourse.coursename}' />" name="coursename" id="coursename" required>
				 <label>Course Name:</label>
			</div>
			<div class="txt_field">
				<input type="text" value="<c:out value='${existingCourse.description}' />" name="description" id="description" required>
				 <label>Description:</label>
			</div>
			<div class="txt_field">
				<input type="text" value="<c:out value='${existingCourse.duration}' />" name="duration" id="duration" required>
				 <label>Duration:</label>
			</div>
			
			<input type="submit" value="Save">
		</form>
	</div>
</body>
</html>