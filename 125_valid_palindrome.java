class Solution {
    public boolean isPalindrome(String s) {
      // First clean up the string
      List<String> cleanedPhrase = new ArrayList<>();

      for (int i=0; i<s.length(); i++) {
         char character = s.charAt(i);
         if (Character.isLetter(character) || Character.isDigit(character)) {
             cleanedPhrase.add(Character.toString(character).toLowerCase()); 
         }
           
      }

      // let's check using first and the last
      if (cleanedPhrase.size() == 0 || cleanedPhrase.size() == 1) return true;
      int midIndex = (cleanedPhrase.size())/2 +1;
      for (int i=0; i<midIndex; i++) {
          int lastIndex = cleanedPhrase.size() -1 - i;
          if (!(cleanedPhrase.get(i)).equals(cleanedPhrase.get(lastIndex))) {
            return false;
          }
      
       }
     return true;
    }
        
}