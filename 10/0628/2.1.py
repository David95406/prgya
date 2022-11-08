from xmlrpc.client import boolean
ih = []

liszt = [23,32,40,42,21,22]

def kozott(szam: int) -> boolean:
    return szam > 20 and szam < 50

for i in liszt:
    if kozott(i):
        ih.append(True)

if len(ih) == 6:
    print("Minden szam jo")
else:
    print("nem jo")