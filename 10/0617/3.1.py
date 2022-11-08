autok = 0
buszok = 0
kamion = 0
motor = 0
osszsor = []
f = open("0617/jarmu.txt", "r", encoding="utf8()")

class jarmu:
    type: str
    
    def __init__(self, sor: str) -> None:
        self.type = sor[9]

for sor in f:
    egysor = jarmu(sor)
    osszsor.append(egysor)
f.close()

print(f"Áthaladt járművek száma: {len(osszsor)}")

for a in osszsor:
    if a.type == "B":
        buszok += 1
    if a.type == "K":
        kamion += 1
    if a.type == "M":
        motor += 1
autok = len(osszsor) - (buszok + kamion + motor)
print(f"Autok szama: {autok}\nBuszok száma: {buszok}\nKamionok száma: {kamion}\nMotorok szama: {motor}")