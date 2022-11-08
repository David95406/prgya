from random import  *

szamok = []

def fel1(a: int):
    for i in range(a):
        szamok.append(randint(1, 100))
    print(szamok)
    
fel1(44)