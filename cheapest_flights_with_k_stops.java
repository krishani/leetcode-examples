class Solution {
    
    public boolean isPathExistWithLength(int src, int dist, int len) {
        if (len == 1) {
            // find an entry with flights src and dist
            // else return false
            // this is our base case
        } 
        boolean isPathFound = false;
        for(neighbours of src) {
            if (isPathExistWithLength(neighBourOfSrc, dist, len -1)) {
                // update the path map as well.
                return true;
            }
        }
    }
    
    public int getCheapest(int src, int dist, int len) {
        if (len == 1) {
            if (isPathExistWithLength(src, dist, 1)) {
                return price of the path
            }
        } else {
            // array Of prices 
            for(neighbours of src) {
                if (isPathExistWithLength(neighBourOfSrc, dist, len -1)) {
                // update the path map as well.
                // prices.add(price + price from src to neightbour)
                }
             }
            return Arrays.sort(prices) [0]
            }
    }
    
    
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // let's loop through the flights array and put this into a map
        // { start_end : length }
        
    }
}