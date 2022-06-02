from math import *
szorszo = 0
eredmeny = 0
for i in range(100000):
    eredmeny = eredmeny + pow(1/(i+1), i)
    print(f"[{i}]", format(eredmeny, ".100f"))