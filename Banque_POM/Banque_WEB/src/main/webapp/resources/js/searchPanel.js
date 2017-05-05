document.getElementById("searchPanelTrigger").addEventListener("click", function () {
    openSearchPanel();
});

function openSearchPanel() {
    document.getElementById("mySearchPanel").style.width = "300px";
    document.getElementById("mySearchPanel").focus();
}

function closeSearchPanel() {
    document.getElementById("mySearchPanel").style.width = "0px";
}

$('.searchPanel').on('focusout', function () {
    closeSearchPanel();
});