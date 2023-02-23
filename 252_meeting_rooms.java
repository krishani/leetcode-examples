class Solution {
    
    public boolean isConflict(int[] times, int start, int end) {
        int k = start;
        while(k<end) {
            if (times[k] == 1) {
                return true;
            }
            k++;
        }
        return false;
    }
    
    public boolean canAttendMeetings(int[][] intervals) {
        // Find the maximum time
        
        int maxTime = Integer.MIN_VALUE;
        for (int i=0; i< intervals.length; i++) {
            if (intervals[i][1] > maxTime) {
                maxTime = intervals[i][1];
            } 
        }
        
        if (intervals.length == 0 || intervals.length == 1) {
            return true;
        }

        // Initialize an array from 0 - max time
        int [] times = new int [maxTime + 1];
        
        
        for (int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            boolean conflicted = isConflict(times, start, end);
            if (conflicted == true) {
                    return false;
            } else {
                // Reserve the slot
                int j=start;
                while(j<end) {
                    times[j] = 1;
                    j++;
                }
            }
        } 
        return true;
    }
}