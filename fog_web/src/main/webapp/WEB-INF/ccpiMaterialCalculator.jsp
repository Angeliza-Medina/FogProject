<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>

<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <title>Fog - CCPI Stykliste-beregner</title>

      <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/images/logo/favicon.jpg"/>

      <!-- CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/base.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin_header.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ccpiMaterialCalculator.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin_footer.css">

      <!-- Fonts -->
      <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
   </head>

   <body>
      <div id="wrapper">
         <%@include file="includes/admin_header.txt"%>

         <main>
            <div id="pageHeadline_container">
               <h2>Stykliste-beregner</h2>
            </div>

            <div id="ccpiMaterialCalculator_container">
               <div id="calculatorBtns_container" class="flexRow">
                  <div id="customerSectionBtn_container" class="calculatorBtn_container">
                     <button class="calculator_btn">
                        Kunde
                     </button>
                  </div>

                  <div id="carportSectionBtn_container" class="calculatorBtn_container">
                     <button class="calculator_btn">
                        Carport
                     </button>
                  </div>

                  <div id="roofSectionBtn_container" class="calculatorBtn_container">
                     <button class="calculator_btn">
                        Tag
                     </button>
                  </div>

                  <div id="toolshedSectionBtn_container" class="calculatorBtn_container">
                     <button class="calculator_btn">
                        Redskabsrum
                     </button>
                  </div>

                  <div id="calculatorSectionBtn_container" class="calculatorBtn_container">
                     <button class="calculator_btn">
                        Beregner
                     </button>
                  </div>

                  <div id="sketchSectionBtn_container" class="calculatorBtn_container">
                     <button class="calculator_btn">
                        Plantegning
                     </button>
                  </div>

                  <div id="descSectionBtn_container" class="calculatorBtn_container">
                     <button class="calculator_btn">
                        Beskrivelse
                     </button>
                  </div>
               </div> <!-- #calculatorSectionBtns_container .flexRow END -->

               <form id="calculator_form" class="posRelative">
                  <div id="customerCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Kunde</h2>
                     </div>

                     <div id="customerCardContent_container" class="flexRow">
                        <div id="customerIcon_container">
                           <i id="customerIcon" class="far fa-user"></i>
                        </div>

                        <div id="contactInfo_container">
                           <h3 class="customerCardH3">Kontakoplysninger</h3>

                           <p class="customerCardP">
                              Fornavn: Jane<br>
                              Efternavn: Doe<br>
                              E-mail: customer@gmail.com<br>
                              Telefon: 12345678<br>
                              Addresse: Somewhere 1 1. tv., 1111 København<br>
                           </p>
                        </div>

                        <div>
                           <h3 class="customerCardH3">Kunde note</h3>

                           <p class="customerCardP">
                              Ønsker EKSTA let forståelig bygge guide!
                           </p>
                        </div>
                     </div>
                  </div> <!-- # .claculatorCard END -->

                  <div id="carportCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Carport</h2>
                     </div>
                  </div> <!-- # .claculatorCard END -->

                  <div id="roofCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Tag</h2>
                     </div>
                  </div> <!-- #roofCard .claculatorCard END -->

                  <div id="toolshedCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Redskabsrum</h2>
                     </div>
                  </div> <!-- #toolshedCard .claculatorCard END -->

                  <div id="calculatorCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Beregner</h2>
                     </div>
                  </div> <!-- #calculatorCard .claculatorCard END -->

                  <div id="sketchCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Plantegning</h2>
                     </div>
                  </div> <!-- #calculatorCard .claculatorCard END -->

                  <div id="descCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Beskrivelse</h2>
                     </div>
                  </div> <!-- #calculatorCard .claculatorCard END -->
               </form>
            </div> <!-- #ccpiMaterialCalculator_container END -->
         </main>

         <%@include file="includes/admin_footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="<%=request.getContextPath()%>/assets/js/ccpiMaterialCalculator.js"></script>
   </body>
</html>
