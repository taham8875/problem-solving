# Letter

# Link : https://codeforces.com/contest/43/problem/B

heading = input()

heading = [i for i in heading if i != ' ']

letter = input()

letter = [i for i in letter if i != ' ']

for i in letter:
    if (i in heading):
        heading.pop(heading.index(i))
    else:
        print("NO")
        exit()

print("YES")
