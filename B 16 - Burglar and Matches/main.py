# B 16 - Burglar and Matches - Codeforces
# Link : https://codeforces.com/contest/16/problem/B


rucksack, numberOfContainers = list(map(int, input().split()))

numberOfMatches = 0

data = [0]*numberOfContainers

for i in range(numberOfContainers):
    userInput = list(map(int, input().split()))
    data[i] = (userInput[0], userInput[1])

data = sorted(data, key=lambda l: l[1], reverse=True)

for key, value in data:
    if (rucksack < 1):
        break
    if (rucksack >= key):
        rucksack -= key
        numberOfMatches += key * value
    else:
        numberOfMatches += rucksack * value
        rucksack = 0

print(numberOfMatches)
