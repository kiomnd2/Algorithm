package leetcode.p1022;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}


public class SumofRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
        node.right = new TreeNode(1);





        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);

        node.right.right = new TreeNode(0);
        node.right.left = new TreeNode(1);






        System.out.println(sumRootToLeaf(node));
    }

    public static int sumRootToLeaf(TreeNode root)
    {
        //Input: [1,0,1,0,1,0,1]
        //Output: 22
        //Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
        int result = 0;
        int res = recursive(root, 0);
        return res;
    }
    public static int recursive(TreeNode node, int sum)
    {
        System.out.println(" node : " + node.val + " sun : " + sum);

        if(node ==null)
        {
            return 0 ;
        }

        if(node.left ==null && node.right ==null)
        {
            return (node.val + sum);
        }
        return recursive(node.left, (node.val+ sum) *2) + recursive(node.right, (node.val+sum) *2);
    }


}
