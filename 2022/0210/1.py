mghdb = 0
mondat = input("Irjon be egy mondatot! ")

def mh(nap: str) -> int:
    db:int = 0
    mgh ="aáeéiíoóüűöőuú"
    for a in range(len(nap)):
        if nap[a] in mgh:
            db += 1
    return db
mghdb += mh(mondat)

print("A maganhangzok db: ", mghdb) 