<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../include/begin-html.jsp"%>


<script type="text/javascript">
	function checkLogin() {
		var data = {
			login : $('#login').val()
		};
		var dataJson = JSON.stringify(data);
		console.log($);
		$.ajax({
			url : 'checkLog',
			data : ({
				jsonLogin : dataJson
			}),
			success : function(data) {
				$('#resultValue').html(data);
			}
		});
	}
	function checkPassword() {
		$.ajax({
			url : 'checkPass',
			data : ({
				password : $('#password').val()
			}),
			success : function(data) {
				$('#resultValue').html(data);
			}
		})
	}
</script>
<br>
<div id="resultValue"></div>
<form:form method="post" action="register">
	<fieldset>
		<form:label path="login">login</form:label>
		<form:input path="login" onkeyup="checkLogin()" />

		<form:label path="password">password</form:label>
		<form:password path="password" onkeyup="checkPassword()" />

	</fieldset>
	<input type="submit" value="sign up" />
</form:form>




<%@ include file="../include/end-html.jsp"%>


