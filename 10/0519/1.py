from math import *
from xmlrpc.client import boolean
# OSZTÁLY:
hsz = []
f1 = open("0519/haromszog.txt", "r")
f1.readline()

class Haromszog:
    a: int
    b: int
    c: int
    
    # konstruktor
    def __init__(self, sorom) -> None:
        self.a = int(sorom[0])
        self.b = int(sorom[1])
        self.c = int(sorom[2])    
        
    # osztály metódusa: szöveggel visszatérve megmondja, hogy a számok háromszöget alkotnak-e    
    def haromszoge(self) -> str:
        if self.a<self.b+self.c and self.b<self.a+self.c and self.c<self.a+self.b:
            return "Háromszöget alkotnak"
        else:
            return "Nem alkotnak háromszöget."
    
    # osztály metódusa: egész számként visszaadja a háromszög kerületét
    def kerulet(self):
        return self.a + self.b + self.c
    
    def derekszoge(self):
        if pow(self.a,2) + pow(self.b,2) == pow(self.c,2):
            return True
        return False

    def vane(self, szam) -> boolean:
        return self.a == szam or self.b == szam or self.c == szam

for i in f1:
    hsz.append(i.strip().split("*"))

for sor in hsz:
    egyhsz = Haromszog(sor)
    print(egyhsz.haromszoge())
 
hszf = []#haromszogfelhasznalolistacucc   
print("Addja meg a haromszog 3 oldalát.")
for b in range(3):
    hszf.append(int(input("$")))
egyharomszog = Haromszog(hszf)
print(egyharomszog.haromszoge())
print(f"Ez a háromszög derékszögű? {egyharomszog.derekszoge()}")
fszam = int(input("Addjom meg egy számot! "))
print(f"A megadott szám szerepel? {egyharomszog.vane(fszam)}")