// JavaScript Document

// Elements
const allBtnContainer_elements = document.querySelectorAll(".calculatorBtn_container");
const allCard_elements = document.querySelectorAll(".calculatorCard");

const buttonContainerIds =
    ["customerSectionBtn_container", "carportSectionBtn_container", "roofSectionBtn_container",
    "toolshedSectionBtn_container", "calculatorSectionBtn_container", "sketchSectionBtn_container",
     "descSectionBtn_container"];

const cookieValues = ["customerCard", "carportCard", "roofCard", "toolshedCard", "calculatorCard", "sketchCard", "descCard"];


// Set default page setting
if(getCookie("currentCard") === ""){
  changeColor(allBtnContainer_elements[0]);
  changeHeight(allBtnContainer_elements[0].childNodes[1]);
  bringCardToFront(allBtnContainer_elements[0]);
}else{
  for(let i = 0; i < allBtnContainer_elements.length; i++){
    if(getCookie("currentCard") === cookieValues[i]){
      changeColor(allBtnContainer_elements[i]);
      changeHeight(allBtnContainer_elements[i].childNodes[1]);
      bringCardToFront(allBtnContainer_elements[i]);
      break;
    }
  }
}

// Change default page setting according to button clicked
allBtnContainer_elements.forEach(element => {
  element.childNodes[1].addEventListener('click', event => {
    allBtnContainer_elements.forEach(otherElements => {
      resetToDefaultColor(otherElements); // Button container
      resetHeight(otherElements.childNodes[1]); // Button
    });

    changeColor(element); // Button container
    changeHeight(element.childNodes[1]); // Button
    bringCardToFront(element);

    for(let i = 0; i < allBtnContainer_elements.length; i++){
      if(element.id === buttonContainerIds[i]){
        document.cookie = "currentCard=" + cookieValues[i];
        break;
      }
    }
  });
});


/*--------------------------------- Button styling functions ---------------------------------*/
function changeColor(element){
  element.style.backgroundColor = "var(--orange)";
  element.childNodes[1].style.backgroundColor = "var(--orange)";
}

function resetToDefaultColor(element){
  element.style.backgroundColor = "transparent";
  element.childNodes[1].style.backgroundColor = "var(--darkBlue)";
}

function changeHeight(element){
  element.style.height = "90px";
}

function resetHeight(element){
  element.style.height = "auto";
}
/*------------------------------- Button styling functions END -------------------------------*/


/*------------------------------- Card preview order functions -------------------------------*/
function bringCardToFront(element){
  allCard_elements.forEach(element => {
    resetCardZIndex(element);
    makeCardInvisible(element);
  });

  for(let i = 0; i < allCard_elements.length; i++){
    if(element === allBtnContainer_elements[i]){
      getCorrespondingCard(allCard_elements[i]);
      makeCardVisible(allCard_elements[i]);
      break;
    }
  }
}

function getCorrespondingCard(card_element){
  card_element.style.zIndex = 2;
}

function resetCardZIndex(card_element){
  card_element.style.zIndex = 1;
}

function makeCardVisible(card_element){
  card_element.style.opacity = "1";
  card_element.style.display = "block";
  card_element.style.height = "auto";
}

function makeCardInvisible(card_element){
  card_element.style.opacity = "0";
  card_element.style.display = "none";
  card_element.style.height = "0";
}
/*----------------------------- Card preview order functions END -----------------------------*/

function getCookie(cookieName) {
  let name = cookieName + "=";
  let ca = document.cookie.split(';');

  for(let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}