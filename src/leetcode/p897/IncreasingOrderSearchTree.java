package p897;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {

        increasingBST(new TreeNode(5,
                new TreeNode(3, new TreeNode(2, new TreeNode(1), null),null),
                new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9)))));
    }

    public static TreeNode increasingBST(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        recursive(list, root);

        TreeNode treeNode = new TreeNode(list.get(0));
        TreeNode head = treeNode;
        for (int i=1; i<list.size() ; i++) {
            treeNode.right = new TreeNode(list.get(i));
            treeNode = treeNode.right;
        }


        return head ;
    }

    public static TreeNode recursive(ArrayList<Integer> list, TreeNode node) {

        if (node.left != null) {
            recursive(list, node.left);
        }

        list.add(node.val);

        if (node.right != null) {
            recursive(list, node.right);
        }
        return node;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
