<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
                     <form action = "${pageContext.request.contextPath}/fc/getAllCCPOptionsCommand">
                        <input type="hidden" name="pageToGo" value="customCarportFT">
                        <img src="<%=request.getContextPath()%>/assets/images/carport/ccpft.jpg" alt="Image of a carport with a flat roof">
                        <button type="submit" class="posAbsolute customCarportImg_btn"></button>
                     </form>
                  </div>

                  <div class="customCarportImg_container posRelative">
                     <form action = "${pageContext.request.contextPath}/fc/getAllCCPOptionsCommand">
                        <input type="hidden" name="pageToGo" value="customCarportST">
                        <img src="<%=request.getContextPath()%>/assets/images/carport/ccpst.jpg" alt="Image of a carport with an angled roof">
                        <button type="submit" class="posAbsolute customCarportImg_btn"></button>
                     </form>
                  </div>
               </div>
            </div> <!-- #customCarportDesc_container .flexRow -->

            <div id="customCarportLinkBtns_container">
               <div class="customCarportLink_container">
                  <form action = "${pageContext.request.contextPath}/fc/getAllCCPOptionsCommand">
                     <input type="hidden" name="pageToGo" value="customCarportFT">
                     <button type="submit" class="customCarport_linkBtn">Carport med fladt tag</button>
                  </form>
               </div>

               <div class="customCarportLink_container">
                  <form action = "${pageContext.request.contextPath}/fc/getAllCCPOptionsCommand">
                     <input type="hidden" name="pageToGo" value="customCarportST">
                     <button type="submit" class="customCarport_linkBtn">Carport med rejsning</button>
                  </form>
               </div>
            </div> <!-- #customCarportLinkBtns_container END -->
         </main>

         <!-- footer include -->
         <%@include file="includes/footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="<%=request.getContextPath()%>/assets/js/header.js"></script>
   </body>
</html>