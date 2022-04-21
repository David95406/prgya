file = open('0323/forras2.txt', 'r')
 
while 1:
     
    # read by character
    char = file.read(1)         
    if not char:
        break
         
    print(char)
 
file.close()