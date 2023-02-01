<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 리스트</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/jstl/weather/style.css" type="text/css">
	
</head>
<body>

	<div id="wrap">
		<section class="contents d-flex">
			<nav class="main-menu">
				<div class="d-flex mt-2 justify-content-center">
					<div class="col-2">
						<img width="25" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png" >
					</div>
					<h4 class="text-white col-7">기상청</h4>
				</div>
				
				<ul class="nav flex-column">
					<li class="nav-item"><a href="/jstl/weather/list" class="nav-link text-white">날씨</a></li>
					<li class="nav-item"><a href="/jstl/weather/input" class="nav-link text-white">날씨입력</a></li>
					<li class="nav-item"><a href="#" class="nav-link text-white">테마날씨</a></li>
					<li class="nav-item"><a href="#" class="nav-link text-white">관측기후</a></li>
				</ul>
			</nav>
			<article class="main-contents">
				<h3>과거 날씨</h3>
				
				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="weather" items="${weatherHistory }" >
						<tr>
							<td><fmt:formatDate value="${weather.date }" pattern="yyyy년 M월 d일" /> </td>
							<td>
								<c:choose>
									<c:when test="${weather.weather eq '맑음' }">
										<img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg">		
									</c:when>
									<c:when test="${weather.weather eq '구름조금' }">
										<img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg">		
									</c:when>
									<c:when test="${weather.weather eq '흐림' }">
										<img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg">		
									</c:when>
									<c:when test="${weather.weather eq '비' }">
										<img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg">		
									</c:when>
									<c:otherwise>
										${weather.weather }
									</c:otherwise>
								
								</c:choose>
								
							</td>
							<td>${weather.temperatures }°C</td>
							<td>${weather.precipitation }mm</td>
							<td>${weather.microDust }</td>
							<td>${weather.windSpeed }km/h</td>
						</tr>
						</c:forEach>
						
					</tbody>
				
				</table>
			
			</article>
		</section>
		<footer class="d-flex">
			<div class="logo mt-3 ml-4">
				 <img width="120" src="https://www.weather.go.kr/w/resources/image/foot_logo.png">	
			</div>
			<div class="copyright">
				<div class="text-secondary small">
				(07062) 서울시 동작구 여의대방로16길 61  <br>
               Copyright@2020 KMA. All Rights RESERVED.</div>
			</div>
		</footer>
	</div>

</body>
</html>