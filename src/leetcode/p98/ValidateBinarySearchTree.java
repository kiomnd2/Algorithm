package leetcode.p98;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {

       /* System.out.println(isValidBST(new TreeNode(5
                , new TreeNode(1)
                , new TreeNode(4, new TreeNode(3) , new TreeNode(6))
        )));*/
        System.out.println(isValidBST(new TreeNode(2,new TreeNode(1), new TreeNode(3))));
    }

    public static boolean isValidBST(TreeNode root) {
        return valid(root, null, null);

    }
    public static boolean valid (TreeNode root, TreeNode left, TreeNode right)
    {
        if(root == null) return true;

        if( left != null && root.val <= left.val) return false;

        if( right != null && root.val >= right.val) return false;

        return valid(root.left, left, root) && valid(root.right, root, right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}