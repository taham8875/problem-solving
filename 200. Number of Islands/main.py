# LeetCode- 200. Number of Islands

# Link : https://leetcode.com/problems/number-of-islands/description/


class Solution:

    def numIslands(self, grid: List[List[str]]) -> int:
        numOfRows = len(grid)
        numOfCols = len(grid[0])
        
        numOfIslands = 0
        for row in range(numOfRows):
            for col in range(numOfCols):
                if grid[row][col] == '1':
                    self.markCurrentIsland(grid, row, col)
                    numOfIslands += 1
        return numOfIslands

    def markCurrentIsland(self, grid, row, col):
        if (row < 0 or col < 0 or row >= len(grid) or col >= len(grid[0])):
            return
    
        if grid[row][col] == '0':
            return

        grid[row][col] = '0'

        self.markCurrentIsland(grid, row+1, col)
        self.markCurrentIsland(grid, row, col+1)
        self.markCurrentIsland(grid, row-1, col)
        self.markCurrentIsland(grid, row, col-1)


