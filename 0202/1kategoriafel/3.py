"""
3. feladat:
Kérd be egy háromszög oldalait, majd számold ki a kerületét, és az alábbi képlettel a területét is:
s = Kerület/2
Terület = Gyök(s * (s-a) * (s-b) * (s-c))
"""
from math import *
a = int(input("Addja meg a háromszög egyik oldalát! (cm) "))
b = int(input("Addja meg a háromszög egyik oldalát! (cm) "))
c = int(input("Addja meg a háromszög egyik oldalát! (cm) "))
K = a + b + c
print("A háromszög kerülete: ", K, "cm")
s = K / 2
T = sqrt(s * (s - a) * (s - b) * (s - c))
print("A háromszög területe: ", T, "cm^")