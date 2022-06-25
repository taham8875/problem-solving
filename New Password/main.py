# New Password - Code Forces
# Link : https://codeforces.com/contest/770/problem/A

# there are simpler solution of this problem,
# the solution does not require any
# shuffling at all (and will be accepted)
# however, i think that no password should be predictable

import string
import random

length, numberOfDistinctSymbols = map(int, input().split())


alphabet = list(string.ascii_lowercase)

random.shuffle(alphabet)

output = ''

for i in range(length):
    output += alphabet[i % numberOfDistinctSymbols]

print(output)
