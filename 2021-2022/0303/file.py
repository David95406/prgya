sorok = []


with open("0303/file1.txt", "r", encoding="utf8()") as file1:
    for a in range(4):
        sorok.append(file1.readline())
nev1 = sorok[0]
nev2 = sorok[1]
nev3 = sorok[2]
print(sorok)
print(nev1, nev2, nev3)