# B 469 - Chewbaсca and Number - Codeforces
# Link : https://codeforces.com/contest/469/problem/B

littleXNumberOfTimes, littleZNumberOfTimes, littleZGetsUpAtMin, littleZGetsUpAtMax = map(int, input().split())
littleXIntervals = []
littleZIntervals = []
numberOfTimesBothCanChat = 0

# This is a list of 1004 elements, each element represents a second in the day to avoid replicas
recordedIntervals = [0 for _ in range(1004)]



for i in range(littleXNumberOfTimes):
    littleXIntervals += [list(map(int, input().split()))]
    
    
for i in range(littleZNumberOfTimes):
    littleZIntervals += [list(map(int, input().split()))]
    for j in range(len(littleXIntervals)):
        minTime = littleXIntervals[j][0] - littleZIntervals[-1][1]
        maxTime = littleXIntervals[j][1] - littleZIntervals[-1][0]
        
        if (minTime > littleZGetsUpAtMax or maxTime < littleZGetsUpAtMin):
            continue
        
        intervalStart = max(minTime, littleZGetsUpAtMin)
        intervalEnd = min(maxTime, littleZGetsUpAtMax)
        while (intervalStart <= intervalEnd):
            if (recordedIntervals[intervalStart] == 0):
                numberOfTimesBothCanChat += 1
                recordedIntervals[intervalStart] = 1
            intervalStart += 1

print(numberOfTimesBothCanChat)