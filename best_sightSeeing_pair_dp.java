class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        /*
        8,1,5,2,6
        8,1                         8 1. + (0-1)
           
        8,1,5           1,5         8  1 + 5 + ( 0 1-2)  = 6 - 1 = 5 max -1-1+8+0 = 11
        8,1,5,2         1, 5, 2     8  1 + 2 + ( 0 1 -3) = 3 - 2 = 1
        8,1,5,2,6       1, 5, 2,6    8 1 + 6 +  (  0 1 -4) = 7 - 3 = 4
        */
        int[] maxScore = new int [values.length];
        
        maxScore[values.length-2] = values[values.length-2] + values[values.length-1] + (values.length-2) -(values.length-1);
        
        for (int i=values.length-3; i>=0; i--) {
            int newScore = values[i] + values[i+1] + i-(i+1);
            int prevScore = maxScore[i+1] - values[i+1] - (i+1) + values[i] + i; 
                
            maxScore[i] = Math.max(newScore, prevScore);
        }
        
        int maxPair = 0;
        for (int j=0; j<maxScore.length-1; j++) {
            if (maxScore[j] > maxPair) {
                maxPair = maxScore[j];
            }
        }
        return maxPair;
    }
}