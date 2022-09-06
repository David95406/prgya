sorok = []

file1 = open("0303/file1.txt", "r", encoding="utf8()") 

for e in file1:
    sorok.append(e.strip())

print(sorok)

file1.close()

#2ver

file2 = open("0303/file1.txt", "r", encoding="utf8()")

nev1 = file2.readline().strip()
nev2 = file2.readline().strip()
nev3 = file2.readline().strip()

print("\n\nver2")

print(nev1, nev2, nev3)

file2.close()

#3

szamok = []
file3 = open("0303/szamok.txt", "r", encoding="utf8()") 

for a in file3:
    szamok.append(int(a))
    
print(szamok)