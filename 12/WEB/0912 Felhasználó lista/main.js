const users = []

function clearForm() {
    document.getElementById("nev").value = null
    document.getElementById("kor").value = null
}

function addUser() {
    const user = {
        nev,
        kor
    };

    var nevInput = document.getElementById("nev").value
    var korInput = document.getElementById("kor").value

    user.cim = nevInput
    user.szerzo = korInput

    if (parseInt(korInput) < 0) {
        alert("Érvényes életkort adjon meg!")
    } else {
        users.push(user)
        clearForm()
        var sor = document.createElement('li')
        sor.classList.add('list-group-item')
        sor.classList.add('users')
        sor.innerText = nevInput + " " + korInput
        //sor.setAttribute("onclick", "this.remove()")       nem jo
        document.getElementById("osszegzes").appendChild(sor)
    }

}

function searchUsers() {
    let input = document.getElementById('searchbar').value
    input = input.toLowerCase();
    let x = document.getElementsByClassName('users');

    for (i = 0; i < x.length; i++) {
        if (!x[i].innerHTML.toLowerCase().includes(input)) {
            x[i].style.display = "none";
        }
        else {
            x[i].style.display = "list-item-none"; //! -none
        }
    }

    
}