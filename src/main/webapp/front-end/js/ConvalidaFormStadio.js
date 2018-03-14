

function convalidaForm() {
    var nome = document.getElementById("nomeStadio").value;
    var capienza=parseInt(document.getElementById("capienza").value);

    var prezzo = parseFloat(document.getElementById("prezzo").value);
    console.log(typeof prezzo);

    var capienzaNumber=0;
    if(nome.length==0){
        document.getElementById("nomeStadio").focus();
        alert("inserisci il nome");
    }

    else if(capienza<=0){
        document.getElementById("capienza").focus();
         alert("Capienza incoretta");

    }
    else if(prezzo<=0){
        document.getElementById("prezzo").focus();
        alert("prezzo incorretto");
    }
    else {
        document.form.action("inserisciStadio");
        document.form.submit();
    }

}