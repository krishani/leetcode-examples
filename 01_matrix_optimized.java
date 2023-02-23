class Solution {
    Queue<int[]> queue;
    int[][] newMat;
    
    public boolean isValid(int x, int y, int[][]mat, Set<String> visited) {
        if (x<0 || y<0 || x>=mat.length || y>=mat[0].length || visited.contains(x+"_"+y)) {
            return false;
        }
        return true;
    }
    
    public boolean isBoundariesValid(int x, int y, int[][] mat) {
        if (x<0 || y<0 || x>=mat.length || y>=mat[0].length || mat[x][y] != Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
    
    public void bfs() {
        while(queue.size() > 0) {
            int[] removed = queue.poll();
            int x = removed[0];
            int y = removed[1];
            
            
            if (isBoundariesValid(x, y+1, newMat)) {
                queue.add(new int[] { x, y+1 });
                newMat[x][y+1]=newMat[x][y] + 1;
            }
            if (isBoundariesValid(x+1, y, newMat)) {
                queue.add(new int[] { x+1, y });
                newMat[x+1][y]=newMat[x][y] + 1;
            }
            if (isBoundariesValid(x, y-1, newMat)) {
                queue.add(new int[] { x, y-1 });
                newMat[x][y-1]=newMat[x][y] + 1;
            }
            if (isBoundariesValid(x-1, y, newMat)) {
                queue.add(new int[] { x-1, y });
                newMat[x-1][y]=newMat[x][y] + 1;
            }
        }
        
    }
    
    
    public int[][] updateMatrix(int[][] mat) {
        queue = new LinkedList<>();
        newMat = new int[mat.length][mat[0].length];
        
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    newMat[i][j] = Integer.MAX_VALUE;
                } else {
                    queue.add(new int[] {i, j});
                    newMat[i][j] = 0;
                }
            }
        }
        bfs();
        
        return newMat;
    }
}