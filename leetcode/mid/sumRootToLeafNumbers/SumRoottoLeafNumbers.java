
List<String> numberList = new ArrayList<>();
public int sumNumbers(TreeNode root) {

    dfs(root, "" + root.val);

    int sum =0;
    for (String s : numberList) {
        sum += Integer.parseInt(s);
    }

    return sum;
}

public void dfs(TreeNode node, String number) {
    if (node.left == null && node.right == null) {
        numberList.add(number);
    }

    if (node.left != null) {
        dfs(node.left, number + node.left.val);
    }

    if (node.right != null) {
        dfs(node.right, number + node.right.val);
    }
}

static class TreeNode {
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