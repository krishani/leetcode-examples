class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        
        if (strs.length == 1) {
           List<List<String>> simpleList = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            temp.add(strs[0]);
            simpleList.add(temp);
            return simpleList;
        }
        
    
        Map<String, List<String>> wordsBySortedString = new HashMap<String, List<String>>();
        
        for (int i=0; i<strs.length; i++) {
            String word = strs[i];
            char [] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (wordsBySortedString.containsKey(sortedWord)) {
                List<String> wordList = wordsBySortedString.get(sortedWord);
                wordList.add(word);
                wordsBySortedString.put(sortedWord, wordList);
            } else {
                List<String> newWordList = new ArrayList<>();
                newWordList.add(word);
                wordsBySortedString.put(sortedWord, newWordList); 
            }
        }
            /*
                Map<String, Integer> map = new HashMap<String, Integer>();
                List<String> keys = new ArrayList<>(map.keySet());
                List<Integer> values = new ArrayList<>(map.values());
            */
       List<List<String>> anagramGroups = new ArrayList<>(wordsBySortedString.values());
       
       return anagramGroups;
  
    }
}