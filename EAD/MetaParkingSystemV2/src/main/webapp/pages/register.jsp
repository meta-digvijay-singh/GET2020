<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../includes/header.jsp"%>

<div class="container form-container">
	<form:form modelAttribute="employee" action="/registerEmployee">
		<div class="form-group">
			<form:label path="fullName"></form:label>
			<form:input path="fullName" type="text" placeholder="Full Name"
				class="form-control" />
			<form:errors path="fullName"></form:errors>
		</div>

		<div class="custom-control custom-radio">
			<form:radiobutton path="gender" id="male" value="male" />
			<form:label path="gender">Male</form:label>
		</div>
		<div class="custom-control custom-radio">
			<form:radiobutton path="gender" id="female" value="female" />
			<form:label path="gender">Female</form:label>
		</div>
		<div class="form-group">
			<form:label path="emailId"></form:label>
			<form:input path="emailId" type="email" placeholder="Email Id"
				class="form-control" />
			<form:errors path="emailId"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="password"></form:label>
			<form:input path="password" type="password" placeholder="Password"
				class="form-control" />
			<form:errors path="password"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="confirmPassword"></form:label>
			<form:input path="confirmPassword" type="password"
				placeholder="Confirm Password" class="form-control" />
			<form:errors path="confirmPassword"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="contactNumber"></form:label>
			<form:input path="contactNumber" type="text"
				placeholder="Mobile Number" class="form-control" />
			<form:errors path="contactNumber"></form:errors>
		</div>
		<div class="form-group">
			<form:select class="custom-select" path="orgName">
				<form:option value="M1">M1</form:option>
				<form:option value="M2">M2</form:option>
				<form:option value="M3">M3</form:option>
			</form:select>
			<form:errors path="orgName"></form:errors>
		</div>
		<form:button type="submit" class="btn btn-primary">Register</form:button>
	</form:form>
</div>

<%@ include file="../includes/footer.jsp"%>
