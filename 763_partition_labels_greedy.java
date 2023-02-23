class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> answer = new ArrayList<>();
        
        Map<Character, Integer> charEndingIndexMap = new HashMap<>();
        
        for (int j=0; j<s.length(); j++) {
            charEndingIndexMap.put(s.charAt(j), j);
        }
                
        int startInd = 0;
        int endInd = 0;
        
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            
            int curEndInd = charEndingIndexMap.get(cur);
            
            if (i==endInd && endInd == curEndInd) {
                answer.add(endInd - startInd +1);
                startInd = i+1;
                endInd = i+1;
                
            } else if (curEndInd > endInd) {
                endInd = curEndInd;
            }
        }
        return answer;
        
    }
}