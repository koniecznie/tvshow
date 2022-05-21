<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="movie">
    <jsp:include page="form.jsp"/>
    <input type="submit">
</form:form>
</body>
</html>