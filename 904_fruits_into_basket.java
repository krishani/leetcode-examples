class Solution {
    public int totalFruit(int[] fruits) {
        int[][]memo = new int[fruits.length][4];
        
        memo[fruits.length-1][0] = fruits[fruits.length-1];  // SET 1
        memo[fruits.length-1][1] = 1;
        memo[fruits.length-1][2] = -1;                       // SET 2
        memo[fruits.length-1][3] = 0;
        
        for(int i=fruits.length-2; i>=0; i--) {
            int curFruitType = fruits[i];
            //System.out.println(curFruitType);
            if (memo[i+1][0] == curFruitType || memo[i+1][2] == curFruitType) {
                if (memo[i+1][0] == curFruitType) {
                    memo[i][0] = memo[i+1][0];
                    memo[i][1] = memo[i+1][1] + 1; 
                    
                    memo[i][2] = memo[i+1][2];
                    memo[i][3] = memo[i+1][3]; 
                    
                } else if (memo[i+1][2] == curFruitType) {
                    memo[i][0] = memo[i+1][0];
                    memo[i][1] = memo[i+1][1]; 
                    
                    memo[i][2] = memo[i+1][2];
                    memo[i][3] = memo[i+1][3] + 1; 
                }
            } else if(memo[i+1][2] == -1) {
                memo[i][0] = memo[i+1][0];
                memo[i][1] = memo[i+1][1]; 
                
                memo[i][2] = curFruitType;
                memo[i][3] = 1;
            } else {
                // SET 1 or SET 2 DON'T MATCH
                int prevFruitType = fruits[i+1];
                if (memo[i+1][0] == prevFruitType || memo[i+1][2] == prevFruitType) {
                    int prevFruitCount = 1;
                    if (memo[i+1][0] == prevFruitType) {
                        prevFruitCount = memo[i+1][1];
                        
                    } else if (memo[i+1][2] == prevFruitType) {
                        prevFruitCount = memo[i+1][3];
                    }
                    int ind = i+1;
                    int count = 0;
                    while(ind<fruits.length && fruits[ind] == prevFruitType) {
                      ind = ind + 1;
                      count = count + 1;
                    }

                    memo[i][0]=curFruitType;
                    memo[i][1]=1;
                    memo[i][2]=prevFruitType;
                    memo[i][3]=count;
                    
                } else {
                    // TODO
                }
            }
            
        }
        // for loop get the max
        int maxCount = 0;
        for (int i=0; i<memo.length; i++) {
            int curCount = memo[i][1] + memo[i][3];
            maxCount = Math.max(maxCount, curCount);
        }
        return maxCount;
    }
}