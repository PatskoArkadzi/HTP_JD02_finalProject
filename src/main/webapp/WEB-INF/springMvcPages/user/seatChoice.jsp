<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../include/begin-html.jsp"%>
<%@ page
	import="
	by.htp.cinema.dao.impl.SeatDaoHibernateImpl,
	by.htp.cinema.dao.impl.TicketsOrderDaoHibernateImpl,
	by.htp.cinema.domain.Seat,
	by.htp.cinema.domain.FilmSession,
	by.htp.cinema.domain.TicketsOrder,
	by.htp.cinema.domain.Seat.State
	"%>

<p>Выберите место:</p>
<div class="container" align="center">
	<c:forEach begin="0" end="30" step="1" varStatus="row">
		<c:forEach begin="0" end="25" step="1" varStatus="column">
			<c:set var="loopRow">${row.index}</c:set>
			<c:set var="loopColumn">${column.index}</c:set>
			<c:set var="filmSession">${user_chosen_filmSession}</c:set>
			<%
				Seat seat = new SeatDaoHibernateImpl().read(
								Integer.valueOf("" + pageContext.findAttribute("loopRow")),
								Integer.valueOf("" + pageContext.findAttribute("loopColumn")));
						FilmSession filmSession = (FilmSession) pageContext.findAttribute("user_chosen_filmSession");
						if (seat != null) {
							TicketsOrder ticketsOrder = new TicketsOrderDaoHibernateImpl().read(seat, filmSession);
							if (ticketsOrder == null)
								seat.setState(Seat.State.FREE);
							else if (ticketsOrder.isPaid()) {
								seat.setState(Seat.State.OCCUPIED);
							} else {
								seat.setState(Seat.State.BOOKED);
							}
						}
						pageContext.setAttribute("chosen_seat", seat);
			%>
			<c:choose>
				<c:when test="${chosen_seat!=null}">
					<form:form method="post" commandName="user_chosen_seat"
						action="toBasket?user_chosen_filmSession_id=${user_chosen_filmSession.id}"
						style="display:inline;">
						<form:hidden path="id" value="${chosen_seat.id}" />
						<form:hidden path="row" value="${chosen_seat.row}" />
						<form:hidden path="number" value="${chosen_seat.number}" />
						<button class="btn"
							title="row:${chosen_seat.row}
number:${chosen_seat.number}
price:${user_chosen_filmSession.ticketPrice}"
							style="background-color:${chosen_seat.state.buttonColor};"></button>
					</form:form>
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