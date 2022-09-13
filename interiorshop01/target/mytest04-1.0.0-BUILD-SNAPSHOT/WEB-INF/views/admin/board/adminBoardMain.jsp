<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<script>
	
</script>
</head>
<body>
	<H3>공지사항</H3>
	<form method="post">

		<DIV class="clear"></DIV>
	</form>
	<DIV class="clear"></DIV>
	<TABLE class="list_view">
		<c:choose>
			<c:when test="${empty listBoard }">
				<TR>
					<TD colspan=8 class="fixed"><strong>공지 사항이 없습니다.</strong></TD>
				</TR>
			</c:when>
			<c:otherwise>
				<c:forEach var="board" items="${listBoard }">
					<TR>

						<TD><strong>${board.boardNO }. </strong></TD>
						
						
						<TD><strong><a
								href="${contextPath}/admin/board/boardDetail.do?boardNO=${board.boardNO}">${board.title }</a></strong>
						</TD>


						<TD><strong>${board.content }</strong></TD>


						<td><strong>${board.writeDate }</strong></td>
						
						
						<%-- <td><c:set var="pub_date"
								value="${item.goods_published_date}" /> <c:set var="arr"
								value="${fn:split(pub_date,' ')}" /> <strong> <c:out
									value="${arr[0]}" />
						</strong></td> --%>

					</TR>
				</c:forEach>
			</c:otherwise>
		</c:choose>


	</TABLE>
	<c:choose>
		<c:when test="${memberInfo.member_id == 'admin' }">
			<a href="${contextPath}/admin/board/addBoardForm.do"
				class="no-underline"><br>[추가하기]</a>

		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>


</body>
</html>
