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
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/customCarport.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/footer.css">

      <!-- Fonts -->
      <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
   </head>

   <body>
      <div id="wrapper">
         <header>
            <div id="header_container" class="flexRow">
               <div id="logo_container" class="posRelative">
                  <img src="<%=request.getContextPath()%>/assets/images/logo/logo.png" alt="Johannes Fog logo">
                  <a id="logo_link" href="${pageContext.request.contextPath}/fc/index"></a>
               </div>

               <div id="headerNav_container" class="flexColumn">
                  <div id="headerNavTop_container" class="flexRow">
                     <div id="login_container">
                        <a href="" class="header_link">
                           <i class="fas fa-user-circle"></i>
                           Log ind
                        </a>
                     </div>

                     <div id="topNav_container" class="flexRow">
                        <div class="topNavLink_container">
                           <a href="" class="header_link topNav_link">Outlet</a>
                        </div>

                        <div class="topNavLink_container">
                           <a href="" class="header_link topNav_link">Bolig & Designhus</a>
                        </div>

                        <div class="topNavLink_container">
                           <a href="" class="header_link topNav_link">Trælast & Byggecenter</a>
                        </div>

                        <div class="topNavLink_container">
                           <a href="" class="header_link topNav_link">FogPro</a>
                        </div>
                     </div>
                  </div> <!-- #headerNavTop_container .flexRow END -->

                  <div id="headerNavBtm_container" class="flexRow">
                     <section id="navBtm_section" class="flexRow">
                        <div class="btmNavLink_container">
                           <a href="" class="header_link">
                              Byggematerialer
                              <i class="fas fa-sort-down"></i>
                           </a>
                        </div>

                        <div class="btmNavLink_container">
                           <a href="" class="header_link">
                              Bolig
                              <i class="fas fa-sort-down"></i>
                           </a>
                        </div>

                        <div class="btmNavLink_container">
                           <a href="" class="header_link">
                              Have & Fritid
                              <i class="fas fa-sort-down"></i>
                           </a>
                        </div>

                        <div class="btmNavLink_container">
                           <a href="" class="header_link">
                              Værktøj
                              <i class="fas fa-sort-down"></i>
                           </a>
                        </div>

                        <div class="btmNavLink_container">
                           <a href="" class="header_link">
                              Tilbud
                              <i class="fas fa-sort-down"></i>
                           </a>
                        </div>
                     </section> <!-- #navBtm_section .flexRow END -->

                     <section id="search_section">
                        <form id="seachForm" class="flexRow" action="" method="GET">
                           <input id="seachForm_input" type="text">

                           <button type="submit">
                              <i class="fas fa-search"></i>
                           </button>
                        </form>
                     </section>

                     <section id="shoppingBasket_section">
                        <div id="shoppingBasketLink_container">
                           <a class="header_link">
                              <i class="fas fa-shopping-basket"></i>
                              Indkøbskurv (0)
                           </a>
                        </div>
                     </section>
                  </div> <!-- #headerNavBtm_container .flexRow END -->
               </div> <!-- #headerNav_container .flexColumn END -->
            </div>
         </header>

         <main>
            <div class="pageTitle_container">
               <h2>Carport efter egne mål - Carport med flat tag</h2>
            </div>

            <div class="flexRow">
               <section id="customCarportNav_section" class="flexColumn">
                  <div id="carportExampleImg_container">
                     <img src="<%=request.getContextPath()%>/assets/images/carport/ccpft.jpg" alt="Image of a carport with a fladt roof">
                  </div>

                  <div id="customCarportLinks_container">
                     <div class="customCarportLink_container">
                        <a id="customCarportFT_link" href="${pageContext.request.contextPath}/fc/customCarportFT" class="customCarport_link">Carport med fladt tag</a>
                     </div>

                     <div class="customCarportLink_container">
                        <a href="${pageContext.request.contextPath}/fc/customCarportST" class="customCarport_link">Carport med rejsning</a>
                     </div>

                     <div class="customCarportLink_container">
                        <a id="standardCarport_link" href="" class="customCarport_link">Standard carporte</a>
                     </div>
                  </div>
               </section> <!-- .flexColumn END -->

               <section id="customCarportForm_section">
                  <p id="customCarportFormGuide">
                     Udfyld nedenstående formular med ønskede mål og tilpasninger for at sende os en forespørgsel.<br>
                  </p>

                  <div id="customcarportForm_container">
                     <form id="customCarport_form" action="" method="POST">
                        <div class="formTitle_container">
                           <h2 class="formTitle">
                              Carport med fladt tag
                           </h2>
                        </div>

                        <label for="carportWidth" class="formLabel">Carport bredde:</label>
                        <select name="carportWidth" id="carportWidth" class="formSelect_element">
                           <option value="" disabled selected>Vælg bredde i cm</option>
                           <option value="270">270 cm</option>
                           <option value="300">300 cm</option>
                           <option value="330">330 cm</option>
                           <option value="360">360 cm</option>
                        </select>

                        <label for="carportLength" class="formLabel">Carport længde:</label>
                        <select name="carportLength" id="carportLength" class="formSelect_element">
                           <option value="" disabled selected>Vælg længde i cm</option>
                           <option value="270">270 cm</option>
                           <option value="300">300 cm</option>
                           <option value="330">330 cm</option>
                           <option value="360">360 cm</option>
                        </select>

                        <label for="carportHeight" class="formLabel">Carport højde:</label>
                        <select name="carportHeight" id="carportHeight" class="formSelect_element">
                           <option value="" disabled selected>Vælg højde i cm</option>
                           <option value="270">270 cm</option>
                           <option value="300">300 cm</option>
                           <option value="330">330 cm</option>
                           <option value="360">360 cm</option>
                        </select>

                        <label for="carportRoof" class="formLabel">Tag:</label>
                        <select name="carportRoof" id="carportRoof" class="formSelect_element">
                           <option value="" disabled selected>Vælg materiale og farve</option>
                           <option value="Betontagsten - Rød">Betontagsten - Rød</option>
                           <option value="Betontagsten - Teglrød">Betontagsten - Teglrød</option>
                           <option value="Betontagsten - Brun">Betontagsten - Brun</option>
                           <option value="Betontagsten - Sort">Betontagsten - Sort</option>
                           <option value="Eternittag B6- Grå">Eternittag B6- Grå</option>
                        </select>

                        <div class="formDivAsLabel">Tilføj redskabsrum:</div>

                        <div id="radioBtns_container" class="flexRow">
                           <div class="radioBtn_container flexRow">
                              <label class="formRadioLabel" for="toolshedTrue">Ja, tak</label>
                              <input name="addToolshed" value="true" type="radio" checked="checked" id="toolshedTrue" class="formRadioBtn">
                           </div>

                           <div class="radioBtn_container flexRow">
                              <label class="formRadioLabel" for="toolshedFalse">Nej, tak</label>
                              <input name="addToolshed" value="false" type="radio" id="toolshedFalse" class="formRadioBtn">
                           </div>
                        </div>

                        <p id="toolshedNote">
                           NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet.
                        </p>

                        <div id="toolshedOptions_container">
                           <label for="toolshedWidth" class="formLabel">Redskabsrum bredde:</label>
                           <select name="toolshedWidth" id="toolshedWidth" class="formSelect_element">
                              <option value="" disabled selected>Vælg bredde i cm</option>
                              <option hidden value="0"></option>
                              <option value="270">270 cm</option>
                              <option value="300">300 cm</option>
                              <option value="330">330 cm</option>
                              <option value="360">360 cm</option>
                           </select>

                           <label for="toolshedLength" class="formLabel">Redskabsrum længde:</label>
                           <select name="toolshedLength" id="toolshedLength" class="formSelect_element">
                              <option value="" disabled selected>Vælg længde i cm</option>
                              <option hidden value="0"></option>
                              <option value="270">270 cm</option>
                              <option value="300">300 cm</option>
                              <option value="330">330 cm</option>
                              <option value="360">360 cm</option>
                           </select>
                        </div> <!-- #toolshedOptions_container END -->

                        <div class="formTitle_container">
                           <h2 class="formTitle">
                              Kontakt oplysninger
                           </h2>
                        </div>

                        <label for="firstName" class="formLabel">Fornavn:</label>
                        <input name="firstName" type="text" id="firstName" class="contactInput">

                        <label for="lastName" class="formLabel">Efternavn:</label>
                        <input name="lastName" type="text" id="lastName" class="contactInput">

                        <label for="address" class="formLabel">Addresse:</label>
                        <input name="address" type="text" id="address" class="contactInput">

                        <div id="postalTown_container" class="flexRow">
                           <div id="postalCode_container">
                              <label for="postalCode" class="formLabel">Postnr:</label>
                              <input name="postalCode" type="text" id="postalCode" class="contactInput">
                           </div>

                           <div id="town_container">
                              <label for="town" class="formLabel">By:</label>
                              <input name="town" type="text" id="town" class="contactInput">
                           </div>
                        </div> <!-- #postalTown_container .flexRow END -->

                        <label for="email" class="formLabel">E-mail:</label>
                        <input name="email" type="text" id="email" class="contactInput">

                        <label for="phoneNum" class="formLabel">Telefon:</label>
                        <input name="phoneNum" type="text" id="phoneNum" class="contactInput">

                        <label for="note" class="formLabel">Evt. bemærkninger:</label>
                        <textarea name="note" type="text" id="note" class="contactInput"></textarea>

                        <button type="submit" id="formSubmit_btn">Send forespørgsel</button>
                     </form>
                  </div> <!-- #customcarportForm_container END -->
               </section> <!-- #customCarportForm_container END -->
            </div> <!-- .flexRow -->
         </main>

         <footer>
            <div id="footerContentTop_container">
               <div id="footerTopSection_container" class="flexRow">
                  <section class="footerTop_section">
                     <div class="footerTopSectionTitle_container">
                        <h2 class="footerTopSection_title">Hvordan køber jeg?</h2>
                     </div>

                     <div class="footerLink_container flexColumn">
                        <div class="footerLink_container">
                           <a href="" class="footer_link">Ofte stillede spørgsmål</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Fragt</a>
                        </div>


                        <div class="footerLink_container">
                           <a href="" class="footer_link">Fortrydelse & Returnering</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Reklamation & Klage</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">E-mærket</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Købs- og leveringsvilkår online</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Alm. salgs- og leveringsbetingelser</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Bliv kunde i Fog</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Fog konto</a>
                        </div>
                     </div> <!-- .footerLink_container .flexColumn END -->
                  </section>

                  <section class="footerTop_section">
                     <div class="footerTopSectionTitle_container">
                        <h2 class="footerTopSection_title">Aktuelt</h2>
                     </div>

                     <div class="footerLink_container flexColumn">
                        <div class="footerLink_container">
                           <a href="" class="footer_link">Tilbudsavis</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Blog</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Nej tak+</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Tilbudsmail</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Konkurrencer</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Facebook</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Instagram</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">LinkedIn</a>
                        </div>
                     </div> <!-- .footerLink_container .flexColumn END -->
                  </section>

                  <section class="footerTop_section">
                     <div class="footerTopSectionTitle_container">
                        <h2 class="footerTopSection_title">Om Fog</h2>
                     </div>

                     <div class="footerLink_container flexColumn">
                        <div class="footerLink_container">
                           <a href="" class="footer_link">Åbningstider</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Om Fog</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Fog's fond</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Job</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">CSR</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Cookie-politik</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Persondata</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Prismatch</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Spørg Fog</a>
                        </div>

                        <div class="footerLink_container">
                           <a href="" class="footer_link">Kontakt Fog</a>
                        </div>
                     </div> <!-- .footerLink_container .flexColumn END -->
                  </section>

                  <section id="footerContactInfo_section" class="footerTop_section">
                     <div class="footerTopSectionTitle_container">
                        <h2 class="footerTopSection_title">Kontakt</h2>
                     </div>

                     <section class="footerContact_container">
                        <div class="contactInfo_container flexRow">
                           <div class="contactInfoIcon_container">
                              <i class="fas fa-comment-dots"></i>
                           </div>

                           <div class="contactInfo">
                              Webshop
                           </div>
                        </div>

                        <div class="contactInfo_container flexRow">
                           <div class="contactInfoIcon_container">
                              <i class="fas fa-phone-alt"></i>
                           </div>

                           <div class="contactInfo">
                              47 16 08 00
                           </div>
                        </div>

                        <div class="contactInfo_container flexRow">
                           <div class="contactInfoIcon_container">
                              <i class="fas fa-envelope"></i>
                           </div>

                           <div class="contactInfo">
                              <a href="" class="footer_link contactInfo_link">Send e-mail</a>
                           </div>
                        </div>
                     </section>

                     <section class="footerContact_container">
                        <div class="contactInfo_container flexRow">
                           <div class="contactInfoIcon_container">
                              <i class="fas fa-comment-dots"></i>
                           </div>

                           <div class="contactInfo">
                              Johannes Fog
                           </div>
                        </div>

                        <div class="contactInfo_container flexRow">
                           <div class="contactInfoIcon_container">
                              <i class="fas fa-phone-alt"></i>
                           </div>

                           <div class="contactInfo">
                              45 87 10 01
                           </div>
                        </div>

                        <div class="contactInfo_container flexRow">
                           <div class="contactInfoIcon_container">
                              <i class="fas fa-envelope"></i>
                           </div>

                           <div class="contactInfo">
                              <a href="" class="footer_link contactInfo_link">Send e-mail</a>
                           </div>
                        </div>
                     </section>

                     <section id="paymentImg_container">
                        <img src="<%=request.getContextPath()%>/assets/images/footer/cards-logos.png" alt="Logos of all the accepted cards for online payment">
                     </section>
                  </section>
               </div> <!-- #footerTopSection_container .flexRow END -->
            </div> <!-- #footerContentTop_container .flexRow END -->

            <div id="footerContentBtm_container">
               <div id="footerBtmSection_container" class="flexRow">
                  <section id="businessInfo">
                     Johannes Fog A/S - Firskovvej 20 - 2800 Lyngby - CVR-nr. 16314439
                  </section>

                  <section id="priceInfo">
                     Alle priser er inkl. moms
                  </section>
               </div>
            </div>
         </footer>
      </div> <!-- #wrapper END -->

      <script src="<%=request.getContextPath()%>/assets/js/customCarport.js"></script>
   </body>
</html>