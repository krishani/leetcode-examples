class Solution {
    
    public boolean isValidCell(int i, int j, int[][] grid) {
        if ( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0) return false;
        return true;
    }
    
    public int dfs(int i, int j, int[][] grid, int area) {
        if (isValidCell(i, j, grid)) {
            // mark as visited
             grid[i][j] = 0;
             area +=1;
            
            // visit neighbours
            area = dfs(i, j+1, grid, area);
            area = dfs(i, j-1, grid, area);
            area = dfs(i-1, j, grid, area);
            area = dfs(i+1, j, grid, area); 
        }
        return area;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int areaOfisland = dfs(i, j, grid, 0);
                    if (areaOfisland > maxArea) {
                        maxArea = areaOfisland;
                    }
                }
            }
        }
        return maxArea;
    }
}