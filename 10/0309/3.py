szo = input("Addjon meg egy szót! ")

def csillag(a: str):
    for i in range(len(a)):
        print("*", end="")
        
csillag(szo)