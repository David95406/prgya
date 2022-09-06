f1 = open("0324/auto.txt", "r", encoding="utf8()")

class auto:
    marka: str
    evjarat: int
    szin: str

    def __init__(self, marka:str, evjarat: int, szin: str) -> None:
        pass
        self.marka = marka
        self.evjarat = evjarat
        self.szin = szin
        
        
enkocsim = auto(f1.readline(), f1.readline(), f1.readline())

print(enkocsim.evjarat, enkocsim.marka, enkocsim.szin)