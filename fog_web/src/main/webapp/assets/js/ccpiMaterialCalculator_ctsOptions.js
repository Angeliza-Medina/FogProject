// JavaScript Document

const main_element_ctsCard = document.querySelector("main");
const addToolshedTrueBtn_element = document.querySelector("#toolshedTrue");
const addToolshedFalseBtn_element = document.querySelector("#toolshedFalse");
const toolshedOptionContainer_element = document.querySelector("#toolshedOptions_container");
const defaultLengthOptionChildren_elements = Array.from(toolshedOptionContainer_element.children);
const toolshedWidthSelect_element = document.querySelector("#toolshedWidth");
const toolshedLengthSelect_element = document.querySelector("#toolshedLength");
const toolshedCladdingSelect_element = document.querySelector("#toolshedCladding");
const allSelect_elements = document.querySelectorAll(".ctsSelect_element");
const radioBtns_container_element = document.querySelector("#ctsLeftRightBtns_container");

let widthSelectIndex = toolshedWidthSelect_element.selectedIndex;
let lengthSelectIndex = toolshedLengthSelect_element.selectedIndex;
let claddingSelectIndex = toolshedCladdingSelect_element.selectedIndex;

if(addToolshedFalseBtn_element.checked){
    defaultLengthOptionChildren_elements.forEach(element => {
        element.style.opacity = "0";
        element.style.display = "none";
        element.style.height = "0";
    });
}

// Listen to if the option value is changed
allSelect_elements.forEach(element => {
    element.addEventListener("change", (event) =>{
        widthSelectIndex = toolshedWidthSelect_element.selectedIndex;
        lengthSelectIndex = toolshedLengthSelect_element.selectedIndex;
        claddingSelectIndex = toolshedCladdingSelect_element.selectedIndex;
    });
});


// Listen to when the radio btn is clicked
addToolshedFalseBtn_element.addEventListener("click", (event) => {
    // Hide the toolshed options when "add toolshed" is false
    defaultLengthOptionChildren_elements.forEach(element => {
        element.style.opacity = "0";
        element.style.display = "none";
        element.style.height = "0";
    });

    // Toolshed width and length are set to 0 and cladding is set to "No cladding"
    toolshedWidthSelect_element.selectedIndex = "0";
    toolshedLengthSelect_element.selectedIndex = "0";
    toolshedCladdingSelect_element.selectedIndex = "0";

    main_element_ctsCard.style.height = document.querySelector("#toolshedCard").offsetHeight + 200 + 'px';
});


// Listen to when the radio btn is clicked
addToolshedTrueBtn_element.addEventListener("click", (event) => {
    // Show the toolshed options when "add toolshed" is true
    defaultLengthOptionChildren_elements.forEach(element => {
        element.style.opacity = "1";
        element.style.display = "block";
        element.style.height = "auto";

        if(element === radioBtns_container_element){
            element.style.display = "flex";
        }

        main_element_ctsCard.style.height = document.querySelector("#toolshedCard").offsetHeight + 200 + 'px';
    });

    // Set value to placeholder on width, length and cladding select boxes
    toolshedWidthSelect_element.selectedIndex = widthSelectIndex;
    toolshedLengthSelect_element.selectedIndex = lengthSelectIndex;
    toolshedCladdingSelect_element.selectedIndex = claddingSelectIndex;
});