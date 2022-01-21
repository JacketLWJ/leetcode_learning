package linkedlist;

/**
 * @author 罗文俊
 * 2022/1/21
 * 两数相加
 */
public class AddTwoNumber {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += node.val + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        ListNode l1 = stringToListNode("[9,9,1]");
        ListNode l2 = stringToListNode("[1]");

        ListNode ret = new MyAddTwoNumberSolution1().addTwoNumbers(l1, l2);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 最简单的思路：
 * 分别遍历如果，同时记下进位
 */
class MyAddTwoNumberSolution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 最终结果
        ListNode result = new ListNode();
        ListNode head = result;
        // 进位标志
        int add = 0;
        int c = 0;
        // 取出第一个数字进行相加
        add = l1.val + l2.val;
        if (add >= 10) {
            c = 1;
            add = add % 10;
        }
        // 保存结果
        head.val = add;
        // 移动游标
        l1 = l1.next;
        l2 = l2.next;
        while (true) {
            if (l1 == null && l2 == null) {
                if (c == 1) {
                    head.next = new ListNode(1);
                }
                break;
            }
            if (l1 == null) {
                add = l2.val + c;
                c = 0;
                if (add >= 10) {
                    c = 1;
                    add = add % 10;
                }
                head.next = new ListNode(add);
                l2 = l2.next;
            } else if (l2 == null) {
                add = l1.val + c;
                c = 0;
                if (add >= 10) {
                    c = 1;
                    add = add % 10;
                }
                head.next = new ListNode(add);
                l1 = l1.next;
            } else {
                add = l1.val + l2.val + c;
                if (add >= 10) {
                    c = 1;
                    add = add % 10;
                } else {
                    c = 0;
                }
                head.next = new ListNode(add);
                l1 = l1.next;
                l2 = l2.next;
            }
            head = head.next;
        }
        return result;
    }
}