const kalkulatorForm = document.getElementById("kalkulatorForm")

kalkulatorForm.onsubmit((event) => {
    event.preventDefault()
    const eletkorInput = document.getElementById("eletkorInput")
    const magassagInput = document.getElementById("magassagInput")
    //const nemInput = document.getElementById("nemInput")
    //const aktivitasInput = document.getElementById("aktivitasInput")

    alert(magassagInput.value)
})