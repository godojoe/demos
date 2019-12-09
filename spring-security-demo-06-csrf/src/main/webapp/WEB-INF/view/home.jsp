<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page - Yoohoo!! - Silly goose! - NO SOUP!</h2>
	<hr>
	Welcome to the luv2code company Home Page!
</body>

<form:form action="${pageContext.request.contextPath}/logout"
		   method="POST">
	<input type="submit" value="Logout" />	   
		   
</form:form>

</html>