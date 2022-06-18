before = list(map(int, input().split('+')))
before.sort()
for i in range(len(before) - 1):
    print(before[i], end='+')

print(before[-1], end='')
