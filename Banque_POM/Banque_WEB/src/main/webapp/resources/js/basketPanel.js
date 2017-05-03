document.getElementById("basketTrigger").addEventListener("click", function () {
    openBasketPanel();
});

function openBasketPanel() {
    document.getElementById("myBasketPanel").display = "block";
    document.getElementById("myBasketPanel").focus();
}

function closeBasketPanel() {
    document.getElementById("myBasketPanel").display = "none";
}

$('.basketPanel').on('focusout', function () {
    closeBasketPanel();
});