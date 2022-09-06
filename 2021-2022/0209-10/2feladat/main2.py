from random import *
from xmlrpc.client import boolean

ih = 0
szamok = []

def prime(szam: int) -> boolean:
    osztok = 0
    for a in range(szam):
        if szam%(a+1) == 0:
            osztok += 1
    return osztok == 2

for a in range(10):
    randomszam = randint(10, 99)
    szamok.append(randomszam)
print("Random szamok:", *szamok)

for b in range(10):
    print(szamok[b], prime(szam=szamok[b]))

for c in range(10):
    if prime(szam=szamok[c]) == True:
        print("A listaban van primszam")
        break
    else:
        ih += 1
if ih == 10:
    print("A listaban nincs primszam")