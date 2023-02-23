class Solution {
    public int longestConsecutive(int[] nums) {
        // put all the numbers to a map
        Map < Integer, Boolean > numMap = new HashMap < Integer, Boolean > ();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], false);
        }

        int keepConsecutivesTempLength = 0;
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            // Check if we already saw this number in the map
            if (numMap.get(nums[i]) == false) {
                keepConsecutivesTempLength += 1;
                numMap.put(nums[i], true);

                if (numMap.containsKey(nums[i]-1)) {
                    keepConsecutivesTempLength += 1;
                    numMap.put(nums[i] - 1, true);
                    int minNum = nums[i] - 2;
                    while (numMap.containsKey(minNum)) {
                        keepConsecutivesTempLength += 1;
                        numMap.put(minNum, true);
                        minNum = minNum - 1;
                    }

                }
                if (numMap.containsKey(nums[i] + 1)) {
                    keepConsecutivesTempLength += 1;
                    numMap.put(nums[i] + 1, true);
                    int maxNum = nums[i] + 2;
                    while (numMap.containsKey(maxNum)) {
                        keepConsecutivesTempLength += 1;
                        numMap.put(maxNum, true);
                        maxNum = maxNum + 1;
                    }

                }
            }
            if (keepConsecutivesTempLength >= longest) {
                longest = keepConsecutivesTempLength;

            }
            keepConsecutivesTempLength = 0;
        }
        return longest;
    }
}