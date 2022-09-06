from xmlrpc.client import boolean

szam = int(input("$"))

def kiir(a: int()) -> boolean:
    for i in range(a):
        print("Hello world!")
    return a % 2 == 0
        
print(kiir(szam))