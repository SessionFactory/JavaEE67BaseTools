<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/include_bootstrap.jsp"></jsp:include>
    <script type="text/javascript" src="<c:url value="/jsLib/bootstrap/select/bootstrap-select.js"/> "></script>
    <link rel="stylesheet" href="<c:url value="/jsLib/bootstrap/select/bootstrap-select.css"/> ">
</head>

<script type="text/javascript">
    $('.selectpicker').selectpicker
    (
            {
                style: 'btn-info',
                size: 4
            }
    );
</script>

<body>
<select class="selectpicker">
    <option>Mustard</option>
    <option>Ketchup</option>
    <option>Relish</option>
</select>
</body>
</html>
