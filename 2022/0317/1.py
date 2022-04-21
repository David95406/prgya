f1 = open("0317/haromszog.txt", "r")
f1.readline()
f2 = open("0317/haromszog.txt", "r")
f2.readline()

def haromszoge(a:int, b:int, c:int):
    return a + b > c and a + c > b and c + b > a

def haromoszt(a:int, b:int, c:int):
    if a % 3 != 0 and b % 3 != 0 and c % 3 != 0:
        print(a, b, c)
        return True
    return False

abc = f2.readline().split()
for a in f1:
    print(f"Lehet háromszög? {haromszoge(int(abc[0]), int(abc[1]), int(abc[2]))}")
    print(f"Nincs 3-mal oszthato szam {haromoszt(int(abc[0]), int(abc[1]), int(abc[2]))}\n")
    abc = f2.readline().split()