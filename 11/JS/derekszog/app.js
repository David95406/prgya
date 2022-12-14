function derekszogu() {
    let a = parseInt(document.getElementById("aOldal").value)
    let b = parseInt(document.getElementById("bOldal").value)
    let c = parseInt(document.getElementById("cOldal").value)

    if ((a * a) + (b * b) == (c * c)) {
        alert("Ez egy derékszögű háromszög")
    } else {
        alert("Ez nem derékszögű háromszög")
    }
}

function atvaltas() {
    let m = parseInt(document.getElementById("fSzam").value)

    document.write(m + " méter egyenlő:" + '<br>')
    document.write(m * 3.280839895 + "ft" + '<br>')
    document.write(m * 0.00062137 + " mile" + '<br>')
    document.write(m / 1000 + " km" + '<br>')
    document.write(m * 1.0936133 + " yard" + '<br>')
    document.write(m * 39.3700787 + " inch" + '<br>')
}

function mpToHMS() {
    let fMp = parseInt(document.getElementById("fMp").value)

    let sec = fMp
    let hour = Math.floor(sec / 3600)
    sec = sec % 3600
    let min = Math.floor(sec / 60)
    sec = sec % 60
    document.write(hour + "-" + min + "-" + sec)
}

