szam1 = int(input("$"))
szam2 = int(input("$"))

def szamok(a:int, b:int):
    x = 0
    if (b - a) >= 2:
        for i in range(a + 1, b):
            x = x + i
        return x
    else:
        return "Nincsen megoldas"
        
print(szamok(szam1, szam2))