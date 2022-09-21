# A 231 - Team - Codeforces
# Link : https://codeforces.com/contest/231/problem/A

numberOfProblems = int(input())

numberOfSolvedProblems = 0


for i in range(numberOfProblems):
    state = list(map(int, input().split()))
    if state.count(1) >= 2:
        numberOfSolvedProblems += 1

print(numberOfSolvedProblems)
