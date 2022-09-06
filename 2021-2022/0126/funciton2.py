"""
Függvény: Névvel ellátott adott feladatot elvégző utasítások sorozata.
A függvényt használat elott definiálni kell. 
Formaja: 1 Fuggvenyfej: def fuggveny_neve(formalis_parameterlista) --> fuggveny_visszateresi ertekenek a tipusa:
2: A függveny torzs leirasa:
tetszoleges szamu utasitas, legalabb egy return utasitas (gyakran az utolso utasitas)
"""
def osszead(a: int, b: int) -> int:     #a fuggveny feje
    """
    def => fügvény definiciot bevezeto kulcsszo
    osszead => a fuggveny neve
    () -> operatorok a parameterek megadasara
    a: int, b: int => fuggveny formalis parameterei azonositoval es tipussal (tipus opcionalis)
    -> == fuggveny visszateresi erteket ezutan az "operator" utan adhatjuk meg (opcionalis)
    int => fuggveny visszateresi ertekenek a tipusa
    """
    c = a + b 
    return c #Fuggveny torzs
"""
Fuggveny hivasa:
A hivas syntaxisa :
Fuggveny azonositoja(aktualis parameterlista)
"""
osszead(3, 4) #A fuggveny visszateresi erteket a kepernyore irjuk
print(osszead(3, 4)) #A fuggveny visszateresi erteket a kepernyore irjuk
osszeg = int = osszead(3, 4) #A fuggveny visszateresi erteket eltaroljuk
print(osszeg)