lista = []
haromsor = []
f1 = open("0330/haromszogek.txt", "r")
print(f1.read())
f1.seek(0,0)
lista.append(f1.readline())
print(lista)
f1.seek(0,0)
print("\n\n")
f1.readline()
print(f1.readline())
haromsor = f1.readline().split() #3.sor valtozoba adatai
print(haromsor)
print(haromsor[1])
f2 = open("0330/ki.txt", "w")
f2.write(haromsor[1])
f1.seek(0,0)
print("\n\n")
for a in range(4):
    print(f1.readline())