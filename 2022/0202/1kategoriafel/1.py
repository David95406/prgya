"""
1. feladat:
Kérjen be a program 2 számot, és írja ki, hogy melyik nagyobb, melyik kisebb. Azt is írja ki, ha egyenlőek.
a = int(input("Addjon meg egy számot! "))
b = int(input("Addjon meg egy számot! "))
"""
a = int(input("Addjon meg egy számot! "))
b = int(input("Addjon meg egy számom! "))
if a > b:
    print("Az első szám nagyobb a második számnál. ", a, ">", b)
elif a < b:
    print("Az első szám kisebb a másodiok számnál. ", a, "<", b)
elif a == b:
    print("Az két szám egyenlő.", a, "=", b)
if a == b:
    print("A két szám egyenlő. ")
else:
    print("A legnagyobb szám: ", max(a, b))
    print("A legkisebb szám: ", min(a, b))