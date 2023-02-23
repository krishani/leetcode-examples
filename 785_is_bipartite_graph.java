class Solution {
    public boolean isBipartite(int[][] graph) {
        
        Map<Integer, Integer> seenMap = new HashMap<>();
        
        Queue<int[]> queue = new LinkedList<>();  //{ nodeId, set }
        
        queue.add(new int[] {0, 0}); // Add source
        seenMap.put(0, 0);// we have seen this node 0 and it belongs to set 0
                
        while(!queue.isEmpty()) {
            int[] removed = queue.poll();
            
            int node = removed[0];
            int setId = removed[1];
            
            int [] neighbours = graph[node];
            for (int i=0; i<neighbours.length; i++) {
                // check if the neighbour is already seen and if so check the set id of the node
                // set id in the map should be equal to the opposite set id of parent.
                int neighbour = neighbours[i];
                int setIdFromParent = setId == 0 ? 1 : 0;
                if (seenMap.containsKey(neighbour)) {
                    int setIdInMap = seenMap.get(neighbour);
                    if (setIdInMap != setIdFromParent) {
                        return false;
                    }
                    
                } else {
                   queue.add(new int[] {neighbour, setIdFromParent});
                   seenMap.put(neighbour, setIdFromParent);
                }
            } 
        }
        for (int j=0; j<graph.length; j++) {
            if (!seenMap.containsKey(j)) {
                return false;
            }
        }
        return true;
    }
}