// JavaScript Document

const sketchInfoBox_element = document.querySelector("#sketchInfoBox");

// Info from server
    // Carport
    let server_ccpWidth = parseInt(sketchInfoBox_element.querySelector("#server_ccpWidth").innerHTML.trim());
    let server_ccpLength = parseInt(sketchInfoBox_element.querySelector("#server_ccpLength").innerHTML.trim());

    // Rafters
    let server_rafterSpacing = parseInt(sketchInfoBox_element.querySelector("#server_rafterSpacing").innerHTML.trim());
    let server_rafterThickness = parseInt(sketchInfoBox_element.querySelector("#server_rafterThickness").innerHTML.trim()) / 10;

    // Toolshed
    let server_hasToolshed = sketchInfoBox_element.querySelector("#server_hasToolshed").innerHTML.trim();
    let server_hasToolshedBoolean = (server_hasToolshed === "true");
    let server_toolshedPlacement;
    let server_toolshedWidth;
    let server_toolshedLength;

    if(server_hasToolshedBoolean){
        server_toolshedPlacement = sketchInfoBox_element.querySelector("#server_toolshedPlacement").innerHTML.trim();
        server_toolshedWidth = parseInt(sketchInfoBox_element.querySelector("#server_toolshedWidth").innerHTML.trim());
        server_toolshedLength = parseInt(sketchInfoBox_element.querySelector("#server_toolshedLength").innerHTML.trim());
    }

const svgNS = "http://www.w3.org/2000/svg";

const sketchSVG_element = document.querySelector("#sketchSVG");

// Dimentions and coordinates
let startX = 200;
let startY = 120;

let marginLR = 50;
let marginTB = 25;
let txtSpaceV = 25;
let txtSpaceH = 50;

let caportRafterDiff = 70;

let carportWidth = server_ccpWidth - caportRafterDiff;
let carportLength = server_ccpLength;

let hasToolshed = server_hasToolshedBoolean;
let isPlacedLeft;
let toolshedWidth;
let toolshedLenght;

if(hasToolshed){
    hasToolshed = true;
    toolshedWidth = server_toolshedWidth;
    toolshedLenght = server_toolshedLength;

    if(toolshedWidth === 600){
        toolshedWidth = toolshedWidth - caportRafterDiff;
    }

    if(server_toolshedPlacement === "left"){
        isPlacedLeft = true;
    }else if(server_toolshedPlacement === "right"){
        isPlacedLeft = false;
    }
}

let rafterThickness = server_rafterThickness;
let rafterLength = carportWidth + caportRafterDiff;
let rafterSpacing = server_rafterSpacing;
let rafterAmount = Math.ceil(carportLength / (rafterThickness + rafterSpacing));

// Carport, toolshed, hulbaand, (rafters are in the function) svg elements
let carport = document.createElementNS(svgNS, "rect");
let toolshed = document.createElementNS(svgNS, "rect");
let hulbaandLeft = document.createElementNS(svgNS, "line");
let hulbaandRight = document.createElementNS(svgNS, "line");

// Meassurement line svg elements
// Carport
    // Width
    let ccpWidthHLineTop = document.createElementNS(svgNS, "line");
    let ccpWidthHLineBottom = document.createElementNS(svgNS, "line");
    let ccpWidthLineTop = document.createElementNS(svgNS, "line");
    let ccpWidthLineBottom = document.createElementNS(svgNS, "line");
    let ccpWidthTxt = document.createElementNS(svgNS, "text");

    // Length
    let ccpLengthVLineLeft = document.createElementNS(svgNS, "line");
    let ccpLengthVLineRight = document.createElementNS(svgNS, "line");
    let ccpLengthLineLeft = document.createElementNS(svgNS, "line");
    let ccpLengthLineRight = document.createElementNS(svgNS, "line");
    let ccpLengthTxt = document.createElementNS(svgNS, "text");

// Rafter
    // Width (Length)
    let rafterWidthHLineTop = document.createElementNS(svgNS, "line");
    let rafterWidthHLineBottom = document.createElementNS(svgNS, "line");
    let rafterWidthLineTop = document.createElementNS(svgNS, "line");
    let rafterWidthLineBottom = document.createElementNS(svgNS, "line");
    let rafterTxt = document.createElementNS(svgNS, "text");

    // Spacing
    let rafterSpacingVLineLeft = document.createElementNS(svgNS, "line");
    let rafterSpacingVLineRight = document.createElementNS(svgNS, "line");
    let rafterSpacingLine = document.createElementNS(svgNS, "line");
    let rafterSpacingTxt = document.createElementNS(svgNS, "text");

