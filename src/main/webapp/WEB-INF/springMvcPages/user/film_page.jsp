<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<h2>${user_chosen_film.filmName}</h2>
</div>
<div class="row">
	<div class=col-md-3>
		<img src="${user_chosen_film.posterUrl}" />
	</div>
	<div class="col-md-8 container">
		<p>
			Жанры :
			<c:forEach items="${user_chosen_film.genres}" var="genre">
								${genre.genreName}
						</c:forEach>
		</p>
		<p>
			Описание : <br> ${user_chosen_film.description}
		</p>
		<div class="container">
			<div class="row">
				<div class=col-md-4>Выберите дату и время:</div>
			</div>
			<br>
			<c:forEach items="${user_chosen_film.filmSessions}" var="session">
				<a
					href="/cinema/newapp/user/chooseSeat?user_chosen_filmSession_id=${session.id}"><button
						class="btn btn-success">${session.date} ${session.time}</button></a>
				<br>
			</c:forEach>
		</div>
	</div>
</div>

<%@ include file="../include/end-html.jsp"%>