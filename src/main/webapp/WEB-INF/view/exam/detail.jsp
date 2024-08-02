<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<header>
			<h1>${exam.name}성적표입니다</h1>
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
		    	<th><a href="detail">${exam.name}</a></th>
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
</body>
</html>