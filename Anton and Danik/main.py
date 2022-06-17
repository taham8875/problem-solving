numberOfGames = int(input())
status = input()

if (status.count('A') > status.count('D')):
    print('Anton')
elif (status.count('A') < status.count('D')):
    print('Danik')
else:
    print('Friendship')
