<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../include/begin-html.jsp"%>


<form:form method="post" action="register">
	<fieldset>
		<div class="form-group">
			<form:label class="col-md-2" path="login">login</form:label>
			<form:input placeholder="login" path="login" onkeyup="checkLogin()"
				required="true" />
		</div>
		<div class="form-group">
			<form:label class="col-md-2" path="email">email</form:label>
			<form:input placeholder="email" path="email" onblur="checkEmail()"
				required="true" />
		</div>
		<div class="form-group">
			<form:label class="col-md-2" path="password">password</form:label>
			<form:password placeholder="password" path="password"
				onkeyup="checkPassword()" required="true" />
		</div>
	</fieldset>
	<div id="resultValue"></div>
	<input type="submit" value="sign up" />
</form:form>


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
	function checkEmail() {
		$.ajax({
			url : 'checkEmail',
			data : ({
				email : $('#email').val()
			}),
			success : function(data) {
				$('#resultValue').html(data);
			}
		})
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

<%@ include file="../include/end-html.jsp"%>


