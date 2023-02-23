class Solution {
    public boolean isValid(int [] place, int[][] grid) {
        int x = place[0];
        int y = place[1];
        int rowNum = grid.length;
        int colNum = grid[0].length;
        if (x<0 || y<0 || x >= rowNum ||y >= colNum || grid[x][y]==2 || grid[x][y] ==0 )  return false;
        return true;
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        int freshOranges = 0;
        
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j, 0});
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        int time = 0;
        System.out.println(freshOranges);
        
        while(queue.size() > 0) {
            int[] removed = queue.remove();
            int x  = removed[0];
            int y = removed[1];
            int level = removed[2];
            
            if (isValid(new int[] { x, y+1 }, grid)) {
                queue.add(new int[] {x, y+1, level+1});
                grid[x][y+1] = 2;
                freshOranges--;
                
            } 
            if (isValid(new int[] { x, y-1 }, grid)) {
                queue.add(new int[] {x, y-1, level+1});
                grid[x][y-1] = 2;
                freshOranges--;
            }
            if (isValid(new int[] { x+1, y }, grid)) {
                queue.add(new int[] {x+1, y, level+1});
                grid[x+1][y] = 2;
                freshOranges--;
            }
            if (isValid(new int[] { x-1, y }, grid)) {
                queue.add(new int[] {x-1, y, level+1});
                grid[x-1][y] = 2;
                freshOranges--;
            }
            time = level;
        }
        
        
       if (freshOranges == 0) {
           return time;
       }
        return -1;
    }
}



/*class Solution {
    
    public class Coordinate {
        int row;
        int col;
        int level;
        
        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        Coordinate(int row, int col, int level) {
            this.row = row;
            this.col = col;
            this.level = level;
        }
        
        int getLevel() {
            return this.level;
        }
        
        void setLevel(int level) {
            this.level = level;
        }
    }
    
    public List<Coordinate> getFreshOrangesAdgacentToRotten (List<Coordinate> directions, Coordinate rottenOrange, Coordinate gridDimensions, int[][] grid )     {
        List<Coordinate> orangesToRot = new ArrayList<>();
        for (int i=0; i<4; i++) {
            Coordinate direction = directions.get(i);
            int newRow = rottenOrange.row + direction.row;
            int newCol = rottenOrange.col + direction.col;
            if (newRow >= 0 && newCol >= 0 && newRow < gridDimensions.row && newCol < gridDimensions.col && (grid[newRow][newCol] !=2 && grid[newRow][newCol] !=0)) {
                orangesToRot.add(new Coordinate(newRow, newCol, rottenOrange.level + 1));
            }  
        }
        return orangesToRot;
    }
    
    
    public int orangesRotting(int[][] grid) {
        
        Queue <Coordinate> queue = new ArrayDeque<>();
        
        Coordinate up = new Coordinate(-1, 0);
        Coordinate down = new Coordinate(1, 0);
        Coordinate left = new Coordinate(0, 1);
        Coordinate right = new Coordinate(0, -1);
        
        List<Coordinate> directions = new ArrayList<>();
        
        directions.add(up);
        directions.add(down);
        directions.add(left);
        directions.add(right);
        
        Coordinate gridDimensions = new Coordinate(grid.length, grid[0].length);
        
        int initialFresh = 0;
                
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    initialFresh += 1;
                } else if (grid[i][j] == 2) {
                    Coordinate coordinate = new Coordinate(i, j, 0);
                    queue.add(coordinate);                    
                }
            }
        }
        
        int time = 0;
        while (queue.size() >0) {
            Coordinate rotten = queue.remove();
            // for each directions get the valid fresh oranges that are about to rot.
            List<Coordinate> adgecentOranges = getFreshOrangesAdgacentToRotten(directions, rotten, gridDimensions, grid);
            
            for (int i=0; i<adgecentOranges.size(); i++) {
                queue.add(adgecentOranges.get(i));
                initialFresh --;
                grid[adgecentOranges.get(i).row][adgecentOranges.get(i).col] = 2;
                if (adgecentOranges.get(i).level >= time) {
                    time = adgecentOranges.get(i).level;
                }
            }
        }
        
        if (initialFresh == 0) {
            return time;
        } else {
            return -1;
        }  
    }
    
}*/