<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../include/begin-html.jsp"%>

<!-- CRUD Roles -->

<div class="container">
	<button class="btn btn-success btn-lg" type="button"
		data-toggle="collapse" data-target="#collapseExample"
		aria-expanded="false" aria-controls="collapseExample">Create</button>

	<div class="collapse" id="collapseExample">
		<div class="card card-body">
			<div class="container"></div>

			<form:form commandName="crud_film" action="create?film_id=0"
				method="post">
				<div class="row">
					<div class=col-md-2>FilmName :</div>
					<form:input class="col-md-9" placeholder="filmName" path="filmName"
						required="true" />
				</div>
				<div class="row">
					<div class="col-md-2">PosterUrl :</div>
					<form:input class="col-md-9" placeholder="posterUrl"
						path="posterUrl" required="true" />
				</div>
				<div class="row">
					<div class="col-md-2">Description :</div>
					<form:textarea class="col-md-8" placeholder="description"
						path="description" required="true" cols="100" rows="7" />
					<div class="col-md-2 ml-auto">
						<p>Genres :</p>
						<form:select path="genres" multiple="true" size="5"
							required="true">
							<form:option disabled="true" value="Выберите жанр" />
							<form:options items="${genrelist}" itemValue="id"
								itemLabel="genreName" />
						</form:select>
					</div>
				</div>
				<button id="create" value="create" name="crud_command"
					class="btn btn-success">ok</button>
			</form:form>
		</div>
	</div>
</div>
<hr>
<div class="container">
	<p>Введите id для поиска</p>
	<div class="row">
		<form:form commandName="crud_film" action="read" method="get">
			<fieldset>
				<form:input class="form-control input-md" path="id" />
			</fieldset>
		</form:form>
		<button class="btn btn-success" onclick="read()">search</button>
	</div>
	<%-- <p>Результат поиска:</p>
	<p>${found_film}</p> --%>
	<div id="found_film"></div>
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
				$('#found_film').html(data.foundFilm);
			}
		})
	}
</script>
<hr>
<br>
<div class="container">
	<c:forEach items="${filmlist}" var="film">

		<form:form commandName="crud_film" method="post">
			<div class="row">
				<div class=col-md-2>ID :</div>
				<form:input class="form-control input-md col-md-10" path="id"
					value="${film.id}" readonly="true" />
				<%-- <div class=col-md-10>${film.id}</div> --%>
			</div>
			<div class="row">
				<div class=col-md-2>FilmName :</div>
				<form:input class="form-control input-md col-md-10"
					placeholder="filmName" path="filmName" required="true"
					value="${film.filmName}" />
			</div>
			<div class="row">
				<div class=col-md-2>PosterUrl :</div>
				<form:input class="form-control input-md col-md-10"
					placeholder="posterUrl" path="posterUrl" required="true"
					value="${film.posterUrl}" />
			</div>

			<div class="row">
				<div class=col-md-2>Description :</div>
				<%-- <form:textarea placeholder="description" path="description"
					required="true" cols="100" rows="7" /> --%>
				<textarea class="col-md-8" placeholder="description" required
					cols="100" rows="7">${film.description}</textarea>
				<div class=col-md-2>
					<p>Genres :</p>
					<form:select path="genres" multiple="true" size="5" required="true">
						<form:option disabled="true" value="Выберите жанр" />
						<c:forEach items="${genrelist}" var="genre">
							<option value="${genre.id}"
								${film.genres.contains(genre)?"selected":""}>
								${genre.genreName}</option>
						</c:forEach>
						<%-- <form:options  items="${genrelist}" itemValue="id"
							itemLabel="genreName"
							selected='${film.genres.contains(itemValue)?"true":"false"}' /> --%>
					</form:select>

					<%-- <select id="genre" class="form-control" name="film_genres"
						multiple="multiple" size="5" required>
						<option disabled>Выберите жанр</option>
						<c:forEach items="${genrelist}" var="genre">
							<option value="${genre.id}"
								${film.genres.contains(genre)?"selected":""}>
								${genre.genreName}</option>
						</c:forEach>
					</select> --%>
				</div>
			</div>
			<form:button formaction="update" class="btn btn-success">Обновить</form:button>
			<form:button formaction="delete" class="btn btn-danger">Удалить</form:button>
		</form:form>
		<br>
	</c:forEach>

</div>


<%@ include file="../include/end-html.jsp"%>