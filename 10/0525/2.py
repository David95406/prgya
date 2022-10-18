from xmlrpc.client import boolean


a = int(input("a$"))
b = int(input("d$"))
c = int(input("c$"))
def haromszoge(a:int, b:int, c:int):
    if (a + b) > c and (a + c) > b and (c + b) > a:
        return True
    return False