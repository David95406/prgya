f1 = open("0518/ub2017egyeni.txt", "r", encoding="utf8()")
f1.readline()
ub = []
for i in f1:
    ub.append(i.strip().split(";"))
#van e zsolt?
ih = False
for a in range(len(ub)):
    if "Zsolt" in ub[a][0]:
        ih = True
if ih == True:
    print("Van Zsolt nevű indulo.")
else:
    print("Nincsen Zsolt nevű indulo.")
#Hány noi indulo van?
no = 0
for b in range(len(ub)):
    if ub[b][2] == "Noi":
        no += 1
print(f"{no} db női játékos van.")
#Átlak százalék
osszes = 0
for c in range(len(ub)):
    osszes += int(ub[c][4])#test.py
print(f"{round(osszes / len(ub))}% az átlag.")
#25 óranal kevesebb
hok = 0
for d in range(len(ub)):
    if ub[d][2] == "Ferfi" and int(ub[d][3].split(":")[0]) < 25:
        hok += 1
print(f"{hok}db férfi futotta le 25 oranal kevesebb ido alatt.")