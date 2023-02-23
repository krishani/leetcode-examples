class Solution {
    
    public int robBasic(int[] nums) {
        if (nums.length == 1) return nums[0];
        int [] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        
        for (int i=2; i< nums.length; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2]+ nums[i]);
        }
        return memo[memo.length-1];
    }
    
    
    
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int fromFirstToOneBeforeLast [] = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int fromSecondToLast [] = Arrays.copyOfRange(nums, 1, nums.length);
        int maxMoneyFromFirst = robBasic(fromFirstToOneBeforeLast);
        int maxMoneyFromSecond = robBasic(fromSecondToLast);
        
        return Math.max(maxMoneyFromFirst, maxMoneyFromSecond);
    }
}