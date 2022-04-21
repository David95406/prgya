print("Addjon meg két mondatot")
a = input("")
b = input("")

def mondat(a, b):
    if len(a) > len(b): 
        return a
    return b

print("A hoszabb mondat: ", mondat(a, b)) #Melyik a leghoszabb mondat?
print("Mind2 pontal kégződik?", a.endswith(".") and b.endswith(".")) #Mind2 mondat pontal végződik?
print("Mind2 mondat nagybetűvel kezdődik?", a.istitle() and b.istitle()) #Mind2 mondat nagybetűvel kezdődik?