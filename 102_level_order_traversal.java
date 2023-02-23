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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> outer = new ArrayList<>();
        
        if (root == null) {
            return new ArrayList();
        }
        
        queue.add(root);
        
        while(queue.size() > 0) {
            int nodesInLevel = queue.size();
            List<Integer> levelList = new ArrayList();
            for (int i=0; i<nodesInLevel; i++) {
                TreeNode removed =  queue.poll();
                levelList.add(removed.val);
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
                    
            }
            outer.add(levelList);
        }
        return outer;
    }
}