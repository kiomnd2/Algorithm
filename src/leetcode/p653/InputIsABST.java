package leetcode.p653;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarOutputStream;

class TreeNode {

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}

public class InputIsABST {
    public static void main(String[] args) {

        //    5
        //   / \
        //  3   6
        // / \   \
        //2   4   7
        TreeNode treeNode = new TreeNode(5,
                new TreeNode( 3 , new TreeNode(2, null , null ),
                        new TreeNode( 4, null, null)),
                new TreeNode(6, null,
                        new TreeNode(7,null,null)));

        System.out.println(findTarget(treeNode, 9));
    }


    public static boolean findTarget(TreeNode root, int k)
    {
        boolean ans = false;
        ArrayList<TreeNode> list = new ArrayList<>();

        //중위순회로 정렬
        rounds(list, root);
        list.forEach((treeNode -> {
            System.out.println(treeNode.val);
        }));

        int l = 0 ;
        int r = list.size()-1;

        while( l < r )
        {
   /*         System.out.println( "l : " + l);
            System.out.println( "r : " + r);*/

            int sum = list.get(l).val + list.get(r).val;
            if(sum > k) r = r -1;
            else if(sum < k) l = l +1;
            else return true; // 같을경우
        }
        return ans;
    }

    public static void rounds(List list, TreeNode root)
    {
        if(root == null) return;
        rounds(list, root.left);
        list.add(root);
        rounds(list, root.right);
    }

}
