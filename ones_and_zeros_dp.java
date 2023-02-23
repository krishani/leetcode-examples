class Solution { 
    public int getMaxSubSets(String[] strs, int [][] oneZeroCounts, int m, int n, int i, int [][][] memo) {
        int ifSelectedLength = 0;
        int ifNotSelectedLength = 0;
        
        if ((i == strs.length) || (m == 0 && n==0)) {
            return 0;
        }
        String toConsider = strs[i];
        
        if (memo[m][n][i] > 0) {
            return memo[m][n][i];
        }
        if ((!(oneZeroCounts[i][0] > m) && !(oneZeroCounts[i][1] > n))) {
            ifSelectedLength = 1 + getMaxSubSets(strs, oneZeroCounts, m-oneZeroCounts[i][0], n-oneZeroCounts[i][1], i+1, memo);
        } 
        ifNotSelectedLength = getMaxSubSets(strs, oneZeroCounts, m, n, i+1, memo);
        
        memo[m][n][i] = Math.max(ifSelectedLength, ifNotSelectedLength);
        return memo[m][n][i];
        
    }
    
    public int[][] buildOneZeroCount(String[] strs) {
        int [][] oneZeroCounts = new int[strs.length][2]; 
        
        for (int i=0; i<strs.length; i++) {
            String s = strs[i];
            int count0 = 0;
            int count1 = 1;
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(j) == '0') {
                   count0 += 1; 
                }
            }
            count1 = s.length() - count0;
            oneZeroCounts[i][0] = count0;
            oneZeroCounts[i][1] = count1;
        }
        
        return oneZeroCounts;
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] oneZeroCount = buildOneZeroCount(strs);
        int [][][] memo = new int [m + 1][n + 1][strs.length];
        /*
        10, 0001, 111001, 1, 0
         select 10 - m 3 n-2 
                            select 0001  - m 0 n-1      
                                                       select 111001  - x
                                                       not select 111001  m0 n1 
                                                                                select 1     m0 n0 - 0 x
                                                                                not select 1 m0 n1       select 0 x -     
                                                                                                        not select 0  m0 n1 x
                            not select 0001 - m3 n 2   
                                                       select 111001  - x
                                                       not select 111001 m3 n2 
                                                                            select 1         m3 n1      
                                                                                                         select 0   m2 n1 x
                                                                                                         not select 0 m3 n1 x
                                                                            not select 1     m3 n2
                                                                                                         select 0    m2 n2 x
                                                                                                        not select 0 m3 n2 x
         not select 10 - m4 n3
                             select 0001   - m1 n2    
                                                       select 111001   -x
                                                       not select 111001 m1 n2
                                                                                select 1     m1 n1      
                                                                                                        select 0    m0 n1 x
                                                                                                        not select 0 m1 n1 x
                                                                            not select 1     m1 n2
                                                                                                       select 0  m0 n2
                                                                                                      not select 0 m1 n2
                             not select 0001- m4 n3
                                                       select 111001   -x
                                                       not select 111001 m4 n3
                                                                               select 1      m4 n2
                                                                                                      select 0   m3 n2
                                                                                                     not select 0 m4 n2
                                                                             not select 1    m4 n3
                                                                                                     select 0    m3 n3
                                                                                                    not select 0 m4 n3
        
        */
       return getMaxSubSets(strs, oneZeroCount, m, n, 0, memo);
    }
}