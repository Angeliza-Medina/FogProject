// JavaScript Document

const materialListTableContainer_element = document.querySelector("#materialListTable_container");
const materialListPrintBtn_element = document.querySelector("#materialListPrint_btn");

materialListPrintBtn_element.addEventListener("click", event => {
    var mywindow = window.open('', 'PRINT', 'height=400,width=600');
    mywindow.document.write('<html><head><title>Styk-liste</title>');
    mywindow.document.write('<link rel="stylesheet" href="../assets/css/ccpiMaterialCalculator.css" type="text/css" media="all"/>');
    mywindow.document.write('</head><body >');
    mywindow.document.write(materialListTableContainer_element.innerHTML);
    mywindow.document.write('</body></html>');
    mywindow.document.close();
    mywindow.focus();
    setTimeout(function(){ mywindow.print(); mywindow.close(); },500);
});
