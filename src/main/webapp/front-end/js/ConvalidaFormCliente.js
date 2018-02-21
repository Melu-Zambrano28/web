
var fvalida  = function valida() {
    var inputs = document.getElementById("form").getElementsByClassName("zebra");
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].value === "") {
            alert("Il campo "  +  inputs[i].name  + " deve essere riempito");
            inputs[i].focus();
            inputs[i].style.borderColor= "4F95FF";
            //inputs[i].style.backgroundColor = "DE0C15";
            event.preventDefault()
            return;
        }
    }
}

var validazione = document.getElementById("valida");
validazione.addEventListener("click", fvalida);
//validazione.addEventListener("click", valida);