#kutya osztaly letrehozasa
class Kutya:
    nev: str
    fajta:str
    szulido: int

    def __init(self,neve:str,fajtaja:str,szulideje:int) -> None:
        self.nev = "Bodri"
        self.fajta = fajtaja
        self.szulido= szulideje

#kutya osztalyu objektumok letrehozasa -> 1 konkret kutya
enkutyam = Kutya("Bodri","puli",2020)
print("kutyam nev",enkutyam.nev)
print("Kora:",2022-enkutyam.szulido)
