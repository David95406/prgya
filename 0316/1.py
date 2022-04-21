from time import *

golok = []
with open("0316/golok.txt", "r") as goltxt:
	goltxt.readline()
	for a in range(5):
		golok.append(int(goltxt.readline()))

print(golok)
sleep(10)