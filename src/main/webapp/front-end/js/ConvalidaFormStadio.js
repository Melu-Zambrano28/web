/*function convalidaForm() {
    var nomeStadio=document.formul.nomeStadio.value;
    var capienza=parseInt(document.formul.capienza.value);
    var prezzo=parseFloat(document.formul.prezzo.value);
    if(nomeStadio=="" && capienza<=0 && prezzo<=0) {
        alert("Il nome non puo essere vuoto");
        console.log(nomeStadio);

    }
}*/


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


class Animale {
    constructor(nome, peso) {
        this.nome = nome;
        this.peso = peso;
    }
    getNome() {
        return this.nome;
    }
    setNome(nome) {
        this.nome = nome;
    }
}

function animale(nomeScientifico) {
    var name = nomeScientifico;
    this.setName = function(nomeScientifico) {name = nomeScientifico;}
    this.getName = function() {return name;}
}

var amish = new Animale("Pecora", 56);