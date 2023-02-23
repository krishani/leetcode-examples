/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isInLeftSubTree(TreeNode leftRoot, TreeNode p) {
        if (leftRoot == null) {
            return false;
        }
        if (leftRoot.val == p.val) {
            return true;
        }
        return isInLeftSubTree(leftRoot.left, p) || isInLeftSubTree(leftRoot.right, p);
    }
    
    public TreeNode lowestCommon(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        
        boolean isPInLeft = isInLeftSubTree(root.left, p);
        boolean isQInLeft = isInLeftSubTree(root.left, q);
        
        if (isPInLeft && isQInLeft) {
            return lowestCommon(root.left, p, q);
        }
        
        if (!isPInLeft && !isQInLeft) {
            return lowestCommon(root.right, p, q);
        }
        
        return root;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommon(root, p, q);
        
    }
}