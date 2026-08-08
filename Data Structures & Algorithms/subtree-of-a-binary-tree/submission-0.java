/*
edge case - both roots null return true

Optimal solution - DFS with Recursion
1. ill traverse each node.
2. for each node ill check if node.val == subroot.val,
3. if same check both left and right nodes
4. else, move forward to next node to comapre

TC - O(nxm)
SC - O(h) recursion stack
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    //helper
    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;

        if(p == null || q == null) return false;

        return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
