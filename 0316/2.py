from random import *

szam = 0

with open("0316/write.txt", "w") as f1:
    for a in range(444):
        szam = randint(1, 444)
        szam = str(szam) + "\n"
        f1.write(str(szam))
    print("kesz")
    
with open("0316\write.txt", "r") as f2:
    print(f2.read())