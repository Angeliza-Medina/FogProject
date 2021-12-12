// JavaScript Document

// Elements
const allBtnContainer_elements = document.querySelectorAll(".calculatorBtn_container");
const allCard_elements = document.querySelectorAll(".calculatorCard");

// Set default page setting
changeColor(allBtnContainer_elements[0]);
changeHeight(allBtnContainer_elements[0].childNodes[1]);
bringCardToFront(allBtnContainer_elements[0]);


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
  })
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
      console.log(allCard_elements[i]);
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