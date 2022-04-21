from xmlrpc.client import boolean

evek = []
koz = []
kozott = 0
evappend = 0
ih = []

def szev(evsz: int) -> boolean:
    return evsz % 400 == 0 or evsz % 4 == 0 and evsz % 100 != 0

ev1 = int(input("tol"))
ev2 = int(input("ig"))
kozott = ev2 - ev1
evappend = ev1

for a in range(kozott):
    evappend += 1
    evek.append(evappend)

for b in range(len(evek)):
    ih.append(szev(evek[b]))

if True in ih:
    print("Van szökőév a kettő között")
else:
    print("nincs szokoev")