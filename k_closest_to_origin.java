
class Solution {
    
     
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        Map<Integer, List<int[]>> myMap = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if (myMap.containsKey(distance)) {
                List<int[]> ls = myMap.get(distance);
                ls.add(points[i]);
                myMap.put(distance, ls);
            }
            maxHeap.add(points[i]);
            if (maxHeap.size() > k +1) {
                maxHeap.poll();
            }
           
        }
        maxHeap.poll();
        System.out.println("MAX HEAP "+ maxHeap.peek()[0] + maxHeap.peek()[1]);
        int kDis = maxHeap.peek()[0] * maxHeap.peek()[0] + maxHeap.peek()[1] * maxHeap.peek()[1];
        List<int[]> ans = myMap.get(kDis);
        System.out.println("ANS "+ ans);
        int[][] a = new int [ans.size()][2];
        for (int j=0; j<ans.size(); j++) {
            a[j] =ans.get(j);
        }
        return a;
    }
}