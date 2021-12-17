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

               <form action="${pageContext.request.contextPath}/fc/calcMaterialListCommand" method="GET" id="calculator_form" class="posRelative">
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
                              Fornavn: ${sessionScope.inquiryById.contactInfo.firstName}<br>
                              Efternavn: ${sessionScope.inquiryById.contactInfo.lastName}<br>
                              E-mail: ${sessionScope.inquiryById.contactInfo.email}<br>
                              Telefon: ${sessionScope.inquiryById.contactInfo.phoneNum}<br>
                              Addresse:
                              ${sessionScope.inquiryById.contactInfo.address},
                              ${sessionScope.inquiryById.contactInfo.postalCode}
                              ${sessionScope.inquiryById.contactInfo.city}
                           </p>
                        </div>

                        <div>
                           <h3 class="customerCardH3">Kunde note</h3>

                           <p class="customerCardP">
                              ${sessionScope.inquiryById.note}
                           </p>
                        </div>
                     </div> <!-- #customerCardContent_container .flexRow END -->
                  </div> <!-- #customerCard .claculatorCard END -->

                  <div id="carportCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Carport</h2>
                     </div>

                     <div id="carportCardContent_container" class="flexRow">
                        <div id="ccpDimension_container">
                           <label for="carportWidth" class="formLabel">Carport bredde:</label>
                           <select name="carportWidth" id="carportWidth" class="formSelect_element">
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ccpWidthOptions}" var="widthOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.width == widthOption}">
                                    <option selected value="${widthOption}">${widthOption} cm</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.width != widthOption}">
                                    <option value="${widthOption}">${widthOption} cm</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="carportLength" class="formLabel">Carport længde:</label>
                           <select name="carportLength" id="carportLength" class="formSelect_element">
                              <option value="" disabled selected>Vælg længde i cm</option>
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ccpLengthOptions}"  var="lengthOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.length == lengthOption}">
                                    <option selected value="${lengthOption}">${lengthOption} cm</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.length != lengthOption}">
                                    <option value="${lengthOption}">${lengthOption} cm</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="carportHeight" class="formLabel">Carport højde:</label>
                           <select name="carportHeight" id="carportHeight" class="formSelect_element">
                              <option value="" disabled selected>Vælg højde i cm</option>
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ccpHeightOptions}" var="heightOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.height == heightOption}">
                                    <option selected value="${heightOption}">${heightOption} cm</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.height != heightOption}">
                                    <option value="${heightOption}">${heightOption} cm</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label id="middlePostLabel" for="middlePost" class="formLabel">Tilføj midterstolpe:</label>
                           <c:if test="${sessionScope.inquiryById.customCarport.hasMiddlePillar == false}">
                              <input type="checkbox" id="middlePost" name="middlePost" value="addMiddlePost">
                           </c:if>

                           <c:if test="${sessionScope.inquiryById.customCarport.hasMiddlePillar == true}">
                              <input type="checkbox" id="middlePost" name="middlePost" value="addMiddlePost" checked>
                           </c:if>
                        </div> <!-- #ccpDimension_container END -->

                        <div id="ccpImg_container">
                           <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId == 1}">
                              <img src="<%=request.getContextPath()%>/assets/images/carport/ccpft.jpg" alt="Image of a carport with a flat roof">
                           </c:if>

                           <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId == 2}">
                              <img src="<%=request.getContextPath()%>/assets/images/carport/ccpst.jpg" alt="Image of a carport with an angled roof">
                           </c:if>
                        </div>
                     </div> <!-- #carportCardContent_container .flexRow -->
                  </div> <!-- #carportCard .claculatorCard END -->

                  <div id="roofCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Tag</h2>
                     </div>

                     <div id="roofCardContent_container" class="flexRow">
                        <div id="roofSettings_container">
                           <div class="radioBtns_container flexRow">
                              <div class="radioBtn_container flexRow">
                                 <label class="formRadioLabel" for="flatRoof">Fladt tag</label>
                                 <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId == 1}">
                                    <input name="roofTypeId" value="1" type="radio" checked="checked" id="flatRoof" class="formRadioBtn">
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId != 1}">
                                    <input name="roofTypeId" value="1" type="radio" id="flatRoof" class="formRadioBtn">
                                 </c:if>
                              </div>

                              <div class="radioBtn_container flexRow">
                                 <label class="formRadioLabel" for="angledRoof">Tag med rejsning</label>
                                 <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId == 2}">
                                    <input name="roofTypeId" value="2" type="radio" checked="checked" id="angledRoof" class="formRadioBtn">
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId != 2}">
                                    <input name="roofTypeId" value="2" type="radio" id="angledRoof" class="formRadioBtn">
                                 </c:if>
                              </div>
                           </div> <!-- .radioBtns_container . flexRow END -->

                           <label for="roofMaterial" class="formLabel">Tag:</label>
                           <select name="roofMaterialId" id="roofMaterial" class="formSelect_element">
                              <c:forEach items="${sessionScope.ccpOptionListContainer.roofMaterialOptions}" var="roofMaterialOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.roofMaterialId == roofMaterialOption.id}">
                                    <option selected value="${roofMaterialOption.id}">${roofMaterialOption.material}</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.roofMaterialId != roofMaterialOption.id}">
                                    <option value="${roofMaterialOption.id}">${roofMaterialOption.material}</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="roofAngle" class="formLabel">Taghældning:</label>
                           <select name="roofAngle" id="roofAngle" class="formSelect_element">
                              <option value="" disabled selected>Vælg taghældning i grader</option>
                              <c:forEach items="${sessionScope.ccpOptionListContainer.roofAngleOptions}" var="roofAngleOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.roofAngle == roofAngleOption}">
                                    <option selected value="${roofAngleOption}">${roofAngleOption} grader</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.roofAngle != roofAngleOption}">
                                    <option value="${roofAngleOption}">${roofAngleOption} grader</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="rafterSpacing" class="formLabel">Spærafstand:</label>
                           <select name="rafterSpacing" id="rafterSpacing" class="formSelect_element">
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ccpRafterSpacingOptions}" var="rafterSpacingOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.rafterSpacing == rafterSpacingOption}">
                                    <option selected value="${rafterSpacingOption}">${rafterSpacingOption} cm</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.rafterSpacing != rafterSpacingOption}">
                                    <option value="${rafterSpacingOption}">${rafterSpacingOption} cm</option>
                                 </c:if>
                              </c:forEach>
                           </select>
                        </div> <!-- #roofSettings_container END -->

                        <div>
                           <img src="<%=request.getContextPath()%>/assets/images/ccpiMaterialCalculator/roofExample.png" alt="Picture of a plastic roof">
                        </div>
                     </div> <!-- #roofCardContent_container .flexRow END -->
                  </div> <!-- #roofCard .claculatorCard END -->

                  <div id="toolshedCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Redskabsrum</h2>
                     </div>

                     <div id="toolshedCardContent_container" class="flexRow">
                        <div id="toolshedSettings_container">
                           <div class="radioBtns_container flexRow">
                              <div class="radioBtn_container flexRow">
                                 <label class="formRadioLabel" for="toolshedTrue">Redskabsrum incl.</label>
                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed != null}">
                                    <input name="hasToolshed" value="true" type="radio" checked="checked" id="toolshedTrue" class="formRadioBtn">
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed == null}">
                                    <input name="hasToolshed" value="true" type="radio" id="toolshedTrue" class="formRadioBtn">
                                 </c:if>
                              </div>

                              <div class="radioBtn_container flexRow">
                                 <label class="formRadioLabel" for="toolshedFalse">Redskabsrum excl.</label>
                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed == null}">
                                    <input name="hasToolshed" value="false" type="radio" checked="checked" id="toolshedFalse" class="formRadioBtn">
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed != null}">
                                    <input name="hasToolshed" value="false" type="radio" id="toolshedFalse" class="formRadioBtn">
                                 </c:if>
                              </div>
                           </div> <!-- .radioBtns_container . flexRow END -->

                           <label for="toolshedWidth" class="formLabel">Redskabsrum bredde:</label>
                           <select name="toolshedWidth" id="toolshedWidth" class="formSelect_element">
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsWidthOptions}" var="ctsWidthOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed.toolshedWidth == ctsWidthOption}">
                                    <option selected value="${ctsWidthOption}">${ctsWidthOption}</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed.toolshedWidth != ctsWidthOption}">
                                    <option value="${ctsWidthOption}">${ctsWidthOption}</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="toolshedLength" class="formLabel">Redskabsrum længde:</label>
                           <select name="toolshedLength" id="toolshedLength" class="formSelect_element">
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsLengthOptions}" var="ctsLengthOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed.toolshedLength == ctsLengthOption}">
                                    <option selected value="${ctsLengthOption}">${ctsLengthOption}</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed.toolshedLength != ctsLengthOption}">
                                    <option value="${ctsLengthOption}">${ctsLengthOption}</option>
                                 </c:if>
                              </c:forEach>
                           </select>

                           <label for="toolshedCladding" class="formLabel">Bræddebeklædning:</label>
                           <select name="toolshedCladdingId" id="toolshedCladding" class="formSelect_element">
                              <c:forEach items="${sessionScope.ccpOptionListContainer.ctsCladdingOptions}" var="claddingOption">
                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed.toolshedCladdingId == claddingOption.id}">
                                    <option selected value="${claddingOption.id}">${claddingOption.cladding}</option>
                                 </c:if>

                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed.toolshedCladdingId != claddingOption.id}">
                                    <option value="${claddingOption.id}">${claddingOption.cladding}</option>
                                 </c:if>
                              </c:forEach>
                           </select>
                        </div> <!-- #toolshedSettings_container END -->

                        <div>
                           <img src="<%=request.getContextPath()%>/assets/images/ccpiMaterialCalculator/toolshedExample.png" alt="Picture of a toolshed">
                        </div>
                     </div> <!-- #toolshedCardContent_container END -->
                  </div> <!-- #toolshedCard .claculatorCard END -->

                  <div id="calculatorCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Beregner</h2>
                     </div>

                     <div id="calculatorCardContent_container">
                        <c:if test="${sessionScope.materialList != null}">
                           <div id="materialList_container">
                              <!-- Only show when a material list is saved to the session -->
                              <div id="materialListTable_container">
                                 <div id="tableHeadline_container">
                                    <h3 id="tableHeadline">Stykliste</h3>
                                 </div>

                                 <table class="materialList_table">
                                    <tr class="materialListHeadRow">
                                       <th>Materiale</th>

                                       <th>Længde i cm</th>

                                       <th>Antal</th>

                                       <th>Enhed</th>

                                       <th>Beskrivelse</th>
                                    </tr>
                                 </table>

                                 <!-- Make dynamic -->
                                 <table class="materialList_table">
                                    <tr class="materialListHeadRow">
                                       <th>Træ & Tagplader</th>
                                       <th></th>
                                       <th></th>
                                       <th></th>
                                       <th></th>
                                    </tr>

                                    <c:forEach items="${sessionScope.materialList.woodPieces}" var="woodpiece">
                                       <tr>
                                          <td>
                                             ${woodpiece.productName}
                                             ${woodpiece.thickness} x
                                             ${woodpiece.width}mm
                                          </td>

                                          <td>${woodpiece.length}</td>

                                          <td>${woodpiece.amount}</td>

                                          <td>${woodpiece.unit}</td>

                                          <td>${woodpiece.desc}</td>
                                       </tr>
                                    </c:forEach>

                                    <c:if test="${sessionScope.materialList.cladding != null}">
                                       <tr>
                                          <td>
                                             ${sessionScope.materialList.cladding.productName}
                                             ${sessionScope.materialList.cladding.thickness} x
                                             ${sessionScope.materialList.cladding.width}mm
                                          </td>
                                          <td>${sessionScope.materialList.cladding.length}</td>
                                          <td>${sessionScope.materialList.cladding.amount}</td>
                                          <td>${sessionScope.materialList.cladding.unit}</td>
                                          <td>${sessionScope.materialList.cladding.desc}</td>
                                       </tr>
                                    </c:if>

                                    <c:forEach items="${sessionScope.materialList.roofMaterials}" var="roofMaterial">
                                       <tr>
                                          <td>${roofMaterial.productName}</td>
                                          <td>${roofMaterial.materialLength}</td>
                                          <td>${roofMaterial.amount}</td>
                                          <td>${roofMaterial.unit}</td>
                                          <td>${roofMaterial.desc}</td>
                                       </tr>
                                    </c:forEach>
                                 </table>

                                 <!-- Make dynamic -->
                                 <table class="materialList_table">
                                    <tr class="materialListHeadRow">
                                       <th>Beslag & Skruer</th>
                                       <th></th>
                                       <th></th>
                                       <th></th>
                                       <th></th>
                                    </tr>

                                    <c:forEach items="${sessionScope.materialList.screws}" var="screw">
                                       <tr>
                                          <td>${screw.productName}</td>
                                          <td></td>
                                          <td>${screw.amount}</td>
                                          <td>${screw.unit}</td>
                                          <td>${screw.desc}</td>
                                       </tr>
                                    </c:forEach>

                                    <c:forEach items="${sessionScope.materialList.woodConnectors}" var="woodConnector">
                                       <tr>
                                          <td>${woodConnector.productName}</td>
                                          <td></td>
                                          <td>${woodConnector.amount}</td>
                                          <td>${woodConnector.unit}</td>
                                          <td>${woodConnector.desc}</td>
                                       </tr>
                                    </c:forEach>

                                    <c:forEach items="${sessionScope.materialList.doorComponents}" var="doorComponent">
                                       <tr>
                                          <td>${doorComponent.productName}</td>
                                          <td></td>
                                          <td>${doorComponent.amount}</td>
                                          <td>${doorComponent.unit}</td>
                                          <td>${doorComponent.desc}</td>
                                       </tr>
                                    </c:forEach>
                                 </table>
                              </div> <!-- #materialListTable_container END -->

                              <div class="materialListPrintBtn_container">
                                 <button type="button" id="materialListPrint_btn">
                                    Print
                                 </button>
                              </div>
                           </div> <!-- #materialList_container END -->

                           <div id="pricing_container" class="flexRow">
                              <div class="pricingSection_container">
                                 <section class="pricing_section">
                                    <h3 class="pricingSection_headline">Total pris:</h3>

                                    <!-- Make dynamic -->
                                    <div class="price_container">
                                       <span id="totalPrice" class="price">
                                          ${sessionScope.totalPrice}
                                       </span> kr.
                                    </div>
                                 </section>

                                 <section class="pricing_section">
                                    <h3 class="pricingSection_headline">Anbefalet salgspris:</h3>

                                    <!-- Make dynamic -->
                                    <div class="price_container">
                                       <span id="recommendedPrice" class="price">
                                          ${sessionScope.recommendedPrice}
                                       </span> kr.
                                    </div>
                                 </section>
                              </div> <!-- .class="pricingSection_container" END -->

                              <div class="pricingSection_container">
                                 <section class="pricing_section">
                                    <h3 class="pricingSection_headline">Juster salgspris:</h3>

                                    <!-- Make dynamic -->
                                    <div id="adjustedPrice_container" class="flexRow">
                                       <textarea name="adjustedPrice">${sessionScope.recommendedPrice}</textarea>

                                       <div>
                                          Kr.
                                       </div>
                                    </div>
                                 </section>
                              </div>
                           </div> <!-- #pricing_container END -->
                        </c:if>

                        <div class=" calculatorCardBtns_container flexRow">
                           <div class="calculatorCardBtn_container">
                              <button type="submit" class="calculatorCardBtn">Beregn stykliste</button>
                           </div>

                           <div class="calculatorCardBtn_container">
                              <button type="submit" formaction="saveInquiryChanges" class="calculatorCardBtn">Gem ændringer</button>
                           </div>
                        </div> <!-- .calculatorCardBtns_container .flexRow END -->

                        <div class="calculatorCardBtns_container flexRow">
                           <div class="calculatorCardBtn_container">
                              <button  type="submit" formaction="setInquiryAsCompleted" class="calculatorCardBtn">
                                 Afslut <i class="calculatorCardIcon far fa-check-circle"></i>
                              </button>
                           </div>

                           <div class="calculatorCardBtn_container">
                              <button type="submit" formaction="setInquiryAsCancelled" class="calculatorCardBtn">
                                 Annuller <i class="calculatorCardIcon far fa-times-circle"></i>
                              </button>
                           </div>
                        </div> <!-- .calculatorCardBtns_container .flexRow END -->
                     </div> <!-- #calculatorCardContent_container END -->
                  </div> <!-- #calculatorCard .calculatorCard-->

                  <div id="sketchCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Plantegning</h2>
                     </div>
                  </div> <!-- #calculatorCard .claculatorCard END -->

                  <div id="descCard" class="calculatorCard">
                     <div class="cardHeadline_container">
                        <h2 class="cardHeadline">Beskrivelse</h2>
                     </div>
                     <c:if test="${sessionScope.materialList == null}">
                        Beregn styklisten for at se en samlet beskrivelse af bestillingen
                     </c:if>

                     <c:if test="${sessionScope.materialList != null}">
                        <div id="descPrintBox">
                           <div id="descHeader">
                              <div id="descImg_container">
                                 <img src="<%=request.getContextPath()%>/assets/images/logo/logo.png" alt="Johannes Fog logo">
                              </div>
                           </div>

                           <div id="desc_container">
                              <div id="ccpiId_container">
                                 Ordre nr: #${sessionScope.inquiryById.ccpiId}
                              </div>

                              <div id="desc">
                                 Carport:
                                 ${sessionScope.inquiryById.customCarport.width}
                                 x
                                 ${sessionScope.inquiryById.customCarport.length}
                                 x
                                 ${sessionScope.inquiryById.customCarport.height} cm
                                 <br>

                                 <c:if test="${sessionScope.inquiryById.customCarport.toolshed != null}">
                                    Redskabsrum:
                                    ${sessionScope.inquiryById.customCarport.toolshed.toolshedWidth}
                                    x
                                    ${sessionScope.inquiryById.customCarport.toolshed.toolshedLength} cm<br>
                                 </c:if>

                                 <br>

                                 Tag:<br>
                                 Tagtype:
                                 <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId == 1}">
                                    Fladt tag
                                 </c:if>
                                 <c:if test="${sessionScope.inquiryById.customCarport.roofTypeId == 2}">
                                    Tag med rejsning
                                 </c:if>
                                 <br>

                                 Remtype: Ubh. spærtræ 45x195mm<br>
                                 Tagmateriale:
                                 <c:forEach items="${sessionScope.ccpOptionListContainer.roofMaterialOptions}" var="roofMaterialOption">
                                    <c:if test="${roofMaterialOption.id == sessionScope.inquiryById.customCarport.roofMaterialId}">
                                       ${roofMaterialOption.material}
                                    </c:if>
                                 </c:forEach>
                              </div> <!-- #desc END -->

                              <div id="descPrice_container" class="flexRow">
                                 <div>
                                    Pris:
                                 </div>

                                 <div>
                                    ${sessionScope.recommendedPrice} kr.
                                 </div>
                              </div>
                           </div> <!-- #desc_container END -->
                        </div>

                        <div class="materialListPrintBtn_container">
                           <button type="button" id="descPrint_btn">
                              Print
                           </button>
                        </div>
                     </c:if>
                  </div> <!-- #descCard .calculatorCard END -->
               </form>
            </div> <!-- #ccpiMaterialCalculator_container END -->
         </main>

         <%@include file="includes/admin_footer.txt"%>
      </div> <!-- #wrapper END -->

      <script src="<%=request.getContextPath()%>/assets/js/ccpiMaterialCalculator.js"></script>
      <script src="<%=request.getContextPath()%>/assets/js/ccpiMaterialCalculator_print.js"></script>
   </body>
</html>
