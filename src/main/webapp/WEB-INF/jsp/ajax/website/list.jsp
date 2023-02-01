<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h3>즐겨찾기 목록</h3>
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="website" items="${webSiteList }" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${website.name }</td>
						<td>${website.url }</td>
						<td><button type="button" data-website-id="${website.id}" class="btn btn-sm btn-danger delete-Btn">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
	
		</table>
	</div>
	
	<script>
		$(document).ready(function(){
			$(".delete-Btn").on("click", function(){
				// 삭제 api 호출
				// 삭제 대상이 되는 행의 버튼 태그 객체
				let id = $(this).data("website-id")
				
				$.ajax({
					type:"get"
					, url:"/ajax/website/delete"
					, data:{"id":id}
					, success:function(data){
						// {"result":"success"}
						// {"result":"fail"}
						if(data.result == "success"){
							// 새로고침
							location.reload();
						} else{
							alert("삭제 실패");
						}
						
					}
					, error:function(){
						alert("삭제 에러");
					}
				});
			});
		});
	
	</script>



</body>
</html>