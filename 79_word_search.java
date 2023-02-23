class Solution {
    HashSet<String> visited = new HashSet();
    
    public boolean isValidCell(char[][] board, int x, int y, int index, String word){
        if (x<0 || y<0 || x>=board.length || y>=board[0].length || visited.contains(x+"_"+y) || index >= word.length() || board[x][y] != word.charAt(index))            {
            return false;
        }
        return true;
    }
    
    public boolean searchWord(char[][] board, int index, String word, int x, int y) {
       if (index == word.length()-1) {
           return true;
       }
       visited.add(x+"_"+y);
       int newIndex = index +1;
       if (isValidCell(board, x, y+1, newIndex, word)) {
           if (searchWord(board, newIndex, word, x, y+1)) return true;
       }
       if (isValidCell(board, x, y-1, newIndex, word)) {
           if (searchWord(board, newIndex, word, x, y-1)) return true;
       }
       if (isValidCell(board, x+1, y, newIndex, word)) {
           if (searchWord(board, newIndex, word, x+1, y)) return true;
       }
       if (isValidCell(board, x-1, y, newIndex, word)) {
           if (searchWord(board, newIndex, word, x-1, y)) return true;
       }
       visited.remove(x+"_"+y);
       return false;
    }
    public boolean exist(char[][] board, String word) {
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchWord(board, 0, word, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;   
    }
}