class Solution {
        
    public boolean isMine(char[][] board, int x, int y, HashSet<String>visitedNonMineSet) {
         if (x>=0 && y>=0 && x<board.length && y<board[0].length && !visitedNonMineSet.contains(x+"_"+y)) {
             if (board[x][y] == 'M') {
                 return true;
             } else {
                 return false;
             }
        }
        return false;
    }
    
    
    public int getAdjacentMineCount(char[][] board, int initialStart, int initialEnd, HashSet<String>visitedNonMineSet) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {1, -1}, {-1, 1}, {-1, -1}};
        int mineCount = 0;
       for (int i=0; i<directions.length; i++) {
           if(isMine(board, initialStart+directions[i][0], initialEnd+directions[i][1], visitedNonMineSet)) {
               mineCount +=1;
           }
       }
       return mineCount;
    }
    
    public List<int[]> getValidNeighbourCells(char[][] board, int[]initial, HashSet<String>visitedNonMineSet) {
        List<int[]> validCells = new ArrayList<>();
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        for (int i=0; i<directions.length; i++) {
            int x = initial[0] + directions[i][0];
            int y = initial[1] + directions[i][1];
            
            if (x>=0 && y>=0 && x<board.length && y<board[0].length && !visitedNonMineSet.contains(x+"_"+y)) {
                validCells.add(new int []{x,y});
            } 
        } 
        return validCells;
    }
    
    
    public void dfs(int[] click, HashSet<String>visitedNonBombNodes, char[][] board) {
        
        visitedNonBombNodes.add(click[0]+"_"+click[1]);
        int mineCount = getAdjacentMineCount(board, click[0], click[1], visitedNonBombNodes);
        if (mineCount == 0) {
            board[click[0]][click[1]] = 'B';
            List<int[]> validCells = getValidNeighbourCells(board, click, visitedNonBombNodes);
            for (int i=0; i<validCells.size(); i++) {
                dfs(validCells.get(i), visitedNonBombNodes, board);      
            }
        } else {
            board[click[0]][click[1]] = Character.forDigit(mineCount, 10);
        }
    }
    
    public char[][] updateBoard(char[][] board, int[] click) { 
        HashSet<String> visitedNonBombNodes = new HashSet<String>();
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        dfs(click, visitedNonBombNodes, board);
        return board;
    }
}