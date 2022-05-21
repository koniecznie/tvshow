<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>Edycja filmu</h1>
<form:form modelAttribute="movie" action="/update">
    <jsp:include page="form.jsp"/>
    <input type="submit" value="Uaktualnij">
</form:form>
</body>


</html>