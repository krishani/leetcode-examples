class Solution {
    public int findMaxProducts(int[] nums) {
        
        // We will store the max num of products from previous subarray with the last value added
        int [][] memo = new int [nums.length][2];
                
        memo[nums.length-1][0] = nums[nums.length-1]; // max Value
        memo[nums.length-1][1] = nums[nums.length-1]; // last value
        
        for (int i=nums.length-2; i>=0; i--) {
            int prevMax = memo[i+1][0];
            int prevLastVal = memo[i+1][1];
            
            if (prevLastVal == 0) {
                // This means we can only add 0
                if (prevMax > nums[i]) {
                    memo[i][0] = prevMax;
                    memo[i][1] = prevLastVal;
                } else {                          // TODO check the equal
                    memo[i][0] = nums[i];
                    memo[i][1] = nums[i];
                }
            } else {
                //   4,5
                if (nums[i] > prevLastVal-1) {
                    int numValueAddedToPrevMax = prevMax + prevLastVal - 1;
                    
                    if (numValueAddedToPrevMax > nums[i]) {
                        memo[i][0] = numValueAddedToPrevMax;
                        memo[i][1] = prevLastVal - 1;
                    } else {
                        memo[i][0] = nums[i];
                        memo[i][1] = nums[i];
                    }
                    
                // 3, 5
                } else {
                    memo[i][0] = prevMax + nums[i];
                    memo[i][1] = nums[i];
                }
                
            }
        }
        return memo[0][0];
    }
}

// Test cases

// [7,4,5,2,6,5]
// [1,2,3,4,5,6]
// [1,0,2,5,10,15]