osszeredmeny = []
f1 = open("0421/meccs.txt", "r", encoding="utf8()")
f1.readline()
class focimeccs:
    fordulo: int
    hfordulo: int
    vfordulo: int
    hfelidogol: int    
    vfelidogol: int
    hcsapat: str
    vcsapat: str
    
    def __init__(self, sor: str) -> None:   
        adatok = sor.strip().split(" ")
        self.fordulo = int(adatok[1])
        self.hfordulo = int(adatok[1])
        self.vfordulo = int(adatok[2])
        self.hfelidogol = int(adatok[3])
        self.hfelidogol = int(adatok[4])
        self.hcsapat = adatok[5]
        self.vcsapat = adatok[6]
        
for sor in f1:
    egyeredmeny = focimeccs(sor.strip())
    osszeredmeny.append(egyeredmeny)
    
print(f"A lista hossza: {len(osszeredmeny)}")
fszam = int(input("Addja meg a fordulok számát 1 és 20 között."))

for egyEredmeny in osszeredmeny:
    if egyEredmeny.fordulo == fszam:
        print(f"{egyEredmeny.hcsapat} - {egyEredmeny.vcsapat}")