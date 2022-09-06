from datetime import datetime

now = datetime.now()
ido = datetime.time(now)
datum = datetime.date(now)

print("Rendszeridő:")
print(datetime.now())
print(datum)
print(ido)
print("Óra:", datetime.now().hour)
print("Perc:", datetime.now().minute)
print("Másodperc:", datetime.now().second,"\n\n")

if datetime.now().hour >= 4 and datetime.now().hour <= 9:
    print("Jó reggelt!")
elif datetime.now().hour >= 10 and datetime.now().hour <= 18:
    print("Jó napot!")
elif datetime.now().hour >= 19 or datetime.now().hour < 4:
    print("Jó estét!")