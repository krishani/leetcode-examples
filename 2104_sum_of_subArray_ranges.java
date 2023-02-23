class Solution {
    public long subArrayRanges(int[] nums) {
        
     long sum = 0;
     for (int start=0; start<nums.length; start++) {
         int min = nums[start];
         int max = nums[start];
         for (int end=start + 1; end<nums.length; end++) {
             if (nums[end] < min) {
                     min = nums[end];
                     
            } else if (nums[end] > max) {
                     max = nums[end];
            }
              sum+=max-min;             
         }
     }
    return sum;
    }
}