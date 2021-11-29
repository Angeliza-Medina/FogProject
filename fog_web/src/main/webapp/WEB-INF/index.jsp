<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>

<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <title>Fog - Carport efter egne mål</title>

      <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/images/logo/favicon.jpg"/>

      <!-- CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/base.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/header.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/index.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/footer.css">

      <!-- Fonts -->
      <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
   </head>

   <body>
      <div id="wrapper">
         <!-- header include -->
         <%@include file="includes/header.txt"%>

         <main>
            <div class="pageTitle_container">
               <h2>Carport efter egne mål</h2>
            </div>

            <div id="customCarportDesc_container" class="flexRow">
               <div id="customCarportComponents">
                  <div id="customCarportDescTitle_container">
                     <h3>Quick-byg tilbud</h3>
                  </div>

                  <div id="customCarportDesc">
                     Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning på en
                     carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.<br>
                     Tilbud og skitsetegning fremsendes med post hurtigst muligt.<br>
                     Ved bestilling medfølger standardbyggevejledning.
                  </div>
               </div>

               <div id="customCarportImgs_container" class="flexColumn">
                  <div class="customCarportImg_container posRelative">
                     <img src="<%=request.getContextPath()%>/assets/images/carport/ccpft.jpg" alt="Image of a carport with a flat roof">
                     <a href="${pageContext.request.contextPath}/fc/customCarportFT" class="posAbsolute customCarportImg_link"></a>
                  </div>

                  <div class="customCarportImg_container posRelative">
                     <img src="<%=request.getContextPath()%>/assets/images/carport/ccpst.jpg" alt="Image of a carport with an angled roof">
                     <a href="${pageContext.request.contextPath}/fc/customCarportST" class="posAbsolute customCarportImg_link"></a>
                  </div>
               </div>
            </div> <!-- #customCarportDesc_container .flexRow -->

            <div id="customCarportLinks_container">
               <div class="customCarportLink_container">
                  <a href="${pageContext.request.contextPath}/fc/customCarportFT" class="customCarport_link">Carport med fladt tag</a>
               </div>

               <div class="customCarportLink_container">
                  <a href="${pageContext.request.contextPath}/fc/customCarportST" class="customCarport_link">Carport med rejsning</a>
               </div>
            </div>
         </main>

         <!-- footer include -->
         <%@include file="includes/footer.txt"%>
      </div> <!-- #wrapper END -->
   </body>
</html>