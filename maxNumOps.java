import java.util.*;

public class Main {
  
  public static int countMaxOps(String s, String t) {
    Map<Character, Integer> freqMapT = new HashMap<>();
    Map<Character, Integer> freqMapS = new HashMap<>();
    
    
    if (t.length() > s.length()) return 0;
    
    for (int i=0; i<t.length(); i++) {
      if(freqMapT.containsKey(t.charAt(i))) {
        int count = freqMapT.get(t.charAt(i)) + 1;
        freqMapT.put(t.charAt(i), count);
      } else {
        freqMapT.put(t.charAt(i), 0);
      }
    }
    
    System.out.println("T count***********" + freqMapT);
    
    for (int i=0; i<s.length(); i++) {
      char cur = s.charAt(i);
      if (freqMapT.containsKey(cur)) {
        if (freqMapS.containsKey(cur)) {
          int count = freqMapS.get(cur);
          freqMapS.put(cur, count+1);
        } else {
          freqMapS.put(cur, 0);
        }
      }
    }
    
    int minOp = Integer.MAX_VALUE;
    for (Map.Entry<Character, Integer> entry: freqMapT.entrySet()) {
      char key = entry.getKey();
      int tCount = entry.getValue();
      
      System.out.println("T count***********" + tCount);
      
      int sCount = freqMapS.get(key);
      int division = (int)Math.floor(sCount/tCount);
      if (division < minOp) {
        minOp = division;
      }
    }
    return minOp;
  }
  
    public static void main(String[] args) {
      System.out.println("Hello, World!");
      String s = "abacba";
      String t = "bca";
      int maxOp = countMaxOps(s, t);
      System.out.println("MAX OPS" + maxOp);
  }
}