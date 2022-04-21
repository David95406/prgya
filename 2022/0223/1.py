from xmlrpc.client import boolean

szam = ""
talalatok = []
osszeg = 0

def fel1(adat) -> boolean: #Eldönti egy szamrol, hogy 0 és 100 közötti 3-mal osztható és páros szám-e.
    return adat < 100 and adat > 0 and adat % 3 == 0 and adat % 2 == 0 

while szam != 0: #Addig fut, ameddig a változó értéke nem nulla.
    szam = int(input("Addjon meg egy szamot! ")) #Bekér egy egész számot.
    if fel1(szam) == True: #Megnézi, hogy a függvény igazat ad e az adott számhoz, ha igen, akkor hozzáadja egy listához.
        talalatok.append(szam)

for a in range(len(talalatok)): #Összeadja a lista tartalmát.
    osszeg += talalatok[a]
    
print("\nA program feldolgozott", len(talalatok), "számot.") #Kiírja, hogy mennyi számot dolgozott fel a porgram, azaz mennyi számra igaz a függvény.
print("A találatok nevű lista tartalmának összege: ", osszeg) #Kiírja az összeget.
print("A találatok nevű lista átlaga: ", osszeg / len(talalatok)) #Átlagot számol, és kiírja.