from math import *
szorszo = 0
eredmeny = 0
for i in range(1000):
    eredmeny = eredmeny + pow(1/2, i)
    print(f"[{i}]", format(eredmeny, ".52f"))