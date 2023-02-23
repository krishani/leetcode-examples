class Solution {
    
    
    public boolean isValidCell(int[][] grid, int[] curCell) {
        int x = curCell[0];
        int y = curCell[1];
        if (x >=0 && y >=0 && x<grid.length && y<grid[0].length && grid[x][y] == 0) {
            return true;
        }
        return false;
    }
    
    public int maxDistance(int[][] grid) {
        
        Queue<int[]> queue = new ArrayDeque<>();
                  
        int maxDistance = 0;
        
        boolean landFound = false;
        boolean waterFound = false;
        
        int[][] directions = {
            {0,1}, {0,-1}, {1,0}, {-1, 0}
        };
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    landFound = true;
                    queue.add(new int[] {i, j, 0});
                }
                if (grid[i][j] == 0) {
                    waterFound = true;
                }
            }
        }
        
        if (!landFound || !waterFound) {
            return -1;
        }
        
        while(queue.size() > 0) {
            int[] removed  = queue.remove();
            int x = removed[0];
            int y = removed[1];
            int dis = removed[2];
                        
            // get the reachable cells from this
            for (int k=0; k<directions.length; k++) {
                int[] newCell = {x+directions[k][0], y+directions[k][1]};
                if (isValidCell(grid, newCell)) {
                    int newDistance = dis + 1;
                    grid[newCell[0]][newCell[1]] = newDistance;
                    if (newDistance > maxDistance) {
                        maxDistance = newDistance;
                    }
                    queue.add(new int[] { newCell[0], newCell[1], newDistance});
                    
                }
            }
            
        }
        return maxDistance;
    }
}