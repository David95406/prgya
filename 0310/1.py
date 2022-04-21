golok = []
ossz = 0

with open("0310/golok.txt", "r", encoding="utf8()") as golfile:
    golfile.readline()
    for a in range(5):
        golok.append(int(golfile.readline()))
        
for b in range(len(golok)):
    ossz += golok[b]
   
atlag = ossz / len(golok)

print("Összes gól:", ossz)
print("Átlaga:", atlag)
if ossz <= 2:
    print("A csapat teljesítménye gyenge.")
elif ossz <= 5:
    print("A csapat teljesítménye közepes.")
elif ossz >= 6:
    print("A csapat teljesítménye kiváló.")