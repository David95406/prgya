playlist = open("0324/szorgalmi/playlist.csv", "r", encoding="utf8()")
l = open("0324/szorgalmi/playlist.csv", "r", encoding="utf8()")
dragons = open("0324/szorgalmi/dragons.txt", "w", encoding="utf8()")
hossz = []
zenek = playlist.read()
playlist.seek(0,0)
psor = ""
ossz = 0

def fr(sor):
    if sor.split(";")[0] == "Imagine Dragons":
        dragons.write(sor)
        dragons.write("")

def ih(sor):
    return sor.split(";")[0] == "Imagine Dragons"

def hsz(csv):
    hossz.append(csv.strip().split(";")[-1])

def lh():
    return 

for a in l:
    psor = playlist.readline()
    fr(psor)
    print(ih(psor))
    hsz(psor)
    for b in range(len(hossz)):
        ossz += int(hossz[b])
    
print("\n\n")
h = max(hossz)
print(lh(zenek))

print(hossz)
print(f"összes: {ossz} mp")