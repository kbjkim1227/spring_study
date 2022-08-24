<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
</div>
<!-- /.col-lg-12 -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/get" method="post">

					<div class="form-group">
						<label>Bno</label> <input class="form-control" name="bno"
							value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value='<c:out value="${board.title}"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name="content"
							readonly="readonly"><c:out value="${board.content}" /></textarea>
					</div>

					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${board.writer}"/>' readonly="readonly">
					</div>

					<!--<but ton data-oper="modify" class="btn btn-default">Modify</button>
          <button data-oper="list" class="btn btn-info">List</button> -->

			<%-- 		<button data-oper='modify' class="btn btn-default">Modify</button>
				       <button data-oper='list' class="btn btn-info">List</button>
				       <form id ='operForm' action="/board/modify" method="get">
				       	<input type = 'hidden' id='bno' name='bno' value ='<c:out value="${board.bno}"/>'>
				       </form> --%>
					 <button data-oper='modify' class="btn btn-default"
						onclick="location.href='/board/modify?bno=<c:out value="${board.bno }"/>'">Modify</button>
					<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
					<button data-oper='list' class="btn btn-info"
						onclick="location.href='/board/list'">List</button>
				</form> 
			</div>

			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>
<!-- /.row -->


             

<%@include file="../includes/footer.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		
		var formObj = $("form");
		
		$('button').on("click", function(e) {
			
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log('operation? : ' + operation);
			/* Remove */
			if (operation === 'remove') {// 얘도 empty()하고 bno만 보내도 될텐데...
				formObj.attr("action", "/board/remove");
				/* forwarding to List */
			} else if (operation === 'list') {
				self.location = "/board/list";
				
				return;
				
			}
			formObj.submit();
		});
	});
</script>

