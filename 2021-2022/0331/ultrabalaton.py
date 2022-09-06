f1 = open("0331/ub2017egyeni.txt", "r")
f1.readline()
noiDb = 0
minSzazalek = 100

class eredmeny:
    nev: str
    Rajtszam: int
    kategoria: str
    ido: str
    tavSzazalek: int
    
    def __init__(self, sor: str) -> None:
        adatok = sor.split(";")
        self.Nev = adatok[0]
        self.Rajtszam = int(adatok[1])
        self.kategoria = adatok[2]
        self.Elertido = adatok[3]
        self.tavSzazalek = adatok[4]

for sor in f1:
    egyAdat = eredmeny(sor)
    print(f"Neve: {egyAdat.Nev} Ideje: {egyAdat.Elertido}")
    if egyAdat.kategoria == "Noi":
        noiDb += 1
    if egyAdat.tavSzazalek < minSzazalek:
        minSzazalek = egyAdat.tavSzazalek

    
print(noiDb) 


f1.seek(0)













f1.close()