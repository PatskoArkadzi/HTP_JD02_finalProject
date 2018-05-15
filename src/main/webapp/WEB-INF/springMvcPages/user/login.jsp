<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../include/begin-html.jsp"%>

<form:form class="form-horizontal" method="post"
	commandName="current_user" action="check_User">
	<fieldset>
		<!-- login input-->
		<div class="form-group">
			<form:label path="login">login</form:label>
			<div class="col-md-4">
				<form:input placeholder="login" path="login" required="true"
					value="user1" />
			</div>
		</div>
		<!-- Password input-->
		<div class="form-group">
			<form:label path="password">password</form:label>
			<div class="col-md-4">
				<form:password placeholder="password" path="password"
					required="true" value="qwerty" />
			</div>
		</div>
	</fieldset>
	<div class="form-group">
		<label class="col-md-4 control-label" for="singlebutton"></label>
		<div class="col-md-4">
			<button id="singlebutton" name="singlebutton" class="btn btn-primary">login</button>
		</div>
	</div>
</form:form>

<%@ include file="../include/end-html.jsp"%>