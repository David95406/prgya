mghdb = 0
szavak = ["Hétfő", "Kedd", "Szerda", "Csütörtök", "Pétek", "Szombat", "Vasárnap"]
mondat = []
nk = []
maxhely = 0

def mh(nap: str) -> int:
    db:int = 0
    mgh ="aáeéiíoóüűöőuú"
    for a in range(len(nap)):
        if nap[a] in mgh:
            db += 1
    return db

print("Addjon meg harom napot! ")
#for a in range(3):
#    szo = input()
#    mondat.append(szo)

for b in range(len(szavak)):
    mghdb += mh(szavak[b])

for c in range(len(szavak)):
    if mghdb(szavak[c]) > mghdb(szavak[maxhely]):
        maxhely == c
    
print("A maganhangzok db: ", mghdb) #hány mgh van egy adott mondatban
