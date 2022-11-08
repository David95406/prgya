szam = ""
szamok = []
for a in range(3):
    szo = str(input("Addjon meg harom szamot! "))
    szamok.append(szo)
szamok.sort()
print("A legnagyobb szam: ", max(szamok),"\nA legkisebb szam: ", min(szamok), "\nA közespő szam: ", szamok[1])