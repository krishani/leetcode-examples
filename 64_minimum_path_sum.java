class Solution {
    int gridX;
    int gridY;
    int[][] mat;
    Map<String, Integer> memoMap;
    
    public int minSum(int[] start, int[]end) {
        if (start[1] >= gridY || start[0] >= gridX) {
            memoMap.put(start[0]+"_"+start[1], Integer.MAX_VALUE);
            return Integer.MAX_VALUE; 
        }
        if ((start[0] == end[0]) && (start[1] == end[1])) {
            memoMap.put(start[0]+"_"+start[1], mat[start[0]][start[1]]);
            return mat[start[0]][start[1]];
        }
    
        if (memoMap.containsKey(start[0]+"_"+start[1])) {
            return memoMap.get(start[0]+"_"+start[1]);
        }
        int minSum = mat[start[0]][start[1]] + Math.min(minSum(new int[] {start[0], start[1] + 1}, end), minSum(new int[] { start[0]+1, start[1]}, end));  
        
        memoMap.put(start[0]+"_"+start[1], minSum);
        return minSum;
    }
    
    public int minPathSum(int[][] grid) {
        this.gridX = grid.length;
        this.gridY = grid[0].length;
        this.mat = grid;
        memoMap = new HashMap();
        return minSum(new int[] {0,0}, new int [] { gridX-1, gridY-1});
        
    }
}