#fuggveny megadja ket szam legnagyobb kozos osztojat 
print("Legnagyobb közös osztó")

def computeGCD(x, y):
  
   while(y):
       x, y = y, x % y
  
   return x
  
a = int(input("Addja meg az egyik szamot! "))
b= int(input("Addja meg a masik szamot! "))

print (computeGCD(a,b))
