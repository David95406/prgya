from xmlrpc.client import boolean

print("Addjon meg három egész számot!")
szam1 = int(input("$"))
szam2 = int(input("$"))
szam3 = int(input("$"))

def paros(a:int, b:int, c:int) -> boolean:
    if a > 0 and b > 0 and c > 0:
        return True
    return False

if paros(szam1, szam2, szam3) == True:
    print("Aktuális paraméternek a függvény behivatkozásakor, a függvény zárójelébe írt paraméter, pl.: függvény neve(ide kell az aktuális paraméter)")
else:
    print("A függvény fej részei: def függvény neve(formális paraméterek) -> visszatérési érték:")