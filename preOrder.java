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
    
    public TreeNode bst(int start, int end, int[] preorder) {
        if (start >= end) {
            return new TreeNode(preorder[0]);
        }
        TreeNode node = new TreeNode(preorder[start]);
        
        // 8 
            // left 1, 3(5,1,7)    // 5
                                     // left 2 2 (1,1)
                                     // right 3 3 (7,7)
                             
            // right 4, 5(10,12)        //10
                                          // 
        
        // find the first number which is greater than root
        int i = start + 1;
        while(i<preorder.length && preorder[i] < preorder[start]) {
            i++;
        }
        
        int newEnd = i;
        System.out.println("new end" + newEnd);

        node.left = bst(start + 1, newEnd-1, preorder);
        node.right = bst(newEnd, end, preorder);
        return node;
        
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(0, preorder.length-1, preorder);
    }
}