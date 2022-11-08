osszeseredmeny = []
f1 = open("0407/ub2017egyeni.txt", "r", encoding="utf8()")
f1.readline()
elsofel = 0
fnev = ""
h = 0 #hamis adatok
hossz = 0
for i in f1:
    hossz += 1
f1.seek(0)
f1.readline()
mp = 0
ido = []

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
        self.Versenyido = adatok[3]
        self.tavSzazalek = adatok[4]
        
for a in f1:
    egyeredmeny = eredmeny(a.strip())
    osszeseredmeny.append(egyeredmeny)
    
print(f"A listában {len(osszeseredmeny)} eredmény van.")

f1.seek(0)
f1.readline()

for b in f1:
    egyeredmeny = eredmeny(b.strip())
    if egyeredmeny.kategoria == "Noi" and int(egyeredmeny.tavSzazalek) == 100:
        elsofel += 1
print(f"{elsofel} db noi sportolo teljesítette a táv 100% at.")

f1.seek(0)
f1.readline()



fnev = input("Addja meg a keresett jatekos nevet: ")

for c in f1:
    egyeredmeny = eredmeny(c.strip())
    if fnev == egyeredmeny.Nev:
        if int(egyeredmeny.tavSzazalek) == 100:
            print(f"{fnev} szerepel a fileban és teljesitette a 100%ot.")
        else:
            print(f"{fnev} szerepel a fileban, de nem teljesitette a 100%ot.")
    else:
        h += 1
if h == hossz:
    print(f"{fnev} nem szerepl a fileban.")

f1.seek(0)
f1.readline()

mp = 0

def idoOraban(elso: int, masodik: int, harmadik: int):
    return (elso * 3600 + masodik * 60 + harmadik) / 3600

for d in f1:
    egyeredmeny = eredmeny(d.strip())
    ido = egyeredmeny.Versenyido.split(":")
    print(f"{egyeredmeny.Nev}: {idoOraban(int(ido[0]), int(ido[1]), int(ido[2]))} óra.")

