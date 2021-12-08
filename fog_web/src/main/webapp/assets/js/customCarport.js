// JavaScript Document

const addToolshedTrueBtn_element = document.querySelector("#toolshedTrue");
const addToolshedFalseBtn_element = document.querySelector("#toolshedFalse");
const toolshedOptionContainer_element = document.querySelector("#toolshedOptions_container");
const defaultLengthOptionChildren_elements = Array.from(toolshedOptionContainer_element.children);
const toolshedWidthSelect_element = document.querySelector("#toolshedWidth");
const toolshedLengthSelect_element = document.querySelector("#toolshedLength");
const toolshedCladdingSelect_element = document.querySelector("#toolshedCladding");


// Listen to when the radio btn is clicked
addToolshedFalseBtn_element.addEventListener("click", (event) => {

  // Hide the toolshed options when "add toolshed" is false
  defaultLengthOptionChildren_elements.forEach(element => {
    element.style.opacity = 0;
    element.style.display = "none";
    element.style.height = 0;
  });

  // Set value for the select box to 0 on both width and length
  toolshedWidthSelect_element.selectedIndex = "1";
  toolshedLengthSelect_element.selectedIndex = "1";
  toolshedCladdingSelect_element.selctedIndex = "1";
});


// Listen to when the radio btn is clicked
addToolshedTrueBtn_element.addEventListener("click", (event) => {

  // Show the toolshed options when "add toolshed" is true
  defaultLengthOptionChildren_elements.forEach(element => {
    element.style.opacity = 1;
    element.style.display = "block";
    element.style.height = "auto";
  });

  // Set value for the select box to placeholder on both width and length
  toolshedWidthSelect_element.selectedIndex = "0";
  toolshedLengthSelect_element.selectedIndex = "0";
  toolshedCladdingSelect_element.selctedIndex = "0";

});