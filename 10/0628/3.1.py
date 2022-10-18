from Epuletek import epuletek


f1 = open("0628/epuletek.txt", "r", encoding="utf8()")
f1.readline()
osszeredmeny = []
talalatok = []
abc = "aábcdeéfghiíj"

for sor in f1:
    egyeredmeny = epuletek(sor.strip())
    osszeredmeny.append(egyeredmeny)
f1.close()

print("Találatok:")
emeletek = 0
for a in osszeredmeny:
    if int(a.magassag) > 150 and a.nev[0] in abc.upper():
        print(a.nev)
        emeletek += a.emelet
print("\n\nEmeletek osszege: ", emeletek)