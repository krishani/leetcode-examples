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
    
    public TreeNode toBST(int[]subTree) {
        if (subTree.length == 0) {
            return null;
        }
        if (subTree.length == 1) {
            return new TreeNode(subTree[0]);
        }
        
        int left = subTree[0];
        int mid = (subTree.length-1)/2 ;
        TreeNode tr = new TreeNode(subTree[mid]);
        tr.left = toBST(Arrays.copyOfRange(subTree, 0, mid));
        tr.right = toBST(Arrays.copyOfRange(subTree, mid+1, subTree.length));
        return tr;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums);
    }
}