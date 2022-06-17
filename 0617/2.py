from xmlrpc.client import boolean


fszam = 1
szamok = []

while fszam > -1:
    fszam = int(input("$"))
    szamok.append(fszam)
szamok.remove(fszam)

print(len(szamok))

def minparatlan(szam) -> boolean:
    return szam % 2 != 0

szamok.sort()

for a in range(len(szamok)):
    print()