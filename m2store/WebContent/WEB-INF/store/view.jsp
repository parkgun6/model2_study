<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">조회 페이지</h1>
<form action="/store/list">
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">목록</button>
		</div>
	</div>
</form>
<form class="form-horizontal" action="/store/modify" method="get">
	<div class="form-group">
		<label class="control-label col-sm-2" for="sno">SNO</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="sno"
				value='${store.sno}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="name">Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="name"
				value='${store.name}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="lat">LAT</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="lat"
				value='${store.lat}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="lng">LNG</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="lng"
				value='${store.lng}' readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="menu">MENU</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" name="menu"
				value='${store.menu}' readonly="readonly">
		</div>
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">수정하기</button>
		</div>
	</div>
</form>
<table class="table">
  <thead>
    <tr>
      <th scope="col">SNO</th>
      <th scope="col">MID</th>
      <th scope="col">TEXT</th>
      <th scope="col">SCORE</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${reviews}" var="review"> 
  
    <tr>
      <td>${review.sno}</td>
      <td>${review.mid}</td>
      <td>${review.text}</td>
      <td>${review.score}</td>
      <td>${review.regdate}</td>
      <td>${review.updateDate}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<%@include file="../includes/footer.jsp"%>
