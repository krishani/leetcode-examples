class Solution {
    
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> decreasingStack = new Stack<>();
        int[] ans = new int[temperatures.length];
        
        for (int i=0; i<temperatures.length; i++) {
            if(decreasingStack.size() == 0) {
                decreasingStack.push(new int[] {temperatures[i], i});
            }
            else if (decreasingStack.size() > 0) {
                if (temperatures[i] > decreasingStack.peek()[0]) {
                    while(decreasingStack.size() > 0 && temperatures[i] > decreasingStack.peek()[0]) {
                       ans[decreasingStack.peek()[1]] = i - decreasingStack.peek()[1];
                       decreasingStack.pop();
                    }
                    decreasingStack.push(new int[] {temperatures[i], i});
                    
                } else {
                    decreasingStack.push(new int[] {temperatures[i], i});
                }
            }
        }
        return ans;
    }
}