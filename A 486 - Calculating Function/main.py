# A 486 - Calculating Function - Codeforces
# Link : https://codeforces.com/contest/486/problem/A

x = int(input())
if (x % 2 == 0):
    print(int(x / 2))
else:
    print(int(-1 * (x + 1) / 2))
