<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Fog - Error</title>

        <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/images/logo/favicon.jpg"/>
        <!-- CSS -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/base.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/header.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/errorpage.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/footer.css">
    </head>

    <body>
        <main>
            <div id="wrapper">
                <!-- header include -->
                <%@include file="includes/header.txt"%>

                    <c:if test="${requestScope.error != null}">
                        <div>
                                ${requestScope.error}
                        </div>
                    </c:if>
                    <p>Hej hej hejjejejeje</p>

                    <%@include file="includes/footer.txt"%>
            </div> <!-- #wrapper END -->
        </main>
    </body>
</html>