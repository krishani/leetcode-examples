class Solution {
        
    
    
    /**
    VISITED = [FALSE, FALSE, FALSE, FALSE, FALSE]
    START - 0  PARENT -1                               
    VISITED = [TRUE, FALSE, FALSE, FALSE, FALSE]
    1,2,3
    
    
    START - 2 PARENT 0
    VISITED = [TRUE, true, TRUE, FALSE, TRUE]
    
    FOR 0
    
    START 3 PARENT 0
    VISITED = [TRUE, true, TRUE, visited, TRUE]
    
    
    
    START 1 PARENT 0
    VISITED = [TRUE, true, FALSE, FALSE, FALSE]
    0, 4
    
    START 4 PARENT 1
    VISITED = [TRUE, true, FALSE, FALSE, TRUE]
    1
    
    **/
    
    public boolean isCycle(int start, int parent, boolean[] visited, Map<Integer, List<Integer>> neighbours) {
       visited[start] = true;
       System.out.println("START****" + start);
       List<Integer> adgacentNodes = neighbours.get(start);
       for (int i=0; i<adgacentNodes.size(); i++) {
           int adgacentNode = adgacentNodes.get(i);
           boolean isAdjacentNodeVisisted = visited[adgacentNode];
           if (isAdjacentNodeVisisted && adgacentNode != parent) {
               System.out.println("CYCLE FOUND************" +  "start***** "  + start +" " + adgacentNode + "parent node***" + parent);
               return true;
           }
           if (!isAdjacentNodeVisisted) {
               return isCycle(adgacentNode, start, visited, neighbours);
           }
       }
        System.out.println("CYCLE NOT FOUND************" +  "start***** "  + start);
       return false;
    }
    
    public Map<Integer, List<Integer>> getAdjacencyMatrix(int n, int[][] edges) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        
        for (int i=0; i<edges.length; i++) {
            int[] adjacentNodes = edges[i];
            
            if (neighbors.containsKey(adjacentNodes[0])) {
                List<Integer> adjList = neighbors.get(adjacentNodes[0]);
                adjList.add(adjacentNodes[1]);
                neighbors.put(adjacentNodes[0], adjList);
                
            } else {
                List<Integer> adjList1 = new ArrayList<>();
                adjList1.add(adjacentNodes[1]);
                neighbors.put(adjacentNodes[0], adjList1);
            }
            
            if (neighbors.containsKey(adjacentNodes[1])) {
                List<Integer> adjList2 = neighbors.get(adjacentNodes[1]);
                adjList2.add(adjacentNodes[0]);
                neighbors.put(adjacentNodes[1], adjList2);
                
            } else {
                List<Integer> adjList3 = new ArrayList<>();
                adjList3.add(adjacentNodes[0]);
                neighbors.put(adjacentNodes[1], adjList3);
            }
            
        }
        System.out.println("NEIGHBOURS" + neighbors);
        return neighbors;
    }
    
    
    public boolean validTree(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> neighbors = getAdjacencyMatrix(n, edges);
        boolean[] visited = new boolean [n];
        int start = 0;
        boolean cycleFound = isCycle(start, -1, visited, neighbors);
        
        /*
        pRINT THE VISITED ARRAY
        */
        for (int k=0; k<visited.length; k++) {
            System.out.println("visited nodes" + k + " val" + visited[k]);
        }
        
        
        boolean notCoonectedNodeFound = false;
        for (int j=0; j<visited.length; j++) {
            if (visited[j] == false) {
                notCoonectedNodeFound = true;
                System.out.println("NOT CONNECTED FOUND" + j);
                return false;
            }
        }
        return !cycleFound && !notCoonectedNodeFound;
    }
}