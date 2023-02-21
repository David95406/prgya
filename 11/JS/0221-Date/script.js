var date = new Date()

console.log(date.getMilliseconds()) //csak a milliseconds irja ki
console.log(date.getTime()) //teljes ido milliseconds-ban
console.log(date.getDay())

let napok = ["Vasárnap", "Hetfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat"]

console.log(napok[date.getDay()])