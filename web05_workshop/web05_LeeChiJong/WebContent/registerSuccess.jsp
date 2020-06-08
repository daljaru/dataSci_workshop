<%@page import="content.vo.User"%>
<%@page import="content.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%Book book = (Book)request.getAttribute("book");
String[] bookInfo = book.toString().split(" ");
User user = (User)request.getSession().getAttribute("user");
String userId = user.getUserId();
String name = user.getName();
%>
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
	#register_box{
		width: 600px;
		height: 200px;
		border: 1px solid black;
		margin-top : 250px;
		align-content: center;
	}
	#loginsessionbox{
		top: 100px;
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
			    <p class="card-text">세션이 유지되고 있습니다.</p>
			    <p><%=userId%>(<%=name%>)님 안녕하세요.</p>
			    <a href="MyPage" class="btn btn-info">내 정보 확인</a>
			  </div>
			</div>
		</div>
		<div class="col-lg-9">
			<div id = "register_box" align="center">
				<h4 align="center">등록 정보입니다.</h4>
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">ISBN</th>
				      <th scope="col">제목</th>
				      <th scope="col">분야</th>
				      <th scope="col">출판사</th>
				      <th scope="col">저자</th>
				      <th scope="col">가격</th>
				      <th scope="col">단위</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">1</th>
				      <td><%=bookInfo[0]%></td>
				      <td><%=bookInfo[1]%></td>
				      <td><%=bookInfo[2]%></td>
				      <td><%=bookInfo[5]%></td>
				      <td><%=bookInfo[6]%></td>
				      <td><%=bookInfo[7]%></td>
				      <td><%=bookInfo[8]%></td>
				    </tr>
				  </tbody>
				</table>
				<br>
				<br>
				<ul class="nav justify-content-center">
				  	<li class="nav-item">
				    	<a class="nav-link active" href="book.html">추가 등록</a>
				  	</li>
				  	<li class="nav-item">
				    	<a class="nav-link" href="login.html">도서 목록</a>
				  	</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script></script>
</body>
</html>