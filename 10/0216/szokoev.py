from xmlrpc.client import boolean


def szev(evsz: int) -> boolean:
    return evsz % 400 == 0 or evsz % 4 == 0 and evsz % 100 != 0

ev = 2010
print(szev(ev))