var date = new Date(8640000000000000)
var regen = new Date()

console.log(date)

let i = 8640000000000000
do {
    date = new Date(i)
    i++
} while (date != "Invalid Date")

console.log(i)

var datum = new Date(8640000000000000)
console.log("maximum datum: " + datum)