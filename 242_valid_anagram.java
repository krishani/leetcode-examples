class Solution {
    public boolean isAnagram(String s, String t) {
       Map<String, Integer> letterCountMap = new HashMap<String, Integer>();
       Map<String, Integer> letterCountTMap = new HashMap<String, Integer>();

      if (s.length() != t.length()) return false;
        
       for (int i=0; i<s.length(); i++) {
           String letter = Character.toString(s.charAt(i));
           if (letterCountMap.containsKey(letter)) {
               int newCount = letterCountMap.get(letter) + 1;
               letterCountMap.put(letter, newCount);
           } else {
              letterCountMap.put(letter, 1); 
           }

           String letterT = Character.toString(t.charAt(i));
           if (letterCountTMap.containsKey(letterT)) {
               int newCountT = letterCountTMap.get(letterT) + 1;
               letterCountTMap.put(letterT, newCountT);
           } else {
              letterCountTMap.put(letterT, 1); 
           }
       }  

       for (Map.Entry<String,Integer> entry : letterCountMap.entrySet()) {
           String key = entry.getKey();
           int value = entry.getValue();
           
           if (letterCountTMap.containsKey(key)) {
               int tValue = letterCountTMap.get(key);
               if (value != tValue) {
                   return false;
               }
           } else {
               return false;
           }
       }
        return true;
            
    }
}
