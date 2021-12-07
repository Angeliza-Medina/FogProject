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
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/customCarport.css">
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
               <h2>Carport efter egne mål - Carport med rejsning</h2>
            </div>

            <div class="flexRow">
               <section id="customCarportNav_section" class="flexColumn">
                  <div id="carportExampleImg_container">
                     <img src="<%=request.getContextPath()%>/assets/images/carport/ccpst.jpg" alt="Image of a carport with a fladt roof">
                  </div>

                  <div id="customCarportLinkBtns_container">
                     <div class="customCarportLinkBtn_container">
                        <form action = "${pageContext.request.contextPath}/fc/getAllCCPOptionsCommand">
                           <input type="hidden" name="pageToGo" value="customCarportFT">
                           <button type="submit" class="customCarport_linkBtn">Carport med fladt tag</button>
                        </form>
                     </div>

                     <div class="customCarportLinkBtn_container">
                        <form action = "${pageContext.request.contextPath}/fc/getAllCCPOptionsCommand">
                           <input type="hidden" name="pageToGo" value="customCarportST">
                           <button type="submit" id="customCarportST_linkBtn" class="customCarport_linkBtn">Carport med rejsning</button>
                        </form>
                     </div>

                     <div class="customCarportLinkBtn_container">
                        <a href="" class="customCarport_link">Standard carporte</a>
                     </div>
                  </div> <!-- #customCarportLinkBtns_container -->
               </section> <!-- .flexColumn END -->

               <section id="customCarportForm_section">
                  <p id="customCarportFormGuide">
                     Udfyld nedenstående formular med ønskede mål og tilpasninger for at sende os en forespørgsel.<br>
                  </p>

                  <div id="customcarportForm_container">
                     <form id="customCarport_form" action="${pageContext.request.contextPath}/fc/sendInquiryCommand" method="POST">
                        <div class="formTitle_container">
                           <h2 class="formTitle">
                              Carport med rejsning
                           </h2>
                        </div>

                        <label for="carportWidth" class="formLabel">Carport bredde:</label>
                        <select name="carportWidth" id="carportWidth" class="formSelect_element">
                           <option value="" disabled selected>Vælg bredde i cm</option>
                           <c:forEach items="${sessionScope.ccpOptionListContainer.ccpWidthOptions}" var="widthOption">
                              <option value="${widthOption}">${widthOption} cm</option>
                           </c:forEach>
                        </select>

                        <label for="carportLength" class="formLabel">Carport længde:</label>
                        <select name="carportLength" id="carportLength" class="formSelect_element">
                           <option value="" disabled selected>Vælg længde i cm</option>
                           <c:forEach items="${sessionScope.ccpOptionListContainer.ccpLengthOptions}" var="lengthOption">
                              <option value="${lengthOption}">${lengthOption} cm</option>
                           </c:forEach>
                        </select>

                        <label for="carportHeight" class="formLabel">Carport højde:</label>
                        <select name="carportHeight" id="carportHeight" class="formSelect_element">
                           <option value="" disabled selected>Vælg højde i cm</option>
                           <c:forEach items="${sessionScope.ccpOptionListContainer.ccpHeightOptions}" var="heightOption">
                              <option value="${heightOption}">${heightOption} cm</option>
                           </c:forEach>
                        </select>

                        <c:forEach items="${sessionScope.ccpOptionListContainer.roofTypeOptions}" var="roofTypeOption">
                           <c:if test="${roofTypeOption.type.equals('angled')}">
                              <input name="roofType" type="hidden" value="${roofTypeOption.id}">
                           </c:if>
                        </c:forEach>

                        <label for="roofMaterial" class="formLabel">Tag:</label>
                        <select name="roofMaterial" id="roofMaterial" class="formSelect_element">
                           <option value="" disabled selected>Vælg materiale og farve</option>
                           <c:forEach items="${sessionScope.ccpOptionListContainer.roofMaterialOptions}" var="roofMaterialOption">
                              <c:if test="${roofMaterialOption.roofType == 2}">
                                 <option value="${roofMaterialOption.id}">${roofMaterialOption.material}</option>
                              </c:if>
                           </c:forEach>
                        </select>

                        <label for="roofAngle" class="formLabel">Taghældning:</label>
                        <select name="roofAngle" id="roofAngle" class="formSelect_element">
                           <option value="" disabled selected>Vælg taghældning i grader</option>
                           <c:forEach items="${sessionScope.ccpOptionListContainer.roofAngleOptions}" var="roofAngleOption">
                              <c:if test="${roofAngleOption != 180}">
                                 <option value="${roofAngleOption}">${roofAngleOption} grader</option>
                              </c:if>
                           </c:forEach>
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

                        <div id="toolshedOptions_container">
                           <p id="toolshedNote">
                              NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet.
                           </p>

                           <label for="toolshedWidth" class="formLabel">Redskabsrum bredde:</label>
                           <select name="toolshedWidth" id="toolshedWidth" class="formSelect_element">
                              <option value="" disabled selected>Vælg bredde i cm</option>
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsWidthOptions}" var="cTSWidthOption">
                                 <c:if test="${cTSWidthOption == 0}">
                                    <option hidden value="${cTSWidthOption}"></option>
                                 </c:if>
                              </c:forEach>

                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsWidthOptions}" var="cTSWidthOption">
                                 <c:if test="${cTSWidthOption != 0}">
                                    <option value="${cTSWidthOption}">${cTSWidthOption} cm</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="toolshedLength" class="formLabel">Redskabsrum længde:</label>
                           <select name="toolshedLength" id="toolshedLength" class="formSelect_element">
                              <option value="" disabled selected>Vælg længde i cm</option>
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsLengthOptions}" var="cTLengthOption">
                                 <c:if test="${cTLengthOption == 0}">
                                    <option hidden value="${cTLengthOption}"></option>
                                 </c:if>
                              </c:forEach>

                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsLengthOptions}" var="cTLengthOption">
                                 <c:if test="${cTLengthOption != 0}">
                                    <option value="${cTLengthOption}">${cTLengthOption} cm</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="toolshedCladding" class="formLabel">Bræddebeklædning:</label>
                           <select name="toolshedCladding" id="toolshedCladding" class="formSelect_element">
                              <option value="" disabled selected>Vælg bræddebeklædning</option>
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsCladdingOptions}" var="claddingOption">
                                 <option value="${claddingOption.id}">${claddingOption.cladding}</option>
                              </c:forEach>
                           </select>
                        </div> <!-- #toolshedOptions_container END -->

                        <div class="formTitle_container">
                           <h2 class="formTitle">
                              Kontakt oplysninger
                           </h2>
                        </div>

                        <c:if test="${sessionScope.user != null}">
                           <input name="userId" type="hidden" value="${sessionScope.user.id}">
                        </c:if>

                        <c:if test="${sessionScope.user == null}">
                           <input name="userId" type="hidden" value="0">
                        </c:if>

                        <label for="firstName" class="formLabel">Fornavn:</label>
                        <input name="firstName" type="text" id="firstName" class="contactInput"
                           <c:if test="${sessionScope.user != null}">
                               value="${sessionScope.user.firstName}"
                           </c:if>
                        >

                        <label for="lastName" class="formLabel">Efternavn:</label>
                        <input name="lastName" type="text" id="lastName" class="contactInput"
                           <c:if test="${sessionScope.user != null}">
                                  value="${sessionScope.user.lastName}"
                           </c:if>
                        >

                        <label for="address" class="formLabel">Addresse:</label>
                        <input name="address" type="text" id="address" class="contactInput">

                        <div id="postalTown_container" class="flexRow">
                           <div id="postalCode_container">
                              <label for="postalCode" class="formLabel">Postnr:</label>
                              <input name="postalCode" type="text" id="postalCode" class="contactInput">
                           </div>

                           <div id="town_container">
                              <label for="city" class="formLabel">By:</label>
                              <input name="city" type="text" id="city" class="contactInput">
                           </div>
                        </div> <!-- #postalTown_container .flexRow END -->

                        <label for="email" class="formLabel">E-mail:</label>
                        <input name="email" type="text" id="email" class="contactInput"
                           <c:if test="${sessionScope.user != null}">
                               value="${sessionScope.user.email}"
                           </c:if>
                        >

                        <label for="phoneNum" class="formLabel">Telefon:</label>
                        <input name="phoneNum" type="text" id="phoneNum" class="contactInput">

                        <label for="note" class="formLabel">Evt. bemærkninger:</label>
                        <textarea name="note" type="text" id="note" class="contactInput"></textarea>

                        <input name="pageToGoTo" type="hidden" value="customCarportST">

                        <button type="submit" id="formSubmit_btn">Send forespørgsel</button>

                        <div id="formSumbit_container">
                           <p>Hell nah</p>
                           <c:if test="${requestScope.error != null}">
                              <div>
                                    ${requestScope.error}
                              </div>
                           </c:if>
                        </div>


                     </form>
                  </div> <!-- #customcarportForm_container END -->
               </section> <!-- #customCarportForm_container END -->
            </div> <!-- .flexRow -->
         </main>

         <!-- footer include -->
         <%@include file="includes/footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="<%=request.getContextPath()%>/assets/js/header.js"></script>
      <script src="<%=request.getContextPath()%>/assets/js/customCarport.js"></script>
   </body>
</html>