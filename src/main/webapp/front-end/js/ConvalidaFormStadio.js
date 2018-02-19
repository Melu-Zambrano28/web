

function convalidaForm() {
    var nome = document.getElementById("nomeStadio").value;
    var capienza=document.getElementById("capienza").value;
    if(nome.length==0){
        document.getElementById("nomeStadio").focus();
        alert("inserisci il nome")
    }

    else if(capienza.length==0){


    }
    console.log(nome);


}