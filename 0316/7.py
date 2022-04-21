kerdes = input("$")
szavak = ""
with open("0316/mondat.txt", "w", encoding="utf8()") as mondatf:
    mondatf.write(kerdes)

with open("0316/mondat.txt", "r", encoding="utf8()") as f2:
    szavak = f2.read().split()
    for a in range(len(szavak)):
        if a % 2 != 0:
            print(szavak[a])
            f2.write(szavak[a] + " ")