class Solution {
    public int maxProduct(int[] nums) {
        int[][] memo = new int[nums.length][2];
        
        memo[0][0] = nums[0];
        memo[0][1] = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            int tempMax;
            int tempMin;
            
            if (nums[i] <0) {
                 tempMax= Math.max(memo[i-1][1] * nums[i], nums[i]);
                 tempMin = Math.min(memo[i-1][0] * nums[i], nums[i]);
                
            } else {
                tempMax = Math.max(memo[i-1][0] * nums[i], nums[i]);
                tempMin = Math.min(memo[i-1][1] * nums[i], nums[i]);
            }
            if (tempMax >= tempMin) {
                memo[i][0] = tempMax;
                memo[i][1] = tempMin;
            } else {
                memo[i][0] = tempMin;
                memo[i][1] = tempMax;
            }
        }
        
        int maxProduct = Integer.MIN_VALUE;
        
        for (int j=0; j<memo.length; j++) {
            if (memo[j][0] > maxProduct) {
                maxProduct = memo[j][0];
            }   
        }
        return maxProduct;
        
    }
}