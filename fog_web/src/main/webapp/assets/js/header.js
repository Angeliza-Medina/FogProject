// JavaScript Document

const loginBtn_element = document.querySelector("#loginBtn");
const loginBoxContainer_element = document.querySelector("#loginBox_container");
const loginBoxContainer_elements = Array.from(loginBoxContainer_element.children);

let opened = false;

loginBtn_element.addEventListener("click", event => {

    if(opened === false){
        loginBoxContainer_element.style.opacity = 1;
        loginBoxContainer_element.style.display = "block";

        loginBoxContainer_elements.forEach(element => {
            element.style.opacity = 1;
            element.style.display = "block";
        });

        opened = true;
    }else{
        loginBoxContainer_element.style.opacity = 0;
        loginBoxContainer_element.style.display = "none";

        loginBoxContainer_elements.forEach(element => {
            element.style.opacity = 0;
            element.style.display = "none";
        });

        opened = false;
    }

});
