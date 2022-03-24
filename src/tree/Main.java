package tree;

import org.w3c.dom.Node;

import java.util.Stack;

/**
 * @author 罗文俊
 * 2022/3/19
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();
    }
}
