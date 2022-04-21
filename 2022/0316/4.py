fr = open("0316/golok.txt", "r")
fw = open("0316/golok2.txt", "w")

fr.readline()
for sor in fr:
    fw.write(sor)