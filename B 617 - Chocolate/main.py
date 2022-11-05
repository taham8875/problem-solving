# B 617 - Chocolate - Codeforces
# Link : https://codeforces.com/problemset/problem/617/B


numberOfPieces = int(input())

chocolate = list(map(int, input().split(" ")))

numberOfWays = 1

if 1 not in chocolate:
    print('0')
else :
    for i in range(len(chocolate)):
        if (chocolate[i] == 1):
            for j in range(i + 1, len(chocolate)):
                if (chocolate[j] == 1):
                    numberOfWays *= j - i
                    break
    print(numberOfWays)