package labuladuo;

/**
 * @author 罗文俊
 * 2022/2/27
 */
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int val) {
        left = null;
        right = null;
        this.val = val;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
