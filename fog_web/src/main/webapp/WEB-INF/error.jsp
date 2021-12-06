<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/base.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/header.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/index.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/footer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/errorpage.css">


</head>

<body>
<div id="wrapper">
    <!-- header include -->
    <%@include file="includes/header.txt"%>

    <main>
        <c:if test="${requestScope.error != null}">
            <div>
                    ${requestScope.error}
            </div>
        </c:if>
        <p>Hej hej hejjejejeje</p>
    </main>

        <%@include file="includes/footer.txt"%>


</div> <!-- #wrapper END -->

</body>
</html>