# A 112 - Petya and Strings - Codeforces
# Link : https://codeforces.com/contest/112/problem/A

string_1 = input().lower()
string_2 = input().lower()

if (string_1 < string_2):
    print(-1)
elif(string_1 > string_2):
    print(1)
else:
    print(0)
