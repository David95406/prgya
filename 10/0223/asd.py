from xmlrpc.client import boolean


def anyad(adat) -> boolean:
    return adat < 100 and adat > 0 and adat % 3 == 0 and adat % 2 == 0

szam = ""

while szam != 0:
    szam = int(input("$"))