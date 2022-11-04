# HackerRank - DFS: Connected Cell in a Grid

# Link : https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?isFullScreen=false

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'maxRegion' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY grid as parameter.
#


def maxRegion(grid):
    # Write your code here
    maxArea = 0
    for i in range(len(grid)):
        for j in range (len(grid[0])):
            if grid[i][j] == 1:
                regionSize = regionArea(grid, i, j)
                if regionSize > maxArea:
                    maxArea = regionSize
    return maxArea

def regionArea(grid, row, col):
    if (row < 0 or col < 0 or row >= len(grid) or col >= len(grid[0])):
        return 0
    
    if grid[row][col] == 0:
        return 0
        
    regionSize = 1
    grid[row][col] = 0
    
    for i in range(row - 1, row + 2):
        for j in range(col - 1, col + 2):
            if (i != row or j != col):
                regionSize += regionArea(grid, i, j)
                
    return regionSize

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    m = int(input().strip())

    grid = []

    for _ in range(n):
        grid.append(list(map(int, input().rstrip().split())))

    res = maxRegion(grid)

    fptr.write(str(res) + '\n')

    fptr.close()
 
