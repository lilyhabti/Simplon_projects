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

.center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 500px;
	height: 550px;
	background: white;
	border-radius: 10px;
	box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.05);
	margin: 10px 0 0 0;
}

.center h1 {
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
	top: 40px;
	left: 0;
	width: 0%;
	height: 2px;
	background: #2691d9;
	transition: .5s;
}

.txt_field input:focus ~ label, .txt_field input:valid ~ label {
	top: -5px;
	color: #A25B5B;
}

.txt_field input:focus ~ span::before, .txt_field input:valid ~ span::before
	{
	width: 100%;
}

.pass {
	margin: -5px 0 20px 5px;
	color: #a6a6a6;
	cursor: pointer;
}

.pass:hover {
	text-decoration: underline;
}

input[type="submit"] {
	width: 100%;
	height: 50px;
	border: 1px solid;
	background-color:#A25B5B;
	border-radius: 25px;
	font-size: 18px;
	color: #e9f4fb;
	font-weight: 700;
	cursor: pointer;
	outline: none;
}

input[type="submit"]:hover {
	border-color: #CC9C75;
	transition: .5s;
}

.space {
	margin: 30px 0;
	text-align: center;
	font-size: 16px;
	color: #666666;
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


h2 {
	text-align: center;
	padding: 20px 0;
	border-bottom: 1px solid silver;
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


.add{
position: absolute;
	right: 10%;
}
.add:hover {
	position: absolute;
	right: 10%;
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
				<li><a href="<%=request.getContextPath()%>/list"><i class="fas fa-home add"></i></a></li>
				<li><a href="Login"><i class="fas fa-sign-out-alt"></i></a></li>
			</ul>
		</nav>
	</header>
	<div class="center">
	
			<form action="change" method="post">

			<h2>Change Password</h2>
		<div class="txt_field">
			<input type="password" name="oldpassword" id="oldpassword" required> 
				<label>Old Password:</label>
		</div>
		<div class="txt_field">
			<input type="password" name="newpassword" id="newpassword" required> 
				<label>New Password:</label>
		</div>
		<div class="txt_field">
			<input type="password" name="confirmpassword" id="confirmpassword" required> 
				<label>Confirm Password:</label>
		</div>
		
		<input type="submit" value="Save">
		</form>
	</div>
</body>
</html>