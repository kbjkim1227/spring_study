<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
	
<nav>
<ul>
<c:choose>
<c:when test="${side_menu=='admin_mode' }">
   <li>
		<H3 style="font-size:14px; font-weight:bold;">주요기능</H3>
		<ul>
			<li><a href="${contextPath}/admin/goods/adminGoodsMain.do">상품관리</a></li>
			<li><a href="${contextPath}/admin/order/adminOrderMain.do">주문관리</a></li>
			<li><a href="${contextPath}/admin/member/adminMemberMain.do">회원관리</a></li>
			<li><a href="${contextPath}/admin/board/adminBoardMain.do">게시판관리</a></li>
		</ul>
	</li>
</c:when>
<c:when test="${side_menu=='my_page' }">
	<li>
		<h3>주문내역</h3>
		<ul>
			<li><a href="${contextPath}/mypage/listMyOrderHistory.do">주문내역/배송 조회</a></li>
			<li><a href="${contextPath}/mypage/myDetailInfo.do">회원정보관리</a></li>
		</ul>
	</li>
</c:when>
<c:otherwise>
	<li>
		<h3>카테고리</h3>
		<ul>
			<li><a href="${contextPath}/main/Home_Appliances.do">가전</a></li>
			<li><a href="${contextPath}/main/Furniture.do">가구</a></li>
			<li><a href="${contextPath}/main/Kitchen.do">주방</a></li>
			<li><a href="${contextPath}/main/Housegoods.do">생활용품</a></li>
		</ul>
	</li>
	<!-- <li>
		<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;음반</h3>
		<ul>
			<li><a href="#">가요</a></li>
			<li><a href="#">록</a></li>
			<li><a href="#">클래식</a></li>
			<li><a href="#">뉴에이지</a></li>
			<li><a href="#">재즈</a></li>
			<li><a href="#">기타</a></li>
		</ul>
	</li> -->
 </c:otherwise>
</c:choose>	
</ul>
</nav>
<div class="clear"></div>
<div id="banner">
	<a href="#"><img width="190" height="163" src="${contextPath}/resources/image/n-pay.jpg"> </a>
</div>
<DIV id="notice">
	
	<H2><a href = "${contextPath}/admin/board/adminBoardMain.do">공지사항</a></H2>
	<UL>
	
	
	
	<c:forEach  var="board" items="${listBoard }" varStatus="status">
	<c:if test="${status.count <= 5 }">
	<td>
		<a href="${contextPath}/admin/board/boardDetail.do?boardNO=${board.boardNO}">-${board.title}</a>
	</td><br>
	</c:if>
	</c:forEach>
	</ul>
</div>

<div id="banner">
	<a href="#"><img width="190" height="362" src="${contextPath}/resources/image/side_banner1.jpg"></a>
</div>
<div id="banner">
	<a href="#"><img width="190" height="104" src="${contextPath}/resources/image/call_center_logo.jpg"></a>
</div>
<div id="banner">
	<a href="${contextPath}/qna/qnaMain.do"><img width="190" height="69" src="${contextPath}/resources/image/QnA_logo.jpg"></a>
</div>
</html>