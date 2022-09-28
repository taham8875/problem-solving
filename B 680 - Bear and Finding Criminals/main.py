# B 680 - Bear and Finding Criminals - Codeforces
# Link : https://codeforces.com/contest/680/problem/B


numberOfCities, bearIndex = list(map(int, input().split()))

bearIndex -= 1

criminals = list(map(int, input().split()))

numberOfCatched = 0

if criminals[bearIndex] == 1:
    numberOfCatched += 1

for i in range(1, numberOfCities):
    if ((bearIndex + i <= numberOfCities-1) and criminals[bearIndex + i] == 1) and ((bearIndex - i >= 0) and criminals[bearIndex - i] == 1):
        numberOfCatched += 2
    elif ((bearIndex + i > numberOfCities-1)) and ((bearIndex - i >= 0) and criminals[bearIndex - i] == 1):
        numberOfCatched += 1
    elif ((bearIndex + i <= numberOfCities-1) and criminals[bearIndex + i] == 1) and ((bearIndex - i < 0)):
        numberOfCatched += 1

print(numberOfCatched)
