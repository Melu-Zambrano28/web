var json;
var listaPartite;
var sur;


function tabellario(listaPartite) {
    //"use strict";
    var c = document.getElementById("tabella");
    if( c !== null) {
        c.remove();
    }
    var body = document.getElementById("demo");
    var tbl = document.createElement("table");
    var tblBody = document.createElement("tbody");
    var squadra_home = document.createElement("th");
    var squadra_home_title = document.createTextNode("Squadra A");
    squadra_home.appendChild(squadra_home_title);
    var squadra_visitor = document.createElement("th");
    var squadra_visitor_title = document.createTextNode("Squadra B");
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
        var nome3 = document.createTextNode(this.listaPartite[z].data_partita.dayOfMonth + "/" + this.listaPartite[z].data_partita.month +
            "/" + this.listaPartite[z].data_partita.year + "  " + this.listaPartite[z].data_partita.hourOfDay + ":" + this.listaPartite[z].data_partita.minute);
        campo3.appendChild(nome3);
        var campo4 = document.createElement("td");
        var nome4 = document.createTextNode(this.listaPartite[z].stadio.nome);
        campo4.appendChild(nome4);
        var checky = document.createElement("INPUT");
        checky.setAttribute("type", "radio");
        checky.value = listaPartite[z].id;
        //Se i radio button non hanno lo stesso nome i radio rimangono selezionati.
        checky.name = "comune";
        checky.className = "radioStyle";
        row.appendChild(campo1);
        row.appendChild(campo2);
        row.appendChild(campo3);
        row.appendChild(campo4);
        row.appendChild(checky);
        tblBody.appendChild(row);
    }
    tbl.appendChild(tblBody);
    tbl.setAttribute("border", 4);
    tbl.id = "tabella";
    tbl.className = "center";
    body.appendChild(tbl);
}


function loadTable() {
    "use strict";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            json = this.responseText;
            listaPartite = JSON.parse(json);
            // document.getElementById("demo").innerHTML =
            //     this.responseText;
            tabellario(listaPartite);
            document.getElementById("btn-ajax").style.display = "none";
        }
    };
    xhttp.open("GET", "/ajaxPartita", true);
    xhttp.send();
}


function invio_scelta() {
    "use strict";
    var up = document.getElementsByTagName("select");
    var sur = up.selezione.value;
    var ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            //console.log(sur);
            json = this.responseText;
            listaPartite = JSON.parse(json);
            //setInterval(3000);
            tabellario(listaPartite);
        }
    };
    ajax.open("POST", "/ajaxPartita?ordinePartite=" + sur, true);
    ajax.send();
}

function mostraAvanti() {

    "use strict";
    document.getElementById("");

}


var select_ricerca = document.querySelector('select[name="selezione"]');
select_ricerca.addEventListener("change", invio_scelta);

var radio_yes = document.getElementsByClassName("radioStyle");
for(var u = 0; u < radio_yes.length; u++) {
    radio_yes[u].addEventListener("click", mostraAvanti);
}


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