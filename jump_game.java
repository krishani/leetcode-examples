public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int targetIndex = nums.length - 1;
        
        if (nums.length == 1) return true;
        
        for (int i=0; i<nums.length; i++) {
            if (i==maxIndex && nums[maxIndex] == 0) {
                return false;
            } 
            int curIndex = i + nums[i];
            maxIndex = Math.max(maxIndex, curIndex);
            
            if (maxIndex >= targetIndex) {
                return true;
            }
        }
        return false;
    }