<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:errors path="*"/>
<br/>
Imie: <br/>
<form:input path="firstName"/>
<form:errors path="firstName"/>
<br/>
Nazwisko: <br/>
<form:input path="lastName"/><br/>
<form:errors path="lastName"/>
