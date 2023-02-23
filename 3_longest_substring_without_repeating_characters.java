class Solution {         
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
    
        HashSet<Character> set = new HashSet();
    
        int startPointer=0;
        int endPointer=0;
        int maxLen = 0;
        while(endPointer < s.length()) {
            char charAtEnd = s.charAt(endPointer);
            char charAtStart = s.charAt(startPointer);
            if (set.contains(charAtEnd)) {
               
                if (charAtEnd == charAtStart) {
                    set.remove(charAtEnd);
                    startPointer += 1;
                } else {
                     while(s.charAt(startPointer) != charAtEnd) {
                        set.remove(s.charAt(startPointer));
                        startPointer += 1;
                    }
                }
                
            } else {
                set.add(charAtEnd);
                endPointer += 1;
            }
            maxLen = Math.max(set.size(), maxLen);
        }
        return maxLen;
    }
}