from xmlrpc.client import boolean


liszt = [23,32,40,42,21,22]

def kozott(lista) -> boolean:
    x = 0
    for a in lista:
        if a > 20 and a < 50:
            x += 1
    if x == 6:
        return True
    return False

print(kozott(liszt))