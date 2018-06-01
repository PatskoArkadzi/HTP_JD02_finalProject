<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../include/begin-html.jsp"%>
<%@ page
	import="
	by.htp.cinema.dao.impl.SeatDaoHibernateImpl,
	by.htp.cinema.domain.Seat
	"%>
<!-- CRUD roles -->
<div class="container">
	<button class="btn btn-success btn-lg" type="button"
		data-toggle="collapse" data-target="#collapseExample"
		aria-expanded="false" aria-controls="collapseExample">Create
		role</button>
	<div class="collapse" id="collapseExample">
		<div class="card card-body">
			<div class="container"></div>
			<form:form commandName="crud_seat" action="create?seat_id=0"
				method="post">
				<div class="row">
					<div class=col-md-2>row :</div>
					<div class=col-md-2>number :</div>
				</div>
				<div class="row">
					<form:input class="col-md-2" placeholder="row" path="row"
						required="true" />
					<form:input class="col-md-2" placeholder="number" path="number"
						required="true" />
					<button class="btn btn-success">ok</button>
				</div>
			</form:form>
		</div>
	</div>
</div>
<hr>
<div class="container">
	<p>Введите id для поиска</p>
	<div class="row">
		<form:form commandName="crud_seat" action="read" method="get">
			<fieldset>
				<form:input class="form-control input-md" path="id" />
			</fieldset>
		</form:form>
		<button class="btn btn-success" onclick="read()">search</button>
	</div>
	<p>Результат поиска:</p>
	<div id="found_seat"></div>
</div>
<script type="text/javascript">
	function read() {
		$.ajax({
			url : 'read',
			data : ({
				id : $('#id').val()
			}),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(data) {
				$('#found_seat').html(data.foundSeat);
			}
		})
	}
</script>
<hr>
<div class="container" align="center">
	<c:forEach begin="0" end="20" step="1" varStatus="row">
		<c:forEach begin="0" end="25" step="1" varStatus="column">
			<c:set var="loopRow">${row.index}</c:set>
			<c:set var="loopColumn">${column.index}</c:set>
			<%
				Seat seat = new SeatDaoHibernateImpl().read(
								Integer.valueOf("" + pageContext.findAttribute("loopRow")),
								Integer.valueOf("" + pageContext.findAttribute("loopColumn")));
						pageContext.setAttribute("chosen_seat", seat);
			%>
			<c:choose>
				<c:when test="${chosen_seat!=null}">

					<form:form commandName="crud_seat" method="post"
						style="display:inline;">
						<%-- <form:form method="post" commandName="crud_seat"
						style="display:inline;"> 
						<form:hidden path="id" value="${chosen_seat.id}" />
						<form:hidden path="row" value="${chosen_seat.row}" />
						<form:hidden path="number" value="${chosen_seat.number}" />--%>
						<!-- Button trigger modal -->
						<button class="btn" type=button
							title="row:${chosen_seat.row}
number:${chosen_seat.number}"
							style="background-color: grey;" data-toggle="modal"
							data-target="#UpdateDeleteModal${chosen_seat.id}"></button>

						<!-- Modal -->
						<div class="modal fade bd-example-modal-sm"
							id="UpdateDeleteModal${chosen_seat.id}" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog modal-sm" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">update or
											delete button</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<div class="row col-md-12 ml-auto">
											<div class="col-md-3">id</div>
											<div class="col-md-3">row</div>
											<div class="col-md-4">number</div>
										</div>
										<div class="row col-md-12 ml-auto">
											<form:input class="col-md-3" placeholder="id" path="id"
												required="true" value="${chosen_seat.id}" readonly="true" />
											<form:input class="col-md-3" placeholder="row" path="row"
												required="true" value="${chosen_seat.row}" />
											<form:input class="col-md-4" placeholder="number"
												path="number" required="true" value="${chosen_seat.number}" />
										</div>
										<br>
										<div class="modal-footer">
											<form:button formaction="update" type="submit"
												class="btn btn-success">update</form:button>
											<form:button formaction="delete" type="submit"
												class="btn btn-danger">delete</form:button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form:form>
					<%-- </form:form> --%>
				</c:when>
				<c:otherwise>
					<button class="btn btn-light" disabled="disabled"></button>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<br>
	</c:forEach>
</div>

<%@ include file="../include/end-html.jsp"%>