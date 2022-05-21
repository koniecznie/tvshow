<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="director">
    <jsp:include page="form.jsp"/>
    Imie: <br/>
    <form:input path="firstName"/>
    <form:errors path="firstName"/>
    <br/>
    Nazwisko: <br/>
    <form:input path="lastName"/><br/>
    <form:errors path="lastName"/>

    <input type="submit">
</form:form>

</body>
</html>