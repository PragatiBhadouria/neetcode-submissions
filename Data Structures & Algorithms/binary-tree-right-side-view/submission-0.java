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
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        while(!queue.isEmpty()){

            ans.add(queue.peek().val);
            int size = queue.size();

            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();

                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
            }
        }
        return ans;
    }
}
