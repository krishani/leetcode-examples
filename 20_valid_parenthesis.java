class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> openingBracketsByClosing = new HashMap<>();
        openingBracketsByClosing.put(')', '(');
        openingBracketsByClosing.put(']', '[');
        openingBracketsByClosing.put('}', '{');  
        
        Stack<Character> openingBracketsTracker = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                openingBracketsTracker.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (openingBracketsTracker.size() == 0) {
                    return false;
                } else {
                    char immediateOpeningBracket = openingBracketsTracker.pop();
                    char expectedOpeningBracket = openingBracketsByClosing.get(s.charAt(i));
                    if (immediateOpeningBracket != expectedOpeningBracket) {
                        return false;
                    }
                }                
            }
        }
        if (openingBracketsTracker.size() > 0) return false;
        return true;
    }
}