class Solution {
    
    public String count(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
             int count = 1;
             int start = Integer.parseInt(String.valueOf(s.charAt(i)));
             while(i+1 < s.length() && start == Integer.parseInt(String.valueOf(s.charAt(i+1)))) {
                 count +=1;
                 i+=1;

             }
             sb.append(count + "" + start);
        }
        return sb.toString();
    }
    
    public String countAndSay(int n) {
        String[] memo = new String[n];
        memo[0] = "1";
        for (int i=1; i<n; i++) {
            memo[i] = count(memo[i-1]);
        }
        return memo[n-1];
    }
}