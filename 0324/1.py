#kutya osztaly letrehozas

class kutya:
    neve: str
    fajta: str
    szulido: int

    def __init__(self, nev:str, fajta: str, szulido: int) -> None:
        pass
        self.neve = nev
        self.fajta = fajta
        self.szulido = szulido
    
    def ugat(self):
        print("Vau vau...")

enKutyam = kutya("Léna", "Labrador", 2020)

print(f"A kutyam: {2022 - enKutyam.szulido} eves {enKutyam.fajta} fajta és a neve: {enKutyam.neve}")
enKutyam.ugat()