// Toolshed
    // Width
    let ctsWidthHLineTop;
    let ctsWidthHLineBottom;
    let ctsWidthLineTop;
    let ctsWidthLineBottom;
    let ctsWidthTxt;

    // Length
    let ctsLengthVLineLeft = document.createElementNS(svgNS, "line");
    let ctsLengthVLineRight = document.createElementNS(svgNS, "line");
    let ctsLengthLineLeft = document.createElementNS(svgNS, "line");
    let ctsLengthLineRight = document.createElementNS(svgNS, "line");
    let ctsLengthTxt = document.createElementNS(svgNS, "text");

if(hasToolshed){
    // Width
    ctsWidthHLineTop = document.createElementNS(svgNS, "line");
    ctsWidthHLineBottom = document.createElementNS(svgNS, "line");
    ctsWidthLineTop = document.createElementNS(svgNS, "line");
    ctsWidthLineBottom = document.createElementNS(svgNS, "line");
    ctsWidthTxt = document.createElementNS(svgNS, "text");

    // Length
    ctsLengthVLineLeft = document.createElementNS(svgNS, "line");
    ctsLengthVLineRight = document.createElementNS(svgNS, "line");
    ctsLengthLineLeft = document.createElementNS(svgNS, "line");
    ctsLengthLineRight = document.createElementNS(svgNS, "line");
    ctsLengthTxt = document.createElementNS(svgNS, "text");
}

drawCarport();
drawCarportWidthLine()
drawCarportLengthLine();
drawHulbaand();
drawRafterWidthLine();
drawRafterSpacingLine();

if(hasToolshed){
    drawToolshed();
    drawToolshedWidthLine();
    drawToolshedLengthLine();
}

// Caport, rafters, toolshed
sketchSVG_element.appendChild(carport);
sketchSVG_element.appendChild(toolshed);
drawRafters();
sketchSVG_element.appendChild(hulbaandLeft);
sketchSVG_element.appendChild(hulbaandRight);

// Carport measurement lines
// Width
sketchSVG_element.appendChild(ccpWidthHLineTop);
sketchSVG_element.appendChild(ccpWidthLineTop);
sketchSVG_element.appendChild(ccpWidthLineBottom);
sketchSVG_element.appendChild(ccpWidthHLineBottom);
sketchSVG_element.appendChild(ccpWidthTxt);

// Length
sketchSVG_element.appendChild(ccpLengthVLineRight);
sketchSVG_element.appendChild(ccpLengthVLineLeft);
sketchSVG_element.appendChild(ccpLengthLineLeft);
sketchSVG_element.appendChild(ccpLengthLineRight);
sketchSVG_element.appendChild(ccpLengthTxt);

// Rafter measurement lines
// Width
sketchSVG_element.appendChild(rafterWidthHLineTop);
sketchSVG_element.appendChild(rafterWidthLineTop);
sketchSVG_element.appendChild(rafterWidthLineBottom);
sketchSVG_element.appendChild(rafterWidthHLineBottom);
sketchSVG_element.appendChild(rafterTxt);

// Spacing
sketchSVG_element.appendChild(rafterSpacingVLineLeft);
sketchSVG_element.appendChild(rafterSpacingVLineRight);
sketchSVG_element.appendChild(rafterSpacingLine);
sketchSVG_element.appendChild(rafterSpacingTxt);

// Toolshed measurement lines
if(hasToolshed){
    // Width
    sketchSVG_element.appendChild(ctsWidthHLineTop);
    sketchSVG_element.appendChild(ctsWidthLineTop);
    sketchSVG_element.appendChild(ctsWidthLineBottom);
    sketchSVG_element.appendChild(ctsWidthHLineBottom);
    sketchSVG_element.appendChild(ctsWidthTxt);

// Length
    sketchSVG_element.appendChild(ctsLengthVLineLeft);
    sketchSVG_element.appendChild(ctsLengthVLineRight);
    sketchSVG_element.appendChild(ctsLengthLineLeft);
    sketchSVG_element.appendChild(ctsLengthLineRight);
    sketchSVG_element.appendChild(ctsLengthTxt);
}

