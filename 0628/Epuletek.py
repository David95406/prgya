class epuletek:
    nev: str
    varos: str
    orszag: str
    magassag: int
    emelet: int
    epult: int
    
    def __init__(self, sor: str) -> None:
        adatok = sor.split(";")
        self.nev = adatok[0]
        self.varos = adatok[1]
        self.orszag = adatok[2]
        self.magassag = adatok[3].split(",")[0]
        self.emelet = int(adatok[4])
        self.epult = adatok[5]