class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // decreasing order  
        Stack<Integer> decreasing_stack = new Stack<>();
        Map<Integer, Integer> next_greater_element_map = new HashMap<>();
        int[] ans = new int[nums1.length];
        
        for (int i=0; i<nums2.length; i++) {
            if (decreasing_stack.size() == 0) {
                decreasing_stack.push(nums2[i]);
            } else if (decreasing_stack.size() > 0) {
                int peek = decreasing_stack.peek();
                if (nums2[i] < peek) {
                    decreasing_stack.push(nums2[i]);
                } else {
                    while(decreasing_stack.size()>0 && decreasing_stack.peek()<nums2[i]) {
                        next_greater_element_map.put(decreasing_stack.peek(), nums2[i]);
                        decreasing_stack.pop(); 
                    }
                    decreasing_stack.push(nums2[i]);
                }
            }
        }
        
        for (int j=0; j<nums1.length; j++) {
            if (next_greater_element_map.containsKey(nums1[j])) {
                ans[j] = next_greater_element_map.get(nums1[j]);
            } else {
                ans[j] = -1;
            }
        }
        return ans;
    }
}