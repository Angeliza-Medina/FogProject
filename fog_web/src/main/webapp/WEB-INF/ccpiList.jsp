<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>

<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

      <title>Fog - CCPI Liste</title>

      <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/assets/images/logo/favicon.jpg"/>

      <!-- CSS -->
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/base.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin_header.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ccpiList.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin_footer.css">

      <!-- Fonts -->
      <script src="https://kit.fontawesome.com/ca25e16baf.js" crossorigin="anonymous"></script>
   </head>

   <body>
      <div id="wrapper">
         <%@include file="includes/admin_header.txt"%>

         <main>
            <div id="pageHeadline_container">
               <h2>Carport forespørgsler</h2>
            </div>

            <div id="search_container"> <!-- Todo: Add functionality -->
               <form action="" method="GET" id="search_form" class="flexRow">
                  <div id="searchInput_container">
                     <input name="search_input" type="text" id="search_input">
                  </div>

                  <div id="searchBtn_container">
                     <button type="submit" id="searchBtn">
                        <i class="fas fa-search"></i>
                     </button>
                  </div>

                  <div id="searchCategory_container">
                     <select name="searchCategory" id="searchCategory_select">
                        <option value="ccpiId" selected>Forespørgsels id</option>
                        <option value="date">Dato</option>
                        <option value="lastName">Efternavn</option>
                     </select>
                  </div>
               </form> <!-- #searchCCPI_form .flexRow END -->
            </div> <!-- #searchCCPI_container END -->

            <div id="filterBtns_container" class="flexRow">
               <form action="" method="GET" class="filterBtn_container">
                  <input name="filterType" type="hidden" value="all">

                  <button type="submit" id="allFilter" class="filterBtn">
                     Alle
                  </button>
               </form>

               <form action="" method="GET" class="filterBtn_container">
                  <input name="filterType" type="hidden" value="pending">

                  <button type="submit" id="pendingFilter" class="filterBtn">
                     Afventer
                     <i class="fas fa-clock filterBtn_icon"></i>
                  </button>
               </form>

               <form action="" method="GET" class="filterBtn_container">
                  <input name="filterType" type="hidden" value="inProgress">

                  <button type="submit" id="inProgressFilter" class="filterBtn">
                     Behandles
                     <i class="fas fa-hammer filterBtn_icon"></i>
                  </button>
               </form>

               <form action="" method="GET" class="filterBtn_container">
                  <input name="filterType" type="hidden" value="completed">

                  <button type="submit" id="completedFilter" class="filterBtn">
                     Afsluttet
                     <i class="far fa-check-circle filterBtn_icon"></i>
                  </button>
               </form>

               <form action="" method="GET" class="filterBtn_container">
                  <input name="filterType" type="hidden" value="cancelled">

                  <button type="submit" id="cancelledFilter" class="filterBtn">
                     Annulleret
                     <i class="far fa-times-circle filterBtn_icon"></i>
                  </button>
               </form>
            </div> <!-- #filterLinks_container .flex -->

            <div id="ccpiList_container">
               <table id="ccpi_Table">
                  <tr id="ccpiTable_head">
                     <th>Dato</th>
                     <th>Forespørgsels-id</th>
                     <th>Carport + Redskabsrum mål</th>
                     <th>Status</th>
                  </tr>

                  <tr class="ccpiTable_data posRelative">
                     <td>02-12-2021</td>
                     <td>#005</td>
                     <td>
                        Carport: 210 x 300 x 270<br>
                        Redskabsrum: 160 x 210
                     </td>
                     <td>
                        <i class="fas fa-clock ccpiList_icon"></i>

                        <form action="${pageContext.request.contextPath}/fc/ccpiMaterialCalculator" method="GET">
                           <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                           <button class="calculateCCPIBtn posAbsolute" type="submit">
                           </button>
                        </form>
                     </td>
                  </tr>

                  <tr class="ccpiTable_data posRelative">
                     <td>02-12-2021</td>
                     <td>#005</td>
                     <td>
                        Carport: 210 x 300 x 270
                     </td>
                     <td>
                        <i class="fas fa-hammer ccpiList_icon"></i>

                        <form action="${pageContext.request.contextPath}/fc/ccpiMaterialCalculator" method="GET">
                           <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                           <button class="calculateCCPIBtn posAbsolute" type="submit">
                           </button>
                        </form>
                     </td>
                  </tr>

                  <tr class="ccpiTable_data posRelative">
                     <td>02-12-2021</td>
                     <td>#005</td>
                     <td>
                        Carport: 210 x 300 x 270<br>
                        Redskabsrum: 160 x 210
                     </td>
                     <td>
                        <i class="far fa-check-circle ccpiList_icon"></i>

                        <form action="${pageContext.request.contextPath}/fc/ccpiMaterialCalculator" method="GET">
                           <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                           <button class="calculateCCPIBtn posAbsolute" type="submit">
                           </button>
                        </form>
                     </td>
                  </tr>

                  <tr class="ccpiTable_data posRelative">
                     <td>02-12-2021</td>
                     <td>#005</td>
                     <td>
                        Carport: 210 x 300 x 270
                     </td>
                     <td>
                        <i class="far fa-times-circle ccpiList_icon"></i>

                        <form action="${pageContext.request.contextPath}/fc/ccpiMaterialCalculator" method="GET">
                           <input type="hidden" value="1"> <!-- Change value to ccpi id -->

                           <button class="calculateCCPIBtn posAbsolute" type="submit">
                           </button>
                        </form>
                     </td>
                  </tr>
               </table>
            </div> <!-- #ccpiList_container END -->
         </main>

         <%@include file="includes/admin_footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="<%=request.getContextPath()%>/assets/js/ccpiList.js"></script>
   </body>
</html>
