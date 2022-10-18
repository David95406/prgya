from cmath import sqrt

a = float(input("a "))
b = float(input("b "))

def pita(a:float, b:float) -> float:
    c: float
    c = pow(a, 2) + pow(b, 2)
    return sqrt(c)

print("A háromszög c oldala: ", pita(a, b))