mondat = "A Python egy általános célú, magas szintű, interaktív, objektum orientált programozási nyelv, melyet Guido van Rossum holland programozó kezdett el fejleszteni 1989 végén, majd hozott nyilvánosságra 1991-ben."

#Minden szó nagy kezdőbetűs legyen.
print(mondat.title())

#Oldd meg, hogy egy mondat2 nevű változóban el is tárolja a nagybetűsített verziót.
mondat2 = mondat.title()

#Milyen karakter van az első vessző előtt.
print("Az első vessző előtti karakter: ",mondat[mondat.find(",")-1])

#Csak betűkből áll a szöveg?
print("Csak betűkből áll a szöveg:", mondat.isalpha())

#Darabold fel a mondatot a ", " karakterek mentén egy lista nevű változóba.
lista = mondat.split(",")
print(lista)

#Hány eleme van a listának?
print("Lista elemei:", (len(lista)))

#A 2. listaelem úgy kezdődik, hogy "magas"?
if lista[1].startswith(" magas"):
    print("A mondat 2. eleme magas-al kezdődik")
else:
    print("A mondat 2. eleme nem magas-al kezdődik")
    
#Milyen karakter van az utolsó szóköz után?
print("Az utolsó szóköz utáni karakter:", mondat[mondat.rfind(" ")+1])