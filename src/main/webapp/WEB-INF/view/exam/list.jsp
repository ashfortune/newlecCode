<%@page import="java.io.FileInputStream"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    <!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>
  <section>
  	<header>
	    <div>${page}</div>
	    <h1>성적출력</h1> 
    </header>
		<table>
		<thead>
			<tr>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
				<td>성적</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="exam" items="${list}">
			<tr>
		    	<th><a href="detail?n=${exam.name}">${exam.name}</a></th>
		       	<td>${exam.kor}</td>
		        <td>${exam.eng}</td>
		        <td>${exam.math}</td>
		        <td>${exam.total}</td>
		        <td><fmt:formatNumber pattern="0.00" value="${exam.avg}"/></td>
            	<td>${exam.grade}</td>
	       </tr>
       		</c:forEach>
       	</tbody>
     	</table>
	</section>
	  <nav id="pager">
	  	<ul>
	  		<li><a href="?p=all">전체</a></li>
	  		<li><a href="?p=1&c=red">1page</a></li>
	  		<li><a href="?p=2&c=blue">2page</a></li>
	  		<li><a href="?p=3&c=green">3page</a></li>
	  		<li><a href="?p=4&c=black">4page</a></li>
	  		<li><a href="?p=5&c=pink">5page</a></li>
	  	</ul>
	  </nav>
	<section>
		<form method="get">
		<fieldset>
			<legend>페이지 입력</legend>
			<label>page</label><input name = "p">
		</fieldset>
		<fieldset>
			<legend>색상 고르기</legend>
			<label><input name="c" type = "checkbox" value="red">빨강</label>
			<label><input name="c" type = "checkbox" value="blue">파랑</label>
			<label><input name="c" type = "checkbox" value="green">초록</label>
		</fieldset>
		<div>
			<button>전송</button>
		</div>
		</form>
	</section>
	<section>
		<form method ="post" enctype="multipart/form-data">
			<fieldset>
				<legend>파일 업로드</legend>
				<label>파일선택<input style="display:none;" name="img"multiple type="file"></label>
				<button>업로드</button>
			</fieldset>
		</form>
	</section>
	<section>
	<div>
		<img src="/javaprj/notice/upload/1721176699299.jpg">
	</div>
	<div>
		<a download href="/javaprj/notice/upload/1721176699299.jpg"><button>다운로드</button></a>
	</div>
	</section>
</body>

</html>