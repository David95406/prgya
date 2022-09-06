a = int(input("szam$"))

def kettoharom():
    if a % 2 == 0 and a % 3 == 0:
        return True
    return False   
print(kettoharom())