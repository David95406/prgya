from xmlrpc.client import boolean


fszam = 1
szamok = []
paratlanok = []

def minparatlan(lista):
    return min(lista)

while fszam > -1:
    fszam = int(input("$"))
    if fszam % 2 != 0:
        paratlanok.append(fszam)
    szamok.append(fszam)
szamok.remove(fszam)
paratlanok.remove(fszam)

print("\n\n")
print(f"A lista hossza: {len(szamok)}")

paratlanok.sort()

print(paratlanok[-1])
print(minparatlan(paratlanok))