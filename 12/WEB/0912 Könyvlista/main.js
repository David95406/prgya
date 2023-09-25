const konyvek = []
var minOsszegValue
var maxOsszegValue

function clearForm() {
    document.getElementById("cim").value = null
    document.getElementById("szerzo").value = null
    document.getElementById("rDate").value = null
}

function addBook() {
    const konyv = {
        cim,
        szerzo,
        kiadasiEv
    };

    var cimInput = document.getElementById("cim").value
    var szerzoInput = document.getElementById("szerzo").value
    var kiadasiEv = document.getElementById("rDate").value

    konyv.cim = cimInput
    konyv.szerzo = szerzoInput
    konyv.kiadasiEv = kiadasiEv

    konyvek.push(konyv)
    clearForm()



    var sor = document.createElement('li')
    sor.classList.add('list-group-item')
    sor.classList.add('books')
    sor.innerText = cimInput + " " + szerzoInput + " " + kiadasiEv
    //sor.setAttribute("onclick", "this.remove()")       nem jo
    document.getElementById("osszegzes").appendChild(sor)
}

function searchBooks() {
    let input = document.getElementById('searchbar').value
    input = input.toLowerCase();
    let x = document.getElementsByClassName('books');

    for (i = 0; i < x.length; i++) {
        if (!x[i].innerHTML.toLowerCase().includes(input)) {
            x[i].style.display = "none";
        }
        else {
            x[i].style.display = "list-item";
        }
    }
}