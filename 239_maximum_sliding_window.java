class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        // Get the decresing queue for first k elements
        
        for (int i=0; i<k; i++) {
            if (queue.size() == 0) {
                queue.add(nums[i]);
            } else {
                while(queue.size() > 0 && queue.peekLast() < nums[i]) {
                queue.pollLast();
                }
                queue.add(nums[i]);
            }
        }
        ans.add(queue.peekFirst()); // This gives us the max from k window
        if (nums[0] == queue.peekFirst()) { // we have to remove the first element from queue if its the one we are going to leave behind.
            queue.pollFirst();
        }
        
        for (int j=k; j<nums.length; j++) {
            if (queue.size() == 0) {
                queue.add(nums[j]);
            } else {
                while(queue.size() > 0 && queue.peekLast() < nums[j]) {
                    queue.pollLast();
                }
                queue.add(nums[j]);
            }
            ans.add(queue.peekFirst());
            if (nums[j-k + 1] == queue.peekFirst()) { 
                queue.pollFirst();
            }
        }
        int [] maxWindows = new int[ans.size()];
        
        for (int i=0; i<ans.size(); i++) {
            maxWindows[i] = ans.get(i);
        }
        
        return maxWindows;   
    }
}