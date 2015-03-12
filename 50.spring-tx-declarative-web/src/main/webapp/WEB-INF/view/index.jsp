<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="ko">
	<head>
		<meta charset="utf-8">
		<title>Board</title>
		<link rel="stylesheet" href="/resources/style.css" >
	</head> 
	<body>
		<div class="tbl_type">게시판</div>
		<div>
			
<!-- UI Object -->
<table cellspacing="0" border="1" summary="작성글 목록" class="tbl_type">
	<caption>작성글 목록</caption>
	<colgroup>
		<col width="10%"><col width="15%"><col><col width="10%"><col width="10%">
	</colgroup>
	<thead>
		<tr>
		<th scope="col" abbr="순번">순번</th>
		<th scope="col" abbr="제목">제목</th>
		<th scope="col" abbr="제목">내용</th>
		<th scope="col">등록자</th>
		<th scope="col">등록일</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="item">
		<tr>
		<td scope="row" class="ranking">${item.seq}</td>
		<td>${item.title}</td>
		<td>${item.content}</td>
		<td>${item.user_id}</td>
		<td><fmt:formatDate value="${item.reg_dt}" pattern="yyyy-MM-dd" /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<!-- //UI Object -->

		</div>
		<div>
			<span>등록하기</span>
			<form name="writeForm" action="/write.html" method="post">
				<label>제목 : </label><input name="title" /><br/>
				<label>내용 : </label><textarea name="content" rows="10" cols="30"></textarea>
				<button>등록</button>
			</form>
		</div>
	</body>
	
</html>
