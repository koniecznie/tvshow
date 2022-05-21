<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:errors path="*"/>

Director: <br/>
<form:input path="director"/>
<form:errors path="director"/>
<br>
Title: <br/>
<form:input path="title"/>
<form:errors path="title"/>
<br/>
Rating: <br/>
<form:input path="rating"/><br/>
<form:errors path="rating"/>

description: <br/>
<form:input path="description"/><br/>
<form:errors path="description"/><br/>