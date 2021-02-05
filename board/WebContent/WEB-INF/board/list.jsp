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

<%-- <form action="/board/list" method="get">
게시글수 조정하기
	<input type="${pageMaker.pageInfo.perSheet}" name="perSheet">
	<button>enter</button> --%>
	
	
<select
	onChange="self.location='/board/list?page=1&perSheet='+this.value">
	<option value="--">----</option>
	<option value="10" ${pageMaker.pageInfo.perSheet ==10? "selected":"" }>10개씩열기</option>
	<option value="20" ${pageMaker.pageInfo.perSheet ==20? "selected":"" }>20개씩열기</option>
	<option value="30" ${pageMaker.pageInfo.perSheet ==30? "selected":"" }>30개씩열기</option>
	<option value="40" ${pageMaker.pageInfo.perSheet ==40? "selected":"" }>40개씩열기</option>
	<option value="50" ${pageMaker.pageInfo.perSheet ==50? "selected":"" }>50개씩열기</option>

</select>

<ul class="pagination">
    <c:if test="${pageMaker.prev }">
    <li class="page-item">
      <a class="page-link" href="/board/list?${pageMaker.getLink(pageMaker.start -1)}" tabindex="-1">Previous</a>
    </li>
    </c:if>
    
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">
    <li class="page-item ${num == pageMaker.pageInfo.page ? 'active' :''}"><a class="page-link" href="/board/list?${pageMaker.getLink(num)}">${num}</a></li>
    </c:forEach>
    
    <c:if test="${pageMaker.next }">
    <li class="page-item">
      <a class="page-link" href="/board/list?${pageMaker.getLink(pageMaker.end+1)}">Next</a>
    </li>
    </c:if>
  </ul>
<!-- </form> -->



<%@include file="../includes/footer.jsp"%>
