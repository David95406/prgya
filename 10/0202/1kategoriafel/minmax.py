a = []
for i in range(3):
    b = int(input("$"))
    a.append(b)
print("max: ", max(a))
print("min: ", min(a))
a.remove(max(a))
a.remove(min(a))
print("A közepes: ", a[0])