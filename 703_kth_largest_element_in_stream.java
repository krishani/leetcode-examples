class KthLargest {
    
    int k;
    int[] nums;
    PriorityQueue<Integer> minHeap;
    
    public void initHeapWithNums(int[] nums, int k) {
        for(int i=0; i<nums.length; i++) {
            this.minHeap.add(nums[i]);
            
            while(minHeap.size() > k) {
                this.minHeap.poll();
            }
        }
    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.minHeap = new PriorityQueue<>();
        
        initHeapWithNums(this.nums, this.k);
    }
    
    public int add(int val) {
       if (this.minHeap.size() < k) {
           this.minHeap.add(val);
           
           if (this.minHeap.size() == k) {
                return this.minHeap.peek();
            } 
       } else {
          if (val >= this.minHeap.peek()) {
            this.minHeap.add(val);
            this.minHeap.poll();
        }
        return this.minHeap.peek();
        }
        return 1;
       }
        
       
        
        
        
        
        
    
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */