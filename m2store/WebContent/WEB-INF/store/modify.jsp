<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">수정</h1>
   
 <form class="form-horizontal" action="/store/modify" method="post" >
 <input type="hidden" name="sno" value="${store.sno }">
   <div class="form-group">
    <label class="control-label col-sm-2" for="sno">SNO</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="sno" value='${store.sno}' readonly="readonly">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="name">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name"  value='${store.name}'>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="lat">LAT</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="lat"value='${store.lat}'>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="lng">LNG</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="lng" value='${store.lng}' >
    </div>
  </div>      
  <div class="form-group">
    <label class="control-label col-sm-2" for="menu">MENU</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="menu" value='${store.menu}' >
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">수정완료</button>
    </div>
  </div>
  </form>
  <form action = "/store/remove" method = 'post'>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     <input type="hidden" name="sno" value="${store.sno }">
      <button type="submit" class="btn btn-danger">삭제하기</button>
    </div>
  </div>
</form>
