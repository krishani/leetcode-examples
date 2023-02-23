class Solution {
    public int numTrees(int n) {
        
        // G(n) = F(1, n) + F(2, n) + F(3, n) + F(4, n) ....................+ F(n,n)
        
        // F(1, n) = G(0) * G(n-1)
        // F(2, n) = G(1) * G(n-2)
        // F(3, n) = G(2) * G(n-3)
        // .....
        // G(0) = 1
        // G(1) = 1
        // G(2) = G(0)*(G1) + G(1)*G(0)
        // G(3) = G(0)*G(2) + G(1)*G(1) + G(2)*G(0)
        
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i=2; i<=n; i++) {
            int catalanI = 0;
            for(int j=0; j<i; j++) {
                catalanI += catalan[j]*catalan[i-j-1];
            } 
            catalan[i] = catalanI;
        }
        return catalan[n];  
    }
}