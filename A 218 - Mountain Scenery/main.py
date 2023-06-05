# A 218 - Mountain Scenery - Codeforces
# Link : https://codeforces.com/contest/218/problem/A

numberOfPeaks, numberOfMountainPeaks = map(int, input().split())

yCoordinates = list(map(int, input().split()))

mountainPeaks = []

for i in range(1, len(yCoordinates) - 1, 2):
    if numberOfMountainPeaks == 0:
        break
    if i % 2 == 1 and yCoordinates[i] - yCoordinates[i - 1] > 1 and yCoordinates[i] - yCoordinates[i + 1] > 1:
        yCoordinates[i] -= 1
        numberOfMountainPeaks -= 1

print(*yCoordinates)