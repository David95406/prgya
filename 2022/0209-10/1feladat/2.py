print("Addjon meg három számot! ")
a = int(input("$"))
b = int(input("$"))
c = int(input("$"))
print(max(a, b, c), min(a, b, c))
if max(a, b, c) != a:
    print(a, "kozepso")
elif max(a, b, c) != b:
    print(b, "kozepso")
elif max(a, b, c) != c:
    print(c, "kozepso")