from typing import *

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        ans = []
        m = len(grid)
        n = len(grid[0])

        for i in range(m):
            ans.append([])
            for j in range(n):
                ans[i].append(0)

        ans[0][0] = grid[0][0]

        for i in range(1, m):
            ans[i][0] = ans[i - 1][0] + grid[i][0]

        for j in range(1, n):
            ans[0][j] = ans[0][j - 1] + grid[0][j]

        for i in range(1, m):
            for j in range(1, n):
                ans[i][j] = min(ans[i - 1][j], ans[i][j - 1]) + grid[i][j]

        return ans[m - 1][n - 1]

sol = Solution()
grid = [[1,3,1],[1,5,1],[4,2,1]]
print(sol.minPathSum(grid))