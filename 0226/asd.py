#Importálom a datetime-ot
import datetime

# A "now" nevű változóban eltárolom az éppen aktuális dátumot és időt
now = datetime.datetime.now()
print(now)

# A "datum" nevű változóban eltárolom az éppen aktuális dátumot
datum = datetime.date.today()
print(datum)

# Az "ido" nevű változóban eltárolom az éppen aktuális időt
ido = datetime.datetime.now()
print(ido.strftime("%H:%M:%S"))

# "now" nevű változóban eltárolom az éppen aktuális órát
ora = datetime.datetime.now()
print(ora.strftime("%H óra"))

# "perc" nevű változóban eltárolom az éppen aktuális percet
perc = datetime.datetime.now()
print(ora.strftime("%M perc"))

# "now" nevű változóban eltárolom az éppen aktuális másodpercet
masodperc = datetime.datetime.now()
print(ora.strftime("%S másodperc"))

# Ha óra 4 és 9 között van, akkor "Jó reggelt!" kiíratása
if ora.hour > 4 and ora.hour < 9:
    print("Jó reggelt!")
# Ha óra 10 és 18 között van, akkor "Jó napot!" kiíratása
if ora.hour > 10 and ora.hour < 18:
    print("Jó napot!")
# Ha óra több, mint 19, akkor "Jó estét!" kiíratása
if ora.hour > 19:
    print("Jó estét!")