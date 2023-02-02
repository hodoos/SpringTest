<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring final list page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/ajax/booking/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
	          <header class="page-name text-center">
	              <h1>통나무 팬션</h1>
	          </header>
	
	          <nav>
	              <ul class="main-menu nav d-flex justify-content-around">
	                  <li><a href="/ajax/booking/main">팬션소개</a></li>
	                  <li><a href="#">객실보기</a></li>
	                  <li><a href="/ajax/booking/input">예약하기</a></li>
	                  <li><a href="/ajax/booking/list">예약목록</a></li>
	              </ul>
	          </nav>
	          
	          <section>
          		<h1 class="text-center">예약 목록 보기</h1>
	          	<table class="table text-center">
	          		<thead>
	          			<tr>
	          				<th>이름</th>
	          				<th>예약날짜</th>
	          				<th>숙박일수</th>
	          				<th>숙박인원</th>
	          				<th>전화번호</th>
	          				<th>예약상태</th>
	          				<th></th>
	          			</tr>
	          		</thead>
	          		<tbody>
		          		<c:forEach var="booking" items="${bookingList }">
		          			<tr>
		          				<td>${booking.name }</td>
		          				
		          				<td>
		          					<fmt:formatDate value="${booking.date }" pattern="yyyy년 M월 d일" />
		          				</td> 
		          				
		          				<td>${booking.day }</td>
		          				<td>${booking.headcount }</td>
		          				<td>${booking.phoneNumber }</td>
		          				<td>
		          					<c:choose>
		          						<c:when test="${booking.state eq '대기중' }">
		          							<span class="text-info">${booking.state }</span>
		          						</c:when>
		          						<c:when test="${booking.state eq '확정' }">
		          							<span class="text-success">${booking.state }</span>
		          						</c:when>
		          						<c:when test="${booking.state eq '취소' }">
		          							<span class="text-warning">${booking.state }</span>
		          						</c:when>
		          						<c:otherwise>
		          							${booking.state }
		          						</c:otherwise>
		          					</c:choose>
		          				</td>
		          				<td><button type="button" data-booking-id="${booking.id }" class="btn btn-danger btn-sm delete-Btn">삭제</button></td>
		          			</tr>
		          		</c:forEach>
	          		</tbody>
	          	</table>
	          </section>	          
	          
	          <footer class="small text-dark p-3">
	              <div>제주특별자치도 제주시 애월읍</div>
	              <div>사업자등록번호 : 111-22-255222 / 농어촌민박사업자지정 / 대표 : 김동욱</div>
	              <div>Copyright 2025 tongnamu All right reserved</div>
	          </footer>
        </div>
        
        <script>
	         $(document).ready(function(){
	        	 $(".delete-Btn").on("click",function(){
	        		 
	        		 let id = $(this).data("booking-id");
	        		 
					$.ajax({
						type:"get"
						, url:"/ajax/booking/delete"
						, data:{"id":id}
						, success:function(data){
							if(data.result == "success"){
								location.reload();
							} else{
								alert("삭제 실패");
							}
						}
						, error:function(){
							alert("삭제 오류");
						}
					});
	        		 
	        		 
	        	 });
	         });
        </script>

</body>
</html>