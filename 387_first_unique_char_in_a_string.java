class Solution {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> countByLetter = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            if (countByLetter.containsKey(s.charAt(i))) {
                List<Integer> existingMap = countByLetter.get(s.charAt(i));
                existingMap.add(i);
                
                countByLetter.put(s.charAt(i), existingMap);
            } else {
                List<Integer> myNewList = new ArrayList<>();
                myNewList.add(i);
                countByLetter.put(s.charAt(i), myNewList);
            }
        }
        int minVal = Integer.MAX_VALUE;
        for (Map.Entry<Character, List<Integer>> entry: countByLetter.entrySet()) {
            char key = entry.getKey();
            List<Integer> value = entry.getValue();
            
            if (value.size() == 1) {
                int indexVal = value.get(0);
                if (indexVal < minVal) {
                    minVal = indexVal;
                }
            }
        }
        
        return minVal == Integer.MAX_VALUE ? -1 : minVal;
        
    }
}