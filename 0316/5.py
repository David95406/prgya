fr = open("0316/golok.txt", "r")
fw = open("0316/golok3.txt", "w")

fr.readline()
for sor in fr:
    if int(sor) % 2 == 0:
        fw.write(sor)