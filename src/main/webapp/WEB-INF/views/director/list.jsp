<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
</head>
<body>
<%--<a class="btn btn-primary" href="/movie/form">Dodaj film</a>--%>
<table class="table">
    <tr>
        <th>Tytuł</th>
        <th>rating</th>

    </tr>

    <c:forEach items="${directors}" var="director">
        <tr>
            <td>${director.firstName}</td>
            <td>${director.lastName}</td>

            <td>
<%--                <a class="confirmDelete" href="/movie/delete/${pl.coderslab.movie.id}">usuń</a>--%>
<%--                <a href="/movie/edit/${pl.coderslab.movie.id}">edytuj</a>--%>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script type="text/javascript">
    $(document).ready(function (){
        $(".confirmDelete").click(function (e){
            e.preventDefault();
            let isExecuted = confirm("Are you sure to execute this action?");
            if(isExecuted){
                window.location.href = $(this).attr("href");
            }
        });
    });
</script>
</html>