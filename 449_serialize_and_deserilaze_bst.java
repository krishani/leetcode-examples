/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public void serial(TreeNode root, List<Integer> anser) {
        if (root!= null) {
            anser.add(root.val);
            serial(root.left, anser);
            serial(root.right, anser);
        }
    }
    
    public TreeNode deserial(int start, int end, String[] arr) {
        if (start == end) {
            return new TreeNode(Integer.parseInt(arr[start]));
            
        } if (start > end) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(arr[start]));
        
        int i = start + 1;
        while(i<arr.length && Integer.parseInt(arr[i]) < Integer.parseInt(arr[start])) {
            i++;
        }
        
        int newEnd = i;
        node.left = deserial(start + 1, newEnd-1, arr);
        node.right = deserial(newEnd, end, arr);
        return node;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        serial(root, ans);
        String x = "";
        for (int i=0; i<ans.size(); i++) {
            x += ans.get(i).toString() + ",";
        }
        return x;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] serialized = data.split(",");
        
        return deserial(0, serialized.length-1, serialized);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;