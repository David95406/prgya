from xmlrpc.client import boolean


def szev(evsz: int) -> boolean:
    return evsz % 400 == 0 or evsz % 4 == 0 and evsz % 100 != 0

ev1 = int(input("$"))
ev2 = int(input("$"))

