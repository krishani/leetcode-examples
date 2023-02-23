class Solution {
    public boolean isPalindrome(int x) {
       String initial = String.valueOf(x);
       for (int i=0; i<initial.length()/2+1; i++) {
           char ch1 = initial.charAt(i);
           char ch2 = initial.charAt(initial.length()-1-i);
           if (ch1 != ch2) {
               return false;
           }
       }
       return true;
    }
}