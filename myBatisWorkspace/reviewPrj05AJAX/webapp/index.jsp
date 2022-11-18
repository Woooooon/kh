<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
   <h1>인덱스</h1>
   
   <div id="div-result"></div>
   
   <a href="/app05/test">클릭</a>
   
   <hr>
   
   <form action="/app05/test" method="get">
      <input type="submit">
   </form>
   
   <hr>
   
   <button onclick="f01();">버튼</button>
   
   <hr>
   
   <button onclick="f02();">AJAX 버튼</button>
</body>
</html>

<script>
   function f01(){
      location.href = '/app05/test'
   }
   
   //ajax로 요청을 보내는 함수 만들기
   //url에 접근, 성공하면 동작할 함수(맨 위에 div에 출력하기)
   //function() 안에 파라미터값을 선언하면, 서블릿에서 out.write값을 가져옴
   
   function f02(str){
      $.ajax({
         url : "/app05/test" ,
         /* type : "get" , 이렇게도 가능*/
         method : "get" ,
         data : {
        	 age: 20,
        	 nick : "1dragon"
         },
         success : function(str){
            const resultDiv = document.querySelector('#div-result');
            resultDiv.innerText = str;
         } 
      });
   }
   
</script>