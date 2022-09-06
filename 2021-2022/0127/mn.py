#3. feladat
m = int(input("M$"))
n = int(input("N$"))

def mn(m: int, n: int):
    for a in range(m):
        print("*", end=" ")
        for b in range(n-1):
            print("*", end=" ")
        print("")
mn(m, n)