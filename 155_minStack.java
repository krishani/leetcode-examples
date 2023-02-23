class MinStack {

    List<Integer> valStack;
    List<Integer> minStack;    
    
    public MinStack() {
        this.valStack = new ArrayList<>();
        this.minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        this.valStack.add(val);
        if (minStack.size() > 0) {
            this.minStack.add(Math.min(val, this.minStack.get(minStack.size()-1)));
        } else {
            this.minStack.add(val);
        }
    }
    
    public void pop() {
        int lastIndex = valStack.size() - 1;
        this.valStack.remove(lastIndex);
        
        this.minStack.remove(lastIndex);
    }
    
    public int top() {
        int lastIndex = valStack.size() - 1;
        return this.valStack.get(lastIndex); 
    }
    
    public int getMin() {
        int lastIndex = valStack.size() - 1;
        return this.minStack.get(lastIndex); 
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */