class Location implements Comparable<Location> {
    int score;
    String name;
    
    public Location(int score, String name) {
       this.score = score;
       this.name = name;
    }
    
    @Override
	public int compareTo(Location loc) {
		return this.score == loc.score ? this.name.compareTo(loc.name) : this.score - loc.score;
	}
}



class SORTracker {
    PriorityQueue<Location> minHeap;
    PriorityQueue<Location> maxHeap;
    int k =1;
    
    public SORTracker() {
        
     this.minHeap = new PriorityQueue<>();
    this.maxHeap = new PriorityQueue<>();
    }
    
    public void add(String name, int score) {
        Location loc = new Location(score, name);
        if (minHeap.size() == 0 || minHeap.peek().compareTo(loc) > 0) {
            this.minHeap.add(loc);
        }
        
        if (minHeap.size() > this.k + 1) {
            this.maxHeap.add(minHeap.poll());
        }
        
    }
    
    public String get() {
        while(minHeap.size() < this.k+1) {
            if (maxHeap.size() > 0) {
                this.minHeap.add(this.maxHeap.poll());
            }
        }
        this.maxHeap.add(minHeap.poll());
        this.k = this.k+1;
        return this.maxHeap.peek().name;
        
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */