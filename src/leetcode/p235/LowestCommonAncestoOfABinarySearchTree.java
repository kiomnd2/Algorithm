package leetcode.p235;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestoOfABinarySearchTree {
    public static void main(String[] args) {

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        //Output: 6
        //Explanation: The LCA of nodes 2 and 8 is 6.

        System.out.println("node  : " + root.val );
        System.out.println("p : " + p.val);
        System.out.println("q : " + q.val);

        /**
         *              6
         *            2   8
         *          0  4  7  9
         */

        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else {
            return root;
        }
    }

}
