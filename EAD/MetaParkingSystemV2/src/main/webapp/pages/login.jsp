<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../includes/header.jsp"%>

<div class="container form-container">
	<form:form modelAttribute="employeeDto" action="/loginEmployee">
		<div class="form-group">
			<form:label path="emailId"></form:label>
			<form:input path="emailId" type="email" placeholder="Email Id"
				class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="password"></form:label>
			<form:input path="password" type="password" placeholder="Password"
				class="form-control" />
		</div>
		<form:button type="submit" class="btn btn-primary">Login</form:button>
	</form:form>
</div>

<%@ include file="../includes/footer.jsp"%>
