/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
       Queue<TreeNode> queue = new ArrayDeque<>();
        
        List<Integer> answer = new ArrayList<>();
        
        if (root == null) return answer;
        
        queue.add(root);
        
        while(queue.size() >0) {
            // we need to get all the nodes in a given level
            int queueSize = queue.size();
            
            TreeNode lastNodeInLevel = root;
            for (int i=0; i<queueSize; i++) {
                TreeNode node = queue.remove();
                lastNodeInLevel = node;
                
                if (node.left !=null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            answer.add(lastNodeInLevel.val);
        }
        return answer;
    }
}