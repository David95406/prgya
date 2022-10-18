"""
4. feladat:
Kérd be egy téglalap oldalait és tárolja őket VALÓS típusú változókba, majd határozd meg, a téglalap területét és kerületét!
A területet és a kerületet a következő képletekkel számold:
T = a * b
K = 2 * (a + b)
"""
a = float(input("Addja meg a téglalap egyik oldalát! "))
b = float(input("Addja meg a téglalap egyik oldalát! "))
K = 2 * (a + b)
T = a * b
print("A téglalap kerülete: ", K, "cm")
print("A téglalap területe: ", T, "cm^")