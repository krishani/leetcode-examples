class Solution {
    
    
    public boolean isValidCell(int i, int j, char[][] grid) {
        if ( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0') return false;
        return true;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if (isValidCell(i,j, grid)) {
            // mark as visited
            grid[i][j] = '0';
            
            // visit all neighbours
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
        }
        
    }
    
    
    public int numIslands(char[][] grid) {
        
        int numOfIslands = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }
}