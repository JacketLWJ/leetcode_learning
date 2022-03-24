package tree;

import java.util.Stack;

/**
 * @author 罗文俊
 * 2022/3/23
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        return false;
    }
}
