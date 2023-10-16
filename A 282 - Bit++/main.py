# A 486 - Bit++ - Codeforces
# Link : https://codeforces.com/contest/282/problem/A

numberOfStatements = int(input())

counter = 0

for i in range(numberOfStatements):
    statement = input()
    if "+" in statement:
        counter += 1
    else:
        counter -= 1

print(counter)
