from random import *
szamok = []
for a in range(10):
    randomszam = randint(10, 99)
    szamok.append(randomszam)
print(*szamok)
szam = 5
db = 0
def prime():
    if szam == 2 or szam == 3 or szam == 5 or szam == 7: #ez csak akkor kell, ha a szam nem ketjegyu
        print("A szam primszam")
        return True
    elif szam % 2 == 0 or szam % 3 == 0 or szam % 4 == 0 or szam % 5 == 0 or szam % 6 == 0 or szam % 7 == 0 or szam % 8== 0 or szam % 9 == 0:
        print("A szam nem primszam")
        return False
    else:
        print("A szam primszam")
        return True
for c in range(10):
    prime(c)