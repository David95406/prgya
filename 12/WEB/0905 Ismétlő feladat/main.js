const szamlak = []
var minOsszegValue
var maxOsszegValue

function addBill() {
    const szamla = {
        cimzett,
        datum,
        osszeg
    };

    let cimzettInput = document.getElementById("cimzett").value
    let datumInput = document.getElementById("datum").value
    let osszegInput = document.getElementById("osszeg").value

    szamla.cimzett = cimzettInput
    szamla.datum = datumInput
    szamla.osszeg = osszegInput

    szamlak.push(szamla)



    var sor = document.createElement('li')
    sor.classList.add('list-group-item')
    sor.classList.add('billsx0')
    sor.innerText = cimzettInput + " " + datumInput + " " + osszegInput
    //sor.setAttribute("onclick", "this.remove()")       nem jo
    document.getElementById("osszegzes").appendChild(sor)

    //teljes + atlag
    teljesOsszeg = document.getElementById("teljesOsszeg")
    atlagOsszeg = document.getElementById("atlagOsszeg")

    let teljesOsszegValue = 0

    for (let i = 0; i < szamlak.length; i++) {
        teljesOsszegValue += parseInt(szamlak[i].osszeg)
    }
    let atlagOsszegValue = teljesOsszegValue / szamlak.length

    teljesOsszeg.innerHTML = "Összeg: " + teljesOsszegValue
    atlagOsszeg.innerHTML = "Átlag: " + atlagOsszegValue

    //min max
    var minOsszeg = document.getElementById("minOsszeg")
    var maxOsszeg = document.getElementById("maxOsszeg")

    if (szamlak.length == 1) {
        minOsszegValue = szamla.osszeg
        maxOsszegValue = szamla.osszeg
        document.getElementById("minOsszeg").innerHTML = "Legkisebb összeg: " + minOsszegValue
        document.getElementById("maxOsszeg").innerHTML = "Legnagyobb összeg: " + maxOsszegValue
    }

    if (minOsszegValue > parseInt(szamla.osszeg)) {
        minOsszegValue = szamla.osszeg
        minOsszeg.innerHTML = "Legkisebb összeg: " + minOsszegValue
    }
    if (maxOsszegValue < parseInt(szamla.osszeg)) {
        maxOsszegValue = szamla.osszeg
        maxOsszeg.innerHTML = "Legnagyobb összeg: " + maxOsszegValue
    }

    //torles gomb

}

function search_bills() {
    let sor = document.getElementById('searchbar').value
    sor = sor.toLowerCase();
    let x = document.getElementsByClassName('bills');

    for (i = 0; i < x.length; i++) {
        if (!x[i].innerHTML.toLowerCase().includes(sor)) {
            x[i].style.display = "none";
        }
        else {
            x[i].style.display = "list-item";
        }
    }
}