function drawCarport(){
    carport.setAttribute("x", startX);
    carport.setAttribute("y", startY);
    carport.setAttribute("width", carportLength);
    carport.setAttribute("height", carportWidth);
    carport.setAttribute("fill", "#fff");
    carport.setAttribute("stroke", "#000")
    carport.setAttribute("stroke-width", 1)
}

function drawToolshed(){
    if(isPlacedLeft){
        toolshed.setAttribute("x", startX + carportLength - toolshedLenght);
        toolshed.setAttribute("y", startY);
    }else{
        toolshed.setAttribute("x", startX + carportLength - toolshedLenght);
        toolshed.setAttribute("y", startY + carportWidth - toolshedWidth);
    }

    toolshed.setAttribute("width", toolshedLenght);
    toolshed.setAttribute("height", toolshedWidth);
    toolshed.setAttribute("fill", "#000");
    toolshed.setAttribute("stroke", "#000")
    toolshed.setAttribute("stroke-width", 1)
}

function drawRafters(){
    let rafterXPosL = startX;
    let rafterXPosR = startX + carportLength - rafterThickness;

    let drawFromLeft = true;

    for(let i = 0; i < rafterAmount; i++){
        let rafterBase = document.createElementNS(svgNS, "rect");

        if(drawFromLeft){
            rafterBase.setAttribute("x", rafterXPosL);
        }else{
            rafterBase.setAttribute("x", rafterXPosR);
        }

        rafterBase.setAttribute("y", startY + (carportWidth / 2) - (rafterLength / 2));
        rafterBase.setAttribute("width", rafterThickness);
        rafterBase.setAttribute("height", rafterLength);
        rafterBase.setAttribute("fill", "#fff");
        rafterBase.setAttribute("stroke", "#000")
        rafterBase.setAttribute("stroke-width", 1)

        sketchSVG_element.appendChild(rafterBase);

        if(drawFromLeft){
            rafterXPosL = rafterXPosL + rafterThickness + rafterSpacing;
            drawFromLeft = false;
        }else{
            rafterXPosR = rafterXPosR - rafterThickness - rafterSpacing;
            drawFromLeft = true;
        }

    }
}

function drawHulbaand(){
    hulbaandLeft.setAttribute("x1", startX + rafterThickness + rafterSpacing);
    hulbaandLeft.setAttribute("y1", startY);

    if(hasToolshed){
        let hulbaandEnd = startX + carportLength - Math.floor(toolshedLenght / (rafterThickness + rafterSpacing)) * (rafterThickness + rafterSpacing);
        hulbaandLeft.setAttribute("x2", hulbaandEnd);
    }else{
        hulbaandLeft.setAttribute("x2", startX + carportLength);
    }

    hulbaandLeft.setAttribute("y2", startY + carportWidth);
    hulbaandLeft.setAttribute("stroke", "#000")
    hulbaandLeft.setAttribute("stroke-dasharray", "5,5");
    hulbaandLeft.setAttribute("stroke-width", 2)

    //-------------------------------------------------------------------------------

    hulbaandRight.setAttribute("x1", startX + rafterThickness + rafterSpacing);
    hulbaandRight.setAttribute("y1", startY + carportWidth);

    if(hasToolshed){
        let hulbaandEnd = startX + carportLength - Math.floor(toolshedLenght / (rafterThickness + rafterSpacing)) * (rafterThickness + rafterSpacing);
        hulbaandRight.setAttribute("x2", hulbaandEnd)
    }else{
        hulbaandRight.setAttribute("x2", startX + carportLength);
    }

    hulbaandRight.setAttribute("y2", startY);
    hulbaandRight.setAttribute("stroke", "#000");
    hulbaandRight.setAttribute("stroke-dasharray", "5,5");
    hulbaandRight.setAttribute("stroke-width", 2);
}

