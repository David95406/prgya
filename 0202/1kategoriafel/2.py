"""
2. feladat:
Kérd be egy háromszög oldalait, majd határozd meg és írd ki, hogy a háromszög megszerkeszthető-e! 
(A háromszög akkor megszerkeszthető, ha bármely két oldalának az összege nagyobb mint a harmadik oldal.)
"""
a = int(input("Addja meg a háromszög egyik oldalát! "))
b = int(input("Addja meg a háromszög egyik oldalát! "))
c = int(input("Addja meg a háromszög egyik oldalát! "))
if a < b + c and b < a + c and c < a + b:
    print("A háromszög megszerkezthető")
else:
    print("A háromszög nem megszerkezhető")