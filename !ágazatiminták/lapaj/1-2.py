#1 feladat
from math import *
from random import *
from xmlrpc.client import boolean
print("Addja meg a haromszog ketto befogojat pls. ")
a = int(input("a$"))
b = int(input("b$"))
c = sqrt(pow(a, 2) + pow(b, 2))
print(f"A c = {c}cm")
print(f"A háromszog kerulete: {a + b + c}cm")
print(f"A háromszog terulete: {(a * b) / 2}cm2")
#vege :)
#2 feladat
szamok = []
for i in range(100):
    szamok.append(int(randint(1, 1000)))
vlista = list(set(szamok))

print(len(vlista)) #rm
for a in vlista:
    if a > 100 and a < 200:
        vlista.remove(a)
print(len(vlista)) #rm

""""
def prime(szam: int) -> boolean:
    if szam == 1:
        return False
    x: int
    x = 2
    while szam == x:
        if szam % x == 0:
            return False
        else:
            x += 1
    return True
"""

def prime(szam):
    if szam == 1: # az 1 nem prímszám
        return False
    elif szam == 2: # a 2 prímszám
        return True
    else:
        for x in range(2,szam):
            if szam % x == 0: 
                return False
        return True
for b in vlista:
    print(prime(b))
