from random import *
from xmlrpc.client import boolean

r = 0
rszamok = []
osztok = 1

for a in range(5):
    r = randint(10, 99)
    rszamok.append(r)
print(*rszamok)

def prim(szam) -> boolean:
    for b in range(szam):
        if szam %  osztok == 0:
            osztok == b
        else:
            return osztok == 2