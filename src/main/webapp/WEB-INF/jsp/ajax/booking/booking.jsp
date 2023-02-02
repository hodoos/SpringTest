<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Spring final</title>

        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
        
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" 
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" 
        crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        
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
            
            <section class="h-100">
                <div class="col-6 p-0" id="changeimage1"><img src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg" alt=""></div>
                <div class="subimage" id="changeimage2"><img src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner2.jpg"></div>
                <div class="subimage" id="changeimage3"><img src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner3.jpg"></div>
                <div class="subimage" id="changeimage4"><img src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner4.jpg"></div>
                
                
                
                
                
                <div class="bottom-contents d-flex justify-content-center">
                    <div class="bottom-left col-4 p-5 h-100">
                        <div><h1>실시간<br>예약 하기</h1></div>
                        
                    </div>
                    
                    <div class="bottom-center col-5 p-5">
                        <div>
                            <span class="reserveText font-weight-bold">예약 확인</span>
                        </div>
                        <div id="forMembers">
                            <div><label class="mr-3 ml-3">이름 :</label><input type="text" class="w-75" id="nameInput"> <br></div>
                            <div><label class="mr-3">전화번호 :</label><input type="text" class="w-75" id="phoneNumberInput"> <br></div>
                        </div>
                        <button id="inquireBtn" class="btn bg-success float-right mr-3 mt-2">조회하기</button>
                    </div>

                    <div class="bottom-right col-3 p-5 h-100">
                        <div>
                            <div><h2>예약 문의</h2></div>
                            <div><h2>010-</h2></div>
                            <div><h2>000-1111</h2></div>
                        </div>
                    </div>  
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
               $("#inquireBtn").on("click",function(){
            	   let name = $("#nameInput").val();
            	   let phoneNumber = $("#phoneNumberInput").val();
            	   
            	   $.ajax({
            		   type:"get"
            		   , url:"/ajax/booking/find"
            		   , data:{"name":name, "phoneNumber":phoneNumber}
            		   , success:function(data){
            			   
            			   if(data.result == "fail") {
            				   alert("조회대상이 없습니다.");
            			   } else{
	           				   alert("이름 : " + data.booking.name  +
	           						   "\n날짜 : " + data.booking.date.substring(0, 10) +
	           						   "\n일수 : " + data.booking.day +
	           						   "\n인원 : " + data.booking.headcount +
	           						   "\n상태 : " + data.booking.state);
            			   }
            		   }
            		   , error:function(){
            			   alert("조회 오류");
            		   }
            	   });
               });
            });

        </script>
    </body>
</html>