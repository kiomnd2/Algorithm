package leetcode.p108;


class TreeNode {

    public TreeNode(int x) { val = x; }

    /*      public TreeNode(int val, TreeNode left, .TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }*/
    int val;
    TreeNode left;
    TreeNode right;

}
public class ConvertSortedArraytoBinarySearchTree {


    public static void main(String[] args) {
        //Given the sorted array: [-10,-3,0,5,9],
        //
        //One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
        //     0
        //     / \
        //   -3   9
        //   /   /
        // -10  5

    }
    public static TreeNode sortedArrayToBST(int[] nums)
    {
        //heightbalanceTree
        int l  = 0 ;
        int r = nums.length -1 ;
        return  getBalance(nums, l,r);

    }

    public static TreeNode getBalance(int[] nums, int l, int r)
    {
        if(r<l) return null;

        int mid = l+r/2;

        //현재노드
        TreeNode node = new TreeNode(nums[mid]);
        //왼쪽
        node.left = getBalance(nums, l, mid-1);
        //오른쪽
        node.right = getBalance(nums, mid+1, r);

        return node;
    }

}
