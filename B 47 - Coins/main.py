# B 47 - Coins - Codeforces
# Link : https://codeforces.com/contest/47/problem/B


count = {
    'A' : 0,
    'B' : 0,
    'C' : 0
}


for i in range(3):
    data = input()
    if data[1] == '>':
        if data[0] == 'A':
            count['A'] += 1
        if data[0] == 'B':
            count['B'] += 1
        if data[0] == 'C':
            count['C'] += 1
    elif  data[1] == '<':
        if data[2] == 'A':
            count['A'] += 1
        if data[2] == 'B':
            count['B'] += 1
        if data[2] == 'C':
            count['C'] += 1
            

if (count['A'] < count['B'] and count['B'] < count['C']) :
    print("ABC")
elif (count['A'] < count['C'] and count['C'] < count['B']) :
    print("ACB")
elif (count['C'] < count['B'] and count['B'] < count['A']) :
    print("CBA")
elif (count['B'] < count['A'] and count['A'] < count['C']) :
    print("BAC")
elif (count['B'] < count['C'] and count['C'] < count['A']) :
    print("BCA")
elif (count['C'] < count['A'] and count['A'] < count['B']) :
    print("CAB")
else :
    print("Impossible")