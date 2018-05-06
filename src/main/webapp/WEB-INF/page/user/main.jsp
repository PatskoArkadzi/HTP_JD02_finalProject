<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/begin-html.jsp"%>


	<div class="row">
		<img src="${film.posterUrl}" />
		<div class="container">
			${film.filmName} <br> ${film.description}
		</div>
	</div>


<%@ include file="../include/end-html.jsp"%>