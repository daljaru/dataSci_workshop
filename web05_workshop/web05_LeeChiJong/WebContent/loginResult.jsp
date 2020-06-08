<%@page import="content.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% User user = (User)session.getAttribute("user");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
	*{
		margin: auto;
	}
	#login_success_box{
		width: 600px;
		height: 200px;
		border: 1px solid black;
		margin-top : 250px;
		align-content: center;
	}
</style>
</head>
<body>
<div class="container">
	<div class="row">
	
		<div class="col-lg-3">
			<div id="loginsessionbox" class="card" style="width: 18rem;">
			  <img src="img/strawberry.jpg" class="card-img-top" alt="loginstatus">
			  <div class="card-body">
			    <h5 class="card-title">로그인 정보</h5>
			    <%if (user != null){ %>
			    	<p class="card-text">세션시작</p>
					<p><%=user.getUserId()%>(<%=user.getName()%>)님 안녕하세요.</p>
					<a href="MyPage" class="btn btn-info">내 정보 확인</a>
				<%}else{%>
					<p>세션다운</p>
				<%}%>
			  </div>
			</div>
		</div>
		
		<div class="col-lg-9">
			<div id = "login_success_box" align="center">
				<br><br>
				<%if (user == null){ %>
					<h2 align="center">로그인 실패</h2>
					<p class="text-center">해당 회원의 정보가 없습니다. 아이디와 비밀번호를 다시 확인하세요.<p>
					<a href="login.html"><button type="button" class="btn btn-primary">로그인</button></a>
				<%}else{%>
					<div class="mx-auto" style="width: 300px;">
					<h2 align="center">로그인 성공</h2>
					<%=user.getUserId()%>(<%= user.getName()%>)님 안녕하세요.
					</div>
					<a href="book.html?id=<%=user.getUserId()%>"><button type="button" class="btn btn-primary" id="registerBook">도서등록</button></a>
					<a href="LGOUT"><button type="button" class="btn btn-primary" id="logout">로그아웃</button></a>
				<%}%>
			</div>
		</div>
		
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
$("#logout").on('click', logoutAlert);
function logoutAlert(){
	alert("로그아웃 되셨습니다.");
}
</script>
</body>
</html>