function drawCarportWidthLine(){
    //Top horizontal line
    ccpWidthHLineTop.setAttribute("x1", startX - marginLR + 10);
    ccpWidthHLineTop.setAttribute("y1", startY);
    ccpWidthHLineTop.setAttribute("x2", startX - marginLR - 10);
    ccpWidthHLineTop.setAttribute("y2", startY);

    ccpWidthHLineTop.setAttribute("stroke", "#000");
    ccpWidthHLineTop.setAttribute("stroke-width", 1);

    // Top vertical line
    ccpWidthLineTop.setAttribute("x1", startX - marginLR);
    ccpWidthLineTop.setAttribute("y1", startY);
    ccpWidthLineTop.setAttribute("x2", startX - marginLR);
    ccpWidthLineTop.setAttribute("y2", startY + (carportWidth / 2) - txtSpaceV);
    ccpWidthLineTop.setAttribute("stroke", "#000");
    ccpWidthLineTop.setAttribute("stroke-width", 1);

    // Bottom vertical line
    ccpWidthLineBottom.setAttribute("x1", startX - marginLR);
    ccpWidthLineBottom.setAttribute("y1", startY + (carportWidth / 2) + txtSpaceV);
    ccpWidthLineBottom.setAttribute("x2", startX - marginLR);
    ccpWidthLineBottom.setAttribute("y2", startY + carportWidth);
    ccpWidthLineBottom.setAttribute("stroke", "#000");
    ccpWidthLineBottom.setAttribute("stroke-width", 1);

    //Bottom horizontal line
    ccpWidthHLineBottom.setAttribute("x1", startX - marginLR + 10);
    ccpWidthHLineBottom.setAttribute("y1", startY + carportWidth);
    ccpWidthHLineBottom.setAttribute("x2", startX - marginLR - 10);
    ccpWidthHLineBottom.setAttribute("y2", startY + carportWidth);
    ccpWidthHLineBottom.setAttribute("stroke", "#000");
    ccpWidthHLineBottom.setAttribute("stroke-width", 1);

    // Text
    ccpWidthTxt.setAttributeNS(null,"x", startX - marginLR - 30);
    ccpWidthTxt.setAttributeNS(null,"y", startY + (carportWidth / 2) + (txtSpaceV / 2));
    ccpWidthTxt.setAttributeNS(null,"font-size","18");
    ccpWidthTxt.setAttribute("fill", "#000");

    let textNode = document.createTextNode(carportWidth + " cm");
    ccpWidthTxt.appendChild(textNode);
}

function drawCarportLengthLine(){
    let verticalLineH = 20;

    //Left vertical line
    ccpLengthVLineLeft.setAttribute("x1", startX);
    ccpLengthVLineLeft.setAttribute("y1", startY + carportWidth + (marginTB * 5));
    ccpLengthVLineLeft.setAttribute("x2", startX);
    ccpLengthVLineLeft.setAttribute("y2", startY + carportWidth + (marginTB * 5) + verticalLineH);
    ccpLengthVLineLeft.setAttribute("stroke", "#000");
    ccpLengthVLineLeft.setAttribute("stroke-width", 1);

    // Horizontal line left
    ccpLengthLineLeft.setAttribute("x1", startX);
    ccpLengthLineLeft.setAttribute("y1", startY + carportWidth + (marginTB * 5) + (verticalLineH / 2));
    ccpLengthLineLeft.setAttribute("x2", startX + (carportLength / 2) - txtSpaceH);
    ccpLengthLineLeft.setAttribute("y2", startY + carportWidth + (marginTB * 5) + (verticalLineH / 2));
    ccpLengthLineLeft.setAttribute("stroke", "#000");
    ccpLengthLineLeft.setAttribute("stroke-width", 1);

    // Horizontal line right
    ccpLengthLineRight.setAttribute("x1", startX + (carportLength / 2) + txtSpaceH);
    ccpLengthLineRight.setAttribute("y1", startY + carportWidth + (marginTB * 5) + (verticalLineH / 2));
    ccpLengthLineRight.setAttribute("x2", startX + carportLength);
    ccpLengthLineRight.setAttribute("y2", startY + carportWidth + (marginTB * 5) + (verticalLineH / 2));
    ccpLengthLineRight.setAttribute("stroke", "#000");
    ccpLengthLineRight.setAttribute("stroke-width", 1);

    //Right vertical line
    ccpLengthVLineRight.setAttribute("x1", startX + carportLength);
    ccpLengthVLineRight.setAttribute("y1", startY + carportWidth + (marginTB * 5));
    ccpLengthVLineRight.setAttribute("x2", startX + carportLength);
    ccpLengthVLineRight.setAttribute("y2", startY + carportWidth + (marginTB * 5) + verticalLineH);
    ccpLengthVLineRight.setAttribute("stroke", "#000");
    ccpLengthVLineRight.setAttribute("stroke-width", 1);

    // Text
    ccpLengthTxt.setAttributeNS(null,"x", startX + (carportLength / 2) + (txtSpaceH / 2) - 55);
    ccpLengthTxt.setAttributeNS(null,"y", startY + carportWidth + (marginTB * 5) + verticalLineH);
    ccpLengthTxt.setAttributeNS(null,"font-size","18");
    ccpLengthTxt.setAttribute("fill", "#000");

    let textNode = document.createTextNode(carportLength + " cm");
    ccpLengthTxt.appendChild(textNode);
}

function drawRafterWidthLine(){
    //Top horizontal line
    rafterWidthHLineTop.setAttribute("x1", startX - (marginLR * 3) + 10);
    rafterWidthHLineTop.setAttribute("y1", startY + (carportWidth / 2) - (rafterLength / 2));
    rafterWidthHLineTop.setAttribute("x2", startX - (marginLR * 3) - 10);
    rafterWidthHLineTop.setAttribute("y2", startY + (carportWidth / 2) - (rafterLength / 2));
    rafterWidthHLineTop.setAttribute("stroke", "#000");
    rafterWidthHLineTop.setAttribute("stroke-width", 1);

    // Top vertical line
    rafterWidthLineTop.setAttribute("x1", startX - (marginLR * 3));
    rafterWidthLineTop.setAttribute("y1", startY + (carportWidth / 2) - (rafterLength / 2));
    rafterWidthLineTop.setAttribute("x2", startX - (marginLR * 3));
    rafterWidthLineTop.setAttribute("y2", startY + (carportWidth / 2) - txtSpaceV);
    rafterWidthLineTop.setAttribute("stroke", "#000");
    rafterWidthLineTop.setAttribute("stroke-width", 1);

    // Bottom vertical line
    rafterWidthLineBottom.setAttribute("x1", startX - (marginLR * 3));
    rafterWidthLineBottom.setAttribute("y1", startY + (carportWidth / 2) + txtSpaceV);
    rafterWidthLineBottom.setAttribute("x2", startX - (marginLR * 3));
    rafterWidthLineBottom.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2));
    rafterWidthLineBottom.setAttribute("stroke", "#000");
    rafterWidthLineBottom.setAttribute("stroke-width", 1);

    //Bottom horizontal line
    rafterWidthHLineBottom.setAttribute("x1", startX - (marginLR * 3) + 10);
    rafterWidthHLineBottom.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2));
    rafterWidthHLineBottom.setAttribute("x2", startX - (marginLR * 3) - 10);
    rafterWidthHLineBottom.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2));
    rafterWidthHLineBottom.setAttribute("stroke", "#000");
    rafterWidthHLineBottom.setAttribute("stroke-width", 1);

    // Text
    rafterTxt.setAttributeNS(null,"x", startX - (marginLR * 3) - 30);
    rafterTxt.setAttributeNS(null,"y", startY + (carportWidth / 2) + (txtSpaceV / 2));
    rafterTxt.setAttributeNS(null,"font-size","18");
    rafterTxt.setAttribute("fill", "#000");

    let textNode = document.createTextNode(rafterLength + " cm");
    rafterTxt.appendChild(textNode);
}

function drawRafterSpacingLine(){
    let verticalLineH = 20;

    //Left vertical line
    rafterSpacingVLineLeft.setAttribute("x1", startX + rafterThickness);
    rafterSpacingVLineLeft.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB);
    rafterSpacingVLineLeft.setAttribute("x2", startX + rafterThickness);
    rafterSpacingVLineLeft.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + verticalLineH);
    rafterSpacingVLineLeft.setAttribute("stroke", "#000");
    rafterSpacingVLineLeft.setAttribute("stroke-width", 1);

    // Horizontal line
    rafterSpacingLine.setAttribute("x1", startX + rafterThickness);
    rafterSpacingLine.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + (verticalLineH /2));
    rafterSpacingLine.setAttribute("x2", startX + rafterThickness + rafterSpacing);
    rafterSpacingLine.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB  + (verticalLineH /2));
    rafterSpacingLine.setAttribute("stroke", "#000");
    rafterSpacingLine.setAttribute("stroke-width", 1);

    //Right vertical line
    rafterSpacingVLineRight.setAttribute("x1", startX + rafterThickness + rafterSpacing);
    rafterSpacingVLineRight.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB);
    rafterSpacingVLineRight.setAttribute("x2", startX + rafterThickness + rafterSpacing);
    rafterSpacingVLineRight.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + verticalLineH);
    rafterSpacingVLineRight.setAttribute("stroke", "#000");
    rafterSpacingVLineRight.setAttribute("stroke-width", 1);

    // Text
    rafterSpacingTxt.setAttributeNS(null,"x", startX + rafterThickness + (rafterSpacing / 2) - 25);
    rafterSpacingTxt.setAttributeNS(null,"y", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + (verticalLineH * 2));
    rafterSpacingTxt.setAttributeNS(null,"font-size","18");
    rafterSpacingTxt.setAttribute("fill", "#000");

    let textNode = document.createTextNode(rafterSpacing + " cm");
    rafterSpacingTxt.appendChild(textNode);
}

