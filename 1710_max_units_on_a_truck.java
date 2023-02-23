class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        for (int i=0; i<boxTypes.length; i++) {
            queue.add(boxTypes[i]);
        }
        
        
        int maxNumOfUnits = 0;
        int unFilledBoxCount = truckSize;
        
        while(unFilledBoxCount > 0 && queue.size() > 0) {
            int[] box = queue.poll();
            if (unFilledBoxCount >= box[0]) {
                unFilledBoxCount -= box[0];
                maxNumOfUnits += box[0] * box[1];
            } else {
                maxNumOfUnits += unFilledBoxCount * box[1];
                unFilledBoxCount = 0;
            }
        }
        return maxNumOfUnits;  
    }
}
