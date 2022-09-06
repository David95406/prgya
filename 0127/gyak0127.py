list1 = []

def Max(list1):
    max = list1[0]
    for x in list1:
        if x > max :
             max = x      
    return max

def poz(list1):
    if list1[0] % 2 == 0 and list1[1] % 2 == 0 and list1[2] % 2 == 0:
        return True
    else:
        return False

for i in range(3):
    szam = int(input("Addj meg egy számot! "))
    list1.append(szam)

m = int(input("M$"))
n = int(input("N$"))

def mn(m: int, n: int):
    for a in range(m):
        print("*", end=" ")
        for b in range(n-1):
            print("*", end=" ")
        print("")


print("A legnagyobb szám: ", Max(list1))
print("Az összes felsorol szám páros: ", poz(list1))
mn(m, n)