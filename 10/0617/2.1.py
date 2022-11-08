fszam: int = 1
szamok = []

def minparatlan(lista):
    return min(lista)

while fszam > -1:
    fszam = int(input("$"))
    szamok.append(fszam)
szamok.remove(fszam)

print(f"A lista hossza: {len(szamok)}")

for a in szamok:
    if a % 2 == 0:
        szamok.remove(a)
print(minparatlan(szamok))