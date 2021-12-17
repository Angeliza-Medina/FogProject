// JavaScript Document

const allFilter_element = document.querySelector("#allFilter");
const pendingFilter_element = document.querySelector("#pendingFilter");
const inProgressFilter_element = document.querySelector("#inProgressFilter");
const completedFilter_element = document.querySelector("#completedFilter");
const cancelledFilter_element = document.querySelector("#cancelledFilter");
const filterBtn_elements = document.querySelectorAll(".filterBtn");

const currentLocation = window.location.href;
const url = new URL(currentLocation);
const filterParam = url.searchParams.get("filterType");

// For the ccpiMaterialCalculator.jsp - Set card order to default
document.cookie = "currentCard=; expires=Thu, 01 Jan 1970 00:00:00 UTC";

// Reset all button background-color and its icon color
filterBtn_elements.forEach(element => {
    element.style.backgroundColor = "var(--darkBlue)";{}

    if(element.querySelector(".filterBtn_icon") !== null){
        element.querySelector(".filterBtn_icon").style.color = "var(--orange)";
    }
});

// Change the clicked button's background-color and icon color
if(filterParam === null || filterParam === "all"){
    allFilter_element.style.backgroundColor = "var(--orange)";
}else if(filterParam === "pending"){
    pendingFilter_element.style.backgroundColor = "var(--orange)";
    pendingFilter_element.querySelector(".filterBtn_icon").style.color = "var(--darkBlue)";
}else if(filterParam === "inProgress"){
    inProgressFilter_element.style.backgroundColor = "var(--orange)";
    inProgressFilter_element.querySelector(".filterBtn_icon").style.color = "var(--darkBlue)";
}else if(filterParam === "completed"){
    completedFilter_element.style.backgroundColor = "var(--orange)";
    completedFilter_element.querySelector(".filterBtn_icon").style.color = "var(--darkBlue)";
}else if(filterParam === "cancelled"){
    cancelledFilter_element.style.backgroundColor = "var(--orange)";
    cancelledFilter_element.querySelector(".filterBtn_icon").style.color = "var(--darkBlue)";
}