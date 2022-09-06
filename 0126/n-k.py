a = int(input("szam1$"))
b = int(input("szam2$"))

def inko(a: int, b: int):
    while a != b:
        if a > b:
            a = a - b 
        else:
            b = b - a 
    return a

print(inko(a, b))