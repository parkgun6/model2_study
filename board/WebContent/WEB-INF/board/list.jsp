<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">Board List Page</h1>

<table class="table">
	<thead>
		<tr>
			<th scope="col">BNO</th>
			<th scope="col">TITLE</th>
			<th scope="col">Writer</th>
			<th scope="col">REGDATE</th>
			<th scope="col">UPDATE DATE</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="board">
			<tr>
				<td>${board.bno}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>${board.updateDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form action="/board/list" method="get">
	
	<SELECT  NAME=sltSample SIZE=1>
        <OPTION type="${pageMaker.pageInfo.perSheet}" VALUE=10 SELECTED>10</OPTION>
        <OPTION type="${pageMaker.pageInfo.perSheet}" VALUE=20>20</OPTION>
        <OPTION type="${pageMaker.pageInfo.perSheet}" VALUE=30>30</OPTION>
        <OPTION type="${pageMaker.pageInfo.perSheet}" VALUE=40 >40</OPTION>
    
    </SELECT>
	<INPUT TYPE=SUBMIT VALUE="perSheet">

 <ul class="pagination">
    <c:if test="${pageMaker.prev }">
    <li class="page-item">
      <a class="page-link" href="/board/list?page=${pageMaker.start -1}&perSheet=${pageMaker.pageInfo.perSheet }" tabindex="-1">Previous</a>
    </li>
    </c:if>
    
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
    <li class="page-item ${num == pageMaker.pageInfo.page ? 'active' :''}"><a class="page-link" href="/board/list?page=${num}&perSheet=${pageMaker.pageInfo.perSheet }">${num}</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
    <li class="page-item">
      <a class="page-link" href="/board/list?page=${pageMaker.end  + 1}&perSheet=${pageMaker.pageInfo.perSheet }">Next</a>
    </li>
    </c:if>
  </ul>
</form>



<%@include file="../includes/footer.jsp"%>
