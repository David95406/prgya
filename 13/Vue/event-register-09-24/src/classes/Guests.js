/*
"name": nameInput.value,
            "email": emailInput.value,
            "password": passwordInput.value,
            "pet": {
                "name": petNameInput.value,
                "isPet": isPetInput.value
            }
*/

export class Guest {
    #name
    #email
    #pet

    constructor(name, email, pet) {
        this.setName(name)
        this.setEmail(email)
        this.setPet(pet)
    }

    setName(name) {
        this.#name = name;
    }

    setEmail(email) {
        this.#email = email;
    }

    getName() {
        return this.#name;
    }

    getEmail() {
        return this.#email;
    }
}