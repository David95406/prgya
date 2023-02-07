function vizsgal() {
    var username = document.getElementById("username").value;
    document.getElementById("printUsername").innerHTML = username;
}

function emailValid() {
    var email = document.getElementById("email").value

    if (email.length > 4 && email.includes('@') && email.includes('.')) {
        document.getElementById("printEmailIfValid").innerHTML = "Megfelelo formatum."
    } else {
        document.getElementById("printEmailIfValid").innerHTML = "Hibas formatum"
    }

    //regex
    var regex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    console.log(regex.test(email) && email.length >= 5)
}