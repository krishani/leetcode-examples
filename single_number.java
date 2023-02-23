class Solution {
    public int singleNumber(int[] nums) {
        int singleNum = nums[0];
        for (int i=1; i<nums.length; i++) {
            singleNum = singleNum^nums[i];
        }
        return singleNum;
    }
}