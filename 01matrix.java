class Solution {
    
    public boolean isValid(int x, int y, int[][]mat, Set<String> visited) {
        if (x<0 || y<0 || x>=mat.length || y>=mat[0].length || visited.contains(x+"_"+y)) {
            return false;
        }
        return true;
    }
    
    
    public int bfs(int x, int y, int[][]mat) {

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(x+"_"+y);
        queue.add(new int[] {x, y, 0});
        while(queue.size() > 0) {
            int[] removed = queue.poll();
            int xVal = removed[0];
            int yVal = removed[1];
            int dis = removed[2];
            
            if (isValid(xVal+1, yVal, mat, visited)) {
                if (mat[xVal+1][yVal]==0) {
                    return dis+1;
                } else {
                    visited.add((xVal+1)+"_"+yVal);
                    queue.add(new int[] {(xVal+1),  yVal, (dis+1)});
                }
                
            }
            if (isValid(xVal, yVal+1, mat, visited)) {
                if (mat[xVal][yVal+1]==0) {
                    return dis+1;
                } else {
                    visited.add(xVal+"_"+(yVal+1));
                    queue.add(new int[] {xVal,  (yVal+1), (dis+1)});
                }
                
            }
            if (isValid(xVal-1, yVal, mat, visited)) {
                if (mat[xVal-1][yVal]==0) {
                    return dis+1;
                } else {
                    visited.add((xVal-1)+"_"+yVal);
                    queue.add(new int[] {(xVal-1),  yVal, (dis+1)});
                } 
            }
            if (isValid(xVal, yVal-1, mat, visited)) {
                if (mat[xVal][yVal-1]==0) {
                    return dis+1;
                } else {
                    visited.add((xVal)+"_"+(yVal-1));
                    queue.add(new int[] {xVal,  (yVal-1), (dis+1)});
                } 
            }
            
        }
        return Integer.MAX_VALUE;
        
    }
    public int[][] updateMatrix(int[][] mat) {
        // TODO initialize a 2d array
        int[][] newMat = new int[mat.length][mat[0].length];
        
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    // RUN BFS
                    int dis = bfs(i, j, mat);
                    newMat[i][j] = dis;
                } else {
                    newMat[i][j] = 0;
                }
            }
        }
    
        return newMat;
        
    }
}