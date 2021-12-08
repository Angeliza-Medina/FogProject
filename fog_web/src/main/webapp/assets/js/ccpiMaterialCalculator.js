// JavaScript Document

// Calculator page buttons
const customerBtnContainer_element = document.querySelector("#customerSectionBtn_container");
const carportBtnContainer_element = document.querySelector("#carportSectionBtn_container");
const roofBtnContainer_element = document.querySelector("#roofSectionBtn_container");
const toolshedBtnContainer_element = document.querySelector("#toolshedSectionBtn_container");
const calculatorBtnContainer_element = document.querySelector("#calculatorSectionBtn_container");
const sketchBtnContainer_element = document.querySelector("#sketchSectionBtn_container");
const descBtnContainer_element = document.querySelector("#descSectionBtn_container");

const allBtnContainer_elements = document.querySelectorAll(".calculatorBtn_container");

// Calculator pages
const customerCard_element = document.querySelector("#customerCard");
const carportCard_element = document.querySelector("#carportCard");
const roofCard_element = document.querySelector("#roofCard");
const toolshedCard_element = document.querySelector("#toolshedCard");
const calculatorCard_element = document.querySelector("#calculatorCard");
const sketchCard_element = document.querySelector("#sketchCard");
const descCard_element = document.querySelector("#descCard");

const allCard_elements = document.querySelectorAll(".calculatorCard");


// Set default page setting
changeColor(customerBtnContainer_element);
changeHeight(customerBtnContainer_element.childNodes[1]);
bringCardToFront(customerBtnContainer_element);


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
  });

  if(element === customerBtnContainer_element){
    getCorrespondingCard(allCard_elements[0]);
  }else if(element === carportBtnContainer_element){
    getCorrespondingCard(allCard_elements[1]);
  }else if(element === roofBtnContainer_element){
    getCorrespondingCard(allCard_elements[2]);
  }else if(element === toolshedBtnContainer_element){
    getCorrespondingCard(allCard_elements[3]);
  }else if(element === calculatorBtnContainer_element){
    getCorrespondingCard(allCard_elements[4]);
  }else if(element === sketchBtnContainer_element){
    getCorrespondingCard(allCard_elements[5]);
  }else if(element === descBtnContainer_element){
    getCorrespondingCard(allCard_elements[6]);
  }
}

function getCorrespondingCard(card_element){
  card_element.style.zIndex = 2;
}

function resetCardZIndex(card_element){
  card_element.style.zIndex = 1;
}
/*----------------------------- Card preview order functions END -----------------------------*/