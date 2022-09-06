nobel = []
gb = 0
f1 = open("0512/orvosi_nobeldijak.txt", "r", encoding="utf8()")
f1.readline()
for i in f1:
    nobel.append(i.strip().split(";"))

#angolok GB
print("Hány angol van?")
for a in range(len(nobel)):
    if nobel[a][3] == "GB":
        gb += 1
print(gb,"\n\n\n")
#1910 elott
print("Nevek akik 1910 elott kaptak nobelt:")   
for b in range(len(nobel)):
    if int(nobel[b][0]) < 1905:
        print(nobel[b][1])
#kezdobetu a
print("A-val nevek:\n\n\n")
for c in range(len(nobel)):
    if nobel[c][1] == "A":
        print(nobel[c])
#még élnek
print("Azok akik még élnek:\n\n\n")
for d in range(len(nobel)):
    if nobel[d][2].split("-")[1] == "":
        print(nobel[d][1], (1990 - int(nobel[d][2].split("-")[0])), "éves")