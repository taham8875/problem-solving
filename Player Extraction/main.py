# TopCoder : SRM 374 Division I Level Two - 500 - Player Extraction
# Link: http://community.topcoder.com/stat?c=problem_statement&pm=8225&rd=10793

numberOfRows, numberOfColumns = list(map(int, input().split(", ")))

photo = []

for i in range(numberOfRows):
    photo.append(list(input().rstrip()))

teamIdentifier = input()

threshold = int(input())

numberOfPlayers = 0

def markCurrentPlayer(photo, row, col):
        if (row < 0 or col < 0 or row >= numberOfRows or col >= numberOfColumns):
            return
    
        if photo[row][col] != teamIdentifier:
            return
        
        global area, minRow, maxRow, minCol, maxCol

        photo[row][col] = '@'

        area += 1
        
        minRow = min(minRow, row)
        maxRow = max(maxRow, row)
        minCol = min(minCol, col)
        maxCol = max(maxCol, col)

        markCurrentPlayer(photo, row+1, col)
        markCurrentPlayer(photo, row, col+1)
        markCurrentPlayer(photo, row-1, col)
        markCurrentPlayer(photo, row, col-1)

positions = []

for row in range(numberOfRows):
    for col in range(numberOfColumns):
        if photo[row][col] == teamIdentifier:
            area = 0
            minRow = row
            maxRow = row
            minCol = col
            maxCol = col
            markCurrentPlayer(photo, row, col)
            if area * 4 >= threshold:
                positions.append((maxCol + minCol + 1, maxRow + minRow + 1))

positions = sorted(positions, key = lambda x: x[0])

print(positions)