function drawToolshedWidthLine(){
    //Top horizontal line
    ctsWidthHLineTop.setAttribute("x1", startX + carportLength + marginLR - 10);

    if(isPlacedLeft){
        ctsWidthHLineTop.setAttribute("y1", startY);
    }else{
        ctsWidthHLineTop.setAttribute("y1", startY + carportWidth - toolshedWidth);
    }

    ctsWidthHLineTop.setAttribute("x2", startX + carportLength + marginLR + 10);

    if(isPlacedLeft){
        ctsWidthHLineTop.setAttribute("y2", startY);
    }else{
        ctsWidthHLineTop.setAttribute("y2", startY + carportWidth - toolshedWidth);
    }

    ctsWidthHLineTop.setAttribute("stroke", "#000");
    ctsWidthHLineTop.setAttribute("stroke-width", 1);

    // Top vertical line
    ctsWidthLineTop.setAttribute("x1", startX + carportLength + marginLR);
    if(isPlacedLeft){
        ctsWidthLineTop.setAttribute("y1", startY);
    }else{
        ctsWidthLineTop.setAttribute("y1", startY + carportWidth - toolshedWidth);
    }

    // Top vertical line
    ctsWidthLineTop.setAttribute("x2", startX + carportLength + marginLR);
    if(isPlacedLeft){
        ctsWidthLineTop.setAttribute("y2", startY + (toolshedWidth / 2) - txtSpaceV);
    }else{
        ctsWidthLineTop.setAttribute("y2", startY + carportWidth - (toolshedWidth / 2) - txtSpaceV);
    }

    ctsWidthLineTop.setAttribute("stroke", "#000");
    ctsWidthLineTop.setAttribute("stroke-width", 1);

    // Bottom vertical line
    ctsWidthLineBottom.setAttribute("x1", startX + carportLength + marginLR);

    if(isPlacedLeft){
        ctsWidthLineBottom.setAttribute("y1", startY + (toolshedWidth / 2) + txtSpaceV);
    }else{
        ctsWidthLineBottom.setAttribute("y1", startY + carportWidth - (toolshedWidth / 2) + txtSpaceV);
    }

    ctsWidthLineBottom.setAttribute("x2", startX + carportLength + marginLR);
    if(isPlacedLeft){
        ctsWidthLineBottom.setAttribute("y2", startY + toolshedWidth);
    }else{
        ctsWidthLineBottom.setAttribute("y2", startY + carportWidth);
    }
    ctsWidthLineBottom.setAttribute("stroke", "#000");
    ctsWidthLineBottom.setAttribute("stroke-width", 1);

    //Bottom horizontal line
    ctsWidthHLineBottom.setAttribute("x1", startX + carportLength + marginLR - 10);
    if(isPlacedLeft){
        ctsWidthHLineBottom.setAttribute("y1", startY + toolshedWidth);
    }else{
        ctsWidthHLineBottom.setAttribute("y1", startY + carportWidth);
    }

    ctsWidthHLineBottom.setAttribute("x2", startX + carportLength + marginLR + 10);
    if(isPlacedLeft){
        ctsWidthHLineBottom.setAttribute("y2", startY + toolshedWidth);
    }else{
        ctsWidthHLineBottom.setAttribute("y2", startY + carportWidth);
    }
    ctsWidthHLineBottom.setAttribute("stroke", "#000");
    ctsWidthHLineBottom.setAttribute("stroke-width", 1);

    // Text
    ctsWidthTxt.setAttributeNS(null,"x", startX + carportLength + (marginLR / 2) + 7);
    if(isPlacedLeft){
        ctsWidthTxt.setAttributeNS(null,"y", startY + (toolshedWidth / 2) + (txtSpaceV / 2));
    }else{
        ctsWidthTxt.setAttributeNS(null,"y", startY + carportWidth - (toolshedWidth / 2) + (txtSpaceV / 2));
    }
    ctsWidthTxt.setAttributeNS(null,"font-size","18");
    ctsWidthTxt.setAttribute("fill", "#000");

    let textNode = document.createTextNode(toolshedWidth + " cm");
    ctsWidthTxt.appendChild(textNode);
}

