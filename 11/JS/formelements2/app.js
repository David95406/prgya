function writeAnswer() {
    var autoLista = document.getElementById("cars")
    var autoOption = autoLista.options[autoLista.selectedIndex].value
    var autoText = autoLista.options[autoLista.selectedIndex].text
    document.getElementById("printUA").innerHTML=("Válasz: " + autoText + '<br>' + "Az autó sorszáma: " + autoOption)
    return false
}

function seasons() {
    var evszakList = document.getElementById("evszakok")
}