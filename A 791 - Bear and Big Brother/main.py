# A 791 - Bear and Big Brother - Codeforces
# Link : https://codeforces.com/contest/791/problem/A

from math import *

Limak, Bob = list(map(int, input().split()))
numberOfYears = (log(Bob) - log(Limak))/(log(3) - log(2))

if ceil(numberOfYears) - numberOfYears < 0.000001:
    print(ceil(numberOfYears) + 1)
else:
    print(ceil(numberOfYears))
