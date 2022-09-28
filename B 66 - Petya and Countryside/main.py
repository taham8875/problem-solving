# B 66 - Petya and Countryside - Codeforces
# Link : https://codeforces.com/contest/66/problem/B


numberOfSections = int(input())

heights = list(map(int, input().split()))

numberOfWateredSections = 0

maxNumberOfWateredSections = 0

for i in range(numberOfSections):
    numberOfWateredSections = 1
    for j in range(i+1, numberOfSections):
        if heights[j] <= heights[j-1]:
            numberOfWateredSections += 1
        else:
            break

    for j in range(i, -1, -1):
        if heights[j] >= heights[j-1] and j != 0:
            numberOfWateredSections += 1
        else:
            break
    if numberOfWateredSections > maxNumberOfWateredSections:
        maxNumberOfWateredSections = numberOfWateredSections


print(maxNumberOfWateredSections)