function drawToolshedLengthLine(){
    let verticalLineH = 20;

    //Left vertical line
    ctsLengthVLineLeft.setAttribute("x1", startX + carportLength - toolshedLenght);

    if(isPlacedLeft){
        ctsLengthVLineLeft.setAttribute("y1", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB);
    }else{
        ctsLengthVLineLeft.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB);
    }

    ctsLengthVLineLeft.setAttribute("x2", startX + carportLength - toolshedLenght);

    if(isPlacedLeft){
        ctsLengthVLineLeft.setAttribute("y2", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB - verticalLineH);
    }else{
        ctsLengthVLineLeft.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + verticalLineH);
    }

    ctsLengthVLineLeft.setAttribute("stroke", "#000");
    ctsLengthVLineLeft.setAttribute("stroke-width", 1);

    // Horizontal line left
    ctsLengthLineLeft.setAttribute("x1", startX + carportLength - toolshedLenght);

    if(isPlacedLeft){
        ctsLengthLineLeft.setAttribute("y1", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB - (verticalLineH /2));
    }else{
        ctsLengthLineLeft.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + (verticalLineH /2));
    }

    ctsLengthLineLeft.setAttribute("x2", startX + carportLength - (toolshedLenght / 2) - txtSpaceH);

    if(isPlacedLeft){
        ctsLengthLineLeft.setAttribute("y2", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB - (verticalLineH /2));
    }else{
        ctsLengthLineLeft.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + (verticalLineH /2));
    }

    ctsLengthLineLeft.setAttribute("stroke", "#000");
    ctsLengthLineLeft.setAttribute("stroke-width", 1);

    // Horizontal line right
    ctsLengthLineRight.setAttribute("x1", startX + carportLength - (toolshedLenght / 2) + txtSpaceH);

    if(isPlacedLeft){
        ctsLengthLineRight.setAttribute("y1", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB - (verticalLineH /2));
    }else{
        ctsLengthLineRight.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + (verticalLineH /2));
    }

    ctsLengthLineRight.setAttribute("x2", startX + carportLength);

    if(isPlacedLeft){
        ctsLengthLineRight.setAttribute("y2", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB - (verticalLineH /2));
    }else{
        ctsLengthLineRight.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + (verticalLineH /2));
    }

    ctsLengthLineRight.setAttribute("stroke", "#000");
    ctsLengthLineRight.setAttribute("stroke-width", 1);

    //Right vertical line
    ctsLengthVLineRight.setAttribute("x1", startX + carportLength);

    if(isPlacedLeft){
        ctsLengthVLineRight.setAttribute("y1", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB);
    }else{
        ctsLengthVLineRight.setAttribute("y1", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB);
    }

    ctsLengthVLineRight.setAttribute("x2", startX + carportLength);

    if(isPlacedLeft){
        ctsLengthVLineRight.setAttribute("y2", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB - verticalLineH);
    }else{
        ctsLengthVLineRight.setAttribute("y2", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + verticalLineH);
    }

    ctsLengthVLineRight.setAttribute("stroke", "#000");
    ctsLengthVLineRight.setAttribute("stroke-width", 1);

    // Text
    ctsLengthTxt.setAttributeNS(null,"x", startX + carportLength - (toolshedLenght / 2) + (txtSpaceH / 2) - 55);
    if(isPlacedLeft){
        ctsLengthTxt.setAttributeNS(null,"y", startY + (carportWidth / 2) - (rafterLength / 2) - marginTB);
    } else{
        ctsLengthTxt.setAttributeNS(null,"y", startY + (carportWidth / 2) + (rafterLength / 2) + marginTB + verticalLineH);
    }

    ctsLengthTxt.setAttributeNS(null,"font-size","18");
    ctsLengthTxt.setAttribute("fill", "#000");

    let textNode = document.createTextNode(toolshedLenght + " cm");
    ctsLengthTxt.appendChild(textNode);
}