hossz = open("adatok.txt", "r")
# Írasd ki az összes sort
f1 = open("adatok.txt", "r")
for a in hossz:
    print(f"Sor: {f1.readline()}", end="")
print()
f1.seek(0,0)
# Olvasd be a fájl első sorát, amely megadja, hogy összesen hány adatsor van.
osszsor = f1.readline()    
print(f"Sorok száma: {osszsor}", end="")
# Írasd ki egy sorokszama.txt fájlba a sorok számát. 
f2 = open("sorokszama.txt", "w")
f2.write(osszsor)
# Írasd ki külön az adatsorokat és külön az összes sorok számát.
hossz.seek(0,0)
hossz.readline()
for b in hossz:
    print(f"Sorok szama a masodik sortol: {f1.readline()}", end="")
# a sorokban levő 3 szám szorzatát írd ki. Csak az adatsorokkal dolgozz!
f1.seek(0,0)
hossz.seek(0,0)
f1.readline()
hossz.readline()
print()
for c in hossz:
    szamok = f1.readline().strip().split(";")
    print(f"Szorzat: {int(szamok[0]) * int(szamok[1]) * int(szamok[2])}")