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
    
    public boolean isSimilar(TreeNode tree1, TreeNode tree2) {                
        if (tree1 == null && tree2 == null) {
            return true;
        }
        
        if (tree1 == null || tree2 == null) {
            return false;
        }
        
        if (tree1.val == tree2.val) {
            return isSimilar(tree1.left, tree2.left) && isSimilar(tree1.right, tree2.right);
        }
        return false;
        
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        
        if (root == null || subRoot == null) return false; 
        
        boolean isRootSimilar = isSimilar(root, subRoot);
        
        if (isRootSimilar) return true;
        
        boolean isChildrenSimilar =  isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        return isChildrenSimilar;
    }
}