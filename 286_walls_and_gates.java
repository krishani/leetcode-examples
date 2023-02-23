class Solution {
    
    public void isValidSquare(int[][] rooms, int x, int y, int level, Queue<int[]> queue) {
        if (x >=0 && y>=0 && x < rooms.length && y<rooms[0].length && rooms[x][y] == 2147483647) {
            rooms[x][y] = level;
            queue.add(new int[] { x, y, level});
        }
    }
    
    
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j, 0}); // { i, j, level}
                }
            }
        }
        
        while(queue.size() > 0) {
            int [] removed = queue.poll();
            isValidSquare(rooms, removed[0] + 1, removed[1], removed[2]+1, queue);
            isValidSquare(rooms, removed[0] - 1, removed[1], removed[2]+1, queue);
            isValidSquare(rooms, removed[0], removed[1] - 1, removed[2]+1, queue);
            isValidSquare(rooms, removed[0], removed[1] + 1, removed[2]+1, queue);
        }    
    }
}