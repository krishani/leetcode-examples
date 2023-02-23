class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> mirrorDigits = new HashMap();
        mirrorDigits.put('6','9');
        mirrorDigits.put('9','6');
        mirrorDigits.put('8','8');
        mirrorDigits.put('0','0');
        mirrorDigits.put('1','1');
        
        String newStr = "";
        for(int i=num.length() - 1; i>=0; i--) {
            char cur = num.charAt(i);
            if (mirrorDigits.containsKey(cur)) {
                char mirror = mirrorDigits.get(cur);
                newStr += mirror;
                
                
            } else {
                return false;
            }
        }
        return newStr.equals(num);
        
    }
}