window.onload = function() {
    var inputs = document.getElementsByClassName("input[type='text']");
    for (var i in inputs){
        i.setAttribute("value", "");
    }
}