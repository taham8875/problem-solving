# Codeforces - Fox And Two Dots

# Link : https://codeforces.com/contest/510/problem/B

# in a testcase were the input is a 2d array of size 50*50
# and all if cells is 'A', python hits a maximum recursion depth
import sys
sys.setrecursionlimit(3000)


numberOfRows, numberOfColumns = list(map(int, input().split(" ")))

grid = []

# initialize visited array.
# why? to keep track of visited cells, if we operate on a visited cell, that means that we have a cycle
visited = [[False] * numberOfColumns for i in range(numberOfRows)]

thereIsCycle = False


def checkCycle(row, column, rowFrom, columnFrom, currentChar):

    global grid, visited, thereIsCycle, numberOfRows, numberOfColumns

    if (row < 0 or column < 0 or row >= numberOfRows or column >= numberOfColumns):
        return

    if (grid[row][column] != currentChar):
        return

    if (visited[row][column]):
        thereIsCycle = True
        return

    visited[row][column] = True

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    for i in range(4):
        rowNext = row + dx[i]
        columnNext = column + dy[i]

        if (rowNext == rowFrom and columnNext == columnFrom):
            # no need to go back
            continue

        checkCycle(rowNext, columnNext, row, column, currentChar)


def main():

    for i in range(numberOfRows):
        grid.append(list(input()))

    for i in range(numberOfRows):
        for j in range(numberOfColumns):
            currentChar = grid[i][j]
            if(not visited[i][j]):
                checkCycle(i, j, -1, -1, currentChar)
                if (thereIsCycle):
                    print('Yes')
                    return
    print('No')


main()
