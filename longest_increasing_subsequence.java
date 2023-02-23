class Solution {
    
    /**
    nums -> 4, 10, 4, 3, 8, 9
    startIndex -> 2
    max -> max(1, 1+ maxLengthOfSubsequence(8), 1 + maxLengthOfSubsequence(9))
    **/
    public int maxLengthOfSubsequence (int [] nums, int startIndex) {
        if (startIndex == nums.length -1) return 1;
        List<Integer> subSeqList = new ArrayList<>();
        subSeqList.add(1);
        for (int i=startIndex +1; i<nums.length; i++) {
            if (nums[startIndex] < nums[i]) {
                subSeqList.add(1 + maxLengthOfSubsequence(nums, i));
            }
        }
        Collections.sort(subSeqList); 
        return subSeqList.get(subSeqList.size()-1);
    }
    
    public int maxLengthOfSubsequenceMemoize (int [] nums, int startIndex, int [] memo) {
        if (startIndex == nums.length -1) return 1;
        List<Integer> subSeqList = new ArrayList<>();
        subSeqList.add(1);
        if (memo[startIndex] != 0) {
            return memo[startIndex];
        }
        for (int i=startIndex +1; i<nums.length; i++) {
            if (nums[startIndex] < nums[i]) {
                subSeqList.add(1 + maxLengthOfSubsequence(nums, i));
            }
        }
        Collections.sort(subSeqList); 
        memo[startIndex] = subSeqList.get(subSeqList.size()-1);
        return memo[startIndex];
    }
    
    
    public int lengthOfLIS(int[] nums) {
        int [] memo = new int [nums.length];
        
        for (int j=0; j<nums.length; j++) {
            memo[j] = 0;
        }
        
        int maxLen = 0;
        for (int i=nums.length - 1; i>=0; i--) {
            int tempSubSeqLen = maxLengthOfSubsequenceMemoize(nums, i, memo);
            System.out.println("StartIndex ->" + i + " maxLen -> " + tempSubSeqLen);
            if (tempSubSeqLen > maxLen) {
                maxLen = tempSubSeqLen;
            }
        }
        return maxLen;
    }
}