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
    
    
    public List<Integer> inOrderTraversal(TreeNode root, List<Integer> order) {
        if (root != null) {
            if (root.left != null) {
                inOrderTraversal(root.left, order);
            }
            order.add(root.val);
            if (root.right != null) {
                inOrderTraversal(root.right, order);
            }
        }
        return order;
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> answer = new ArrayList<>();
        
        inOrderTraversal(root, answer);
        return answer.get(k-1);
        
    }
}