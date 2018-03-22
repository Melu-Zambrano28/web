var json;
var listaPartite;
var sur;
var certoStadio;


function tabellario(listaPartite) {
    //"use strict";
    var c = document.getElementById("tabella");
    var d = document.getElementById("formo");
    if (c !== null && d !== null) {
        c.remove();
        d.remove();
    }
    var body = document.getElementById("demo");
    var form = document.createElement("FORM");
    var tbl = document.createElement("table");
    var tblBody = document.createElement("tbody");
    var squadra_home = document.createElement("th");
    var squadra_home_title = document.createTextNode("Squadra Home");
    squadra_home.appendChild(squadra_home_title);
    var squadra_visitor = document.createElement("th");
    var squadra_visitor_title = document.createTextNode("Squadra Visitor");
    squadra_visitor.appendChild(squadra_visitor_title);
    var data = document.createElement("th");
    var data_title = document.createTextNode("Data partita");
    data.appendChild(data_title);
    var stadio = document.createElement("th");
    var stadio_title = document.createTextNode("Stadio");
    stadio.appendChild(stadio_title);
    tblBody.appendChild(squadra_home);
    tblBody.appendChild(squadra_visitor);
    tblBody.appendChild(data);
    tblBody.appendChild(stadio);
    for (var z = 0; z < this.listaPartite.length; z++) {
        var row = document.createElement("tr");
        var campo1 = document.createElement("td");
        var nome = document.createTextNode(this.listaPartite[z].squadra_home.nome);
        campo1.appendChild(nome);
        var campo2 = document.createElement("td");
        var nome2 = document.createTextNode(this.listaPartite[z].squadra_visitor.nome);
        campo2.appendChild(nome2);
        var campo3 = document.createElement("td");
        var nome3 = document.createTextNode(this.listaPartite[z].data_partita);
        campo3.appendChild(nome3);
        var campo4 = document.createElement("td");
        var nome4 = document.createTextNode(this.listaPartite[z].stadio.nome);
        campo4.appendChild(nome4);
        var checky = document.createElement("INPUT");
        checky.setAttribute("type", "radio");
        checky.value = listaPartite[z].id;
        //Se i radio button non hanno lo stesso nome i radio rimangono selezionati.
        checky.name = "id-partita";
        checky.className = "radioStyle";
        var data = document.createElement("INPUT");
        data.setAttribute("type", "hidden");
        data.className = "zebra";
        data.value = listaPartite[z].id;
        row.appendChild(campo1);
        row.appendChild(campo2);
        row.appendChild(campo3);
        row.appendChild(campo4);
        row.appendChild(checky);
        row.appendChild(data);
        tblBody.appendChild(row);
    }
    tbl.appendChild(tblBody);
    tbl.setAttribute("border", 4);
    tbl.id = "tabella";
    tbl.className = "center";
    //crea submit button
    var inp = document.createElement("INPUT");
    inp.setAttribute("type", "submit");
    inp.id = "checkout";
    var nome = document.createElement("INPUT");
    nome.setAttribute("type", "hidden");
    nome.name = "nome";
    var cognome = document.createElement("INPUT");
    cognome.setAttribute("type", "hidden");
    cognome.name = "cognome";
    nome.className = "zebra";
    cognome.className = "zebra";
    nome.value = nomeCliente;
    cognome.value = cognomeCliente;
    form.appendChild(nome);
    form.appendChild(cognome);
    inp.value = "Procedi";
    document.createElement("input", "submit");
    //attributi form
    form.id = "formo";
    form.method = "post";
    form.action = "calcolaPrezzo";
    form.appendChild(tbl);
    form.appendChild(inp);
    body.appendChild(form);
}


function loadTable() {
    "use strict";
    var xhttp = new XMLHttpRequest();
    sur = "orario";
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            json = this.responseText;
            listaPartite = JSON.parse(json);
            certoStadio = listaPartite.filter(scemo => scemo.stadio.nome === "Sansiro");
            // document.getElementById("demo").innerHTML =
            //     this.responseText;
            tabellario(certoStadio);
            //document.getElementById("btn-ajax").style.display = "none";
        }
    };
    xhttp.open("POST", "/gestionaleSportivo/ajaxPartita?ordinePartite=" + sur, true);
    xhttp.send();
}

//Metodo richieste info AJAX ad ServletAjaxPartite


function invio_scelta(event) {
    "use strict";
    var up = document.getElementsByTagName("select");
    var sur = up.selezione.value;
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            //console.log(event.target.id);
            json = this.responseText;
            listaPartite = JSON.parse(json);
            tabellario(listaPartite);
            scripter();
        }
    };
    ajax.open("POST", "/gestionaleSportivo/ajaxPartita?ordinePartite=" + sur, true);
    ajax.send();
}


function controlloParti() {
    var count = 0;
    var controllol = document.getElementsByClassName("radioStyle");
    for (var i = 0; i < controllol.length; i++) if (controllol[i].checked == false) {
        count++;
    }
    console.log(count);

}

function scripter() {
    var check_campi = document.getElementById("checkout");
    check_campi.addEventListener("click", controlloParti);
    console.log("CIAO");
}


document.addEventListener("click", function (e) {
    var x = e.target;
    var valore = x.id;
    if (x.id === "acquisto") {
        document.getElementById("partita-stadio").classList.toggle("visibile");
        var c = document.getElementsByTagName("tabella").remove();
        var d = document.getElementById("formo").remove();
    } else if (x.id === "biglietto") {
        document.getElementById("demo").classList.toggle("visibile");
        var c = document.getElementsByTagName("tabella").remove();
        var d = document.getElementById("formo").remove();
    } else if (x.id === "prenotazione") {
        console.log(valore);
    }
});

function filtraStadio(array, nome) {
        return array.nome === nome;
}

function sceltaStadio(listaPartite) {
    loadTable();
}


var select_ricerca = document.querySelector('select[name="selezione"]');
select_ricerca.addEventListener("change", invio_scelta);

var select_stadio = document.getElementById("selezione-stadio");
select_stadio.addEventListener("change", sceltaStadio(listaPartite));

/*
var radio_yes = document.getElementsByClassName("radioStyle");
for (var u = 0; u < radio_yes.length; u++) {
    radio_yes[u].addEventListener("click", mostraAvanti);
} */


/*

var btn_ajax = document.getElementById("btn-ajax");
btn_ajax.addEventListener("click", loadTable);

function jey() {
    //"use script";
    $(document).ready(function() {
        $("#tabella").kendoGrid({
            height: 550,
            sortable: true
        });
    });
}  */