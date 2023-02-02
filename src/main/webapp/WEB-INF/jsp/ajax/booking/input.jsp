<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spring final input page</title>
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
	          	<div class="text-center mt-5">
	          		<h1>예약하기</h1>
	          	</div>
	          	<div class="d-flex align-items-center flex-column">
	          		<div><label>이름</label><br><input class="inputBox" type="text" id="nameInput"></div>
	          		<div><label>예약날짜</label><br><input class="inputBox" type="text" id="dateInput"></div>
	          		<div><label>숙박일수</label><br><input class="inputBox" type="text" id="dayInput"></div>
	          		<div><label>숙박인원</label><br><input class="inputBox" type="text" id="headcountInput"></div>
	          		<div><label>전화번호</label><br><input class="inputBox" type="text" id="phoneNumberInput"></div><br>
	          		<button class="btn btn-warning text-danger" id="reserveBtn">예약하기</button>
	          	</div>
	          </section>
	      
	          <footer class="small text-dark p-3">
	              <div>제주특별자치도 제주시 애월읍</div>
	              <div>사업자등록번호 : 111-22-255222 / 농어촌민박사업자지정 / 대표 : 김동욱</div>
	              <div>Copyright 2025 tongnamu All right reserved</div>
	          </footer>
        </div>
      		
        <script>
        	$(document).ready(function(){
        		$("#reserveBtn").on("click",function(){
	        		let name = $("#nameInput").val();
	        		let date = $("#dateInput").val();
	        		let day = $("#dayInput").val();
	        		let headcount = $("#headcountInput").val();
	        		let phoneNumber = $("#phoneNumberInput").val();
	        		
	        		if(name == ""){
	        			alert("이름을 입력하세요");
	        			return;
	        		}
	        		if(date == ""){
	        			alert("날짜를 입력하세요");
	        			return;
	        		}
	        		if(day == ""){
	        			alert("숙박일수를 입력하세요");
	        			return;
	        		}
	        		
	        		// day가 숫자가 아닌경우 유효성 검사
	        		// Not a Number
	        		if(isNaN(day)) {
	        			alert("숙박일수는 숫자만 입력하세요");
	        			return;
	        		}
	        		if(headcount == ""){
	        			alert("인원을 입력하세요");
	        			return;
	        		}
	        		if(isNaN(headcount)) {
	        			alert("숙박일수는 숫자만 입력하세요");
	        			return;
	        		}
	        		if(phoneNumber == ""){
	        			alert("전화번호를 입력하세요");
	        			return;
	        		}
	        		
        			
	        		$.ajax({
	        			type:"get"
	        			,url:"/ajax/booking/insert"
	        			,data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
	        			,success:function(data){
	        				if(data.result == "success"){
	        					alert("예약 성공");
	        					location.href = "/ajax/booking/list";
	        					//location.reload();
	        				} else {
	        					alert("예약 실패")
	        				}
	        			}
	        			,error:function(){
	        				alert("예약 오류")
	        			}
	        		});
        		});
        	});
        </script>
</body>
</html>