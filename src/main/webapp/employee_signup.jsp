	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
.container{
       height: 100vh;
      display:grid;
       place-content:center;
       border-radius: 300px;
}
form {
	border: 2px solid blue;
	width: 400px;
	height: 400px;
	margin: 20px;
	padding: 30px;
}

.form-block {
	display: flex;
	align-items: center;
	justify-content: space-around;
	bottom: 100px;
	border-radius: 200px;
}

#input-field {
	border: 2px solid green;
	width: 300px;
	height: 40px;
	padding: 10px;
	border-radius: 20px;
}
</style>
</head>
<body class="container">
<div class="form-block">
		<form action="signup" method="post">
			<input type="number" name="user_id" id="input-field"
				placeholder="enter id"> <br> <br>
				 <input
				type="text" name="user_name" id="input-field"
				placeholder="enter email"> <br> <br> 
				<input
				type="text" name="user_email" id="input-field"
				placeholder="enter email"> <br> <br> 
				<input
				type="password" name="user_password" id="input-field"
				placeholder="enter password"> <br> <br>
				 <input
				type="submit" value="Submit">

		</form>
	</div>
</body>
</html>