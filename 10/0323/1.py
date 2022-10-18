l = open("0323/forras2.txt", "r")
f1 = open("0323/forras2.txt", "r")

def nemoszt3(sor):
    x = 0
    for a in range(len(sor)):
        if int(sor[a]) % 3 != 0:
            x += 1
    if x == len(sor):
        print(*sor)

for b in l:
    nemoszt3(f1.readline().strip().split(";"))