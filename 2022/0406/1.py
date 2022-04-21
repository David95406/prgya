f1 = open("0406/orvosi_nobeldijak.txt", "r", encoding="utf8()")
f1.readline()
nobelszam = 0
magyarnobel = 0
evszamok = []
nevek = []
halalok = []
nevek2 = []

class orvosi_nobel:
    ev: int
    nev: str
    szulhal: str
    orszagkod: str
    
    
    
    def __init__(self, sor: str) -> None:
        adatok = sor.split(";")
        self.ev = int(adatok[0])
        self.nev = adatok[1]
        self.szulhal = adatok[2]
        self.orszagkod = adatok[3]
        
#for a in f1:
#    egyorvos = orvosi_nobel(a)
#    print(f"Neve: {egyorvos.nev}")

f1.seek(0)
f1.readline()
print()

for b in f1:    #Hány Nobel dijas van?
    nobelszam += 1
    
print(f"Nobel dijasok szama: {nobelszam}")

f1.seek(0)
f1.readline()
print()

for c in f1:
    adat = orvosi_nobel(c)
    if adat.orszagkod.strip() == "H":
        magyarnobel += 1
print(f"Magyar Nobel dijasok szama: {magyarnobel}")

f1.seek(0)
f1.readline()
print()

for d in f1:
    adatok = orvosi_nobel(d)
    evszamok.append(adatok.ev)
print(f"A legelso Nobel dij: {min(evszamok)}")

f1.seek(0)
f1.readline()
print()

for e in f1:
    adatok = orvosi_nobel(e)
    nevek.append(adatok.nev)
if "Archibald" in nevek:
    print("Van Archibald nevű ember a fileban.")
else:
    print("Nincs Archibald nevű ember a fileban.")

f1.seek(0)
f1.readline()
print()

for g in f1:
    adatok = orvosi_nobel(g)
    if adatok.szulhal.split("-")[1] != "":
        halalok.append(adatok.szulhal.split("-"))
        nevek2.append(adatok.nev)

for i in range(len(halalok)):
    print(f"{nevek2[i]} meghalt: {int(halalok[i][1]) - int(halalok[i][0])} évesen.")