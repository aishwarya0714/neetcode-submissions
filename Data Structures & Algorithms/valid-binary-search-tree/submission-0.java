/*
edge case =
root = null, return null

Optimal approach
- ill use range(min,max)
- when i move to left node: max = root, so node should be in the range(min,root)
- when i move to right node: min = root, so node should br in the range(root,max)


*/
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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    //helper
    private boolean isValid(TreeNode node, long min, long max){
        if(node == null) return true;

        if(node.val <= min || node.val >= max) return false;

        return isValid(node.left,min,node.val) && isValid(node.right, node.val,max);
    }
}
