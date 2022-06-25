# Way Too Long Words - Codeforces
# Link : https://codeforces.com/contest/71/problem/A


numberOfWords = int(input())

words = []

for i in range(numberOfWords):
    words.append(input())

for word in words:
    if len(word) <= 10:
        print(word)
    else:
        print(word[0] + str(len(word) - 2) + word[-1])
