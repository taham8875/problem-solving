from posixpath import split


numberOfPersons, heightOfFence = list(map(int, input().split()))

heightOfIthPerson = list(map(int, input().split()))

width = 0

for i in range(len(heightOfIthPerson)):
    if heightOfIthPerson[i] > heightOfFence:
        width += 2
    else:
        width += 1

print(width)
