f = open("0617/jarmu.txt", "r", encoding="utf8()")
jarmu = []

for sor in f:
    jarmu.append(sor)
f.close()
autok = 0
buszok = 0
kamion = 0
motor = 0
print(f"Áthaladt járművek száma: {len(jarmu)}")
for a in jarmu:
    if a[9] == "B":
        buszok += 1
    if a[9] == "K":
        kamion += 1
    if a[9] == "M":
        motor += 1
autok = len(jarmu) - (buszok + kamion + motor)
print(f"Autok szama: {autok}\nBuszok száma: {buszok}\nKamionok száma: {kamion}\nMotorok szama: {motor}")