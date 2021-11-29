<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
      <header>
         <div id="header_container" class="flexRow">
            <div id="logo_container" class="posRelative">
               <img src="assets/images/logo/logo.png" alt="Johannes Fog logo">
               <a id="logo_link" href="index.html"></a>
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
                  <img src="assets/images/carport/ccpft.jpg" alt="Image of a carport with a flat roof">
                  <a href="customCarportFT.html" class="posAbsolute customCarportImg_link"></a>
               </div>

               <div class="customCarportImg_container posRelative">
                  <img src="assets/images/carport/ccpst.jpg" alt="Image of a carport with an angled roof">
                  <a href="customCarportST.html" class="posAbsolute customCarportImg_link"></a>
               </div>
            </div>
         </div> <!-- #customCarportDesc_container .flexRow -->

         <div id="customCarportLinks_container">
            <div class="customCarportLink_container">
               <a href="customCarportFT.html" class="customCarport_link">Carport med fladt tag</a>
            </div>

            <div class="customCarportLink_container">
               <a href="customCarportST.html" class="customCarport_link">Carport med rejsning</a>
            </div>
         </div>
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
                     <img src="assets/images/footer/cards-logos.png" alt="Logos of all the accepted cards for online payment">
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

   </body>
</html>