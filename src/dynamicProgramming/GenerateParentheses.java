package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author 罗文俊
 * 2022/1/20
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> list = new MyGenerateParenthesesSolution1().generateParenthesis(5);
        System.out.println("我的动态规划解法");
        System.out.println(list.toString());
        System.out.println("我的回溯算法解法");
        System.out.println(new MyGenerateParenthesesSolution2().generateParenthesis(5));
    }
}

/**
 * 动态规划解法
 * 当 n = 1 时，结果为 ()
 * 当 n >= 1 时，使用子问题基础上对不同位置进行插空从而得到新问题的解
 */
class MyGenerateParenthesesSolution1 {
    public List<String> generateParenthesis(int n) {
        // 最终解都会存在这个集合中
        HashSet<String> result = new HashSet<>();
        // 用于保存每一次子问题的解
        HashSet<String> subResult = new HashSet<>();
        // n = 1 的情况给出
        result.add("()");
        if (n == 1) {
            return List.copyOf(result);
        }

        //  n = 2 以后的情况
        for (int i = 2; i <= n; i++) {
            Iterator<String> iterator = result.iterator();
            // 清空上一次子问题的解
            subResult.clear();
            while (iterator.hasNext()) {
                String next = iterator.next();
                for (int currentPos = 0; currentPos <= next.length(); currentPos++) {
                    // 左边待拼接部分
                    String left = next.substring(0, currentPos);
                    // 右边待拼接部分
                    String right = next.substring(currentPos);
                    // 拼接
                    String merge = left + "()" + right;
                    // set 自动去重
                    subResult.add(merge);
                }
                // 移除掉已经用过的子问题的解
                iterator.remove();
            }
            // 将子问题的解全部保存下来
            result.addAll(subResult);
        }
        return List.copyOf(result);
    }
}

/**
 * 回溯算法——深度优先遍历——递归实现
 * 从左往右添加左括号和右括号，直到用光所有括号
 * 其中可以单向约束，任一状态下右括号个数不能多于左括号，否则就进行剪枝
 */
class MyGenerateParenthesesSolution2 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        BFS("", n, n, result);
        return result;
    }

    /**
     * 深度优先搜索递归实现，剩下的右括号数量必须大于等于左括号数量
     *
     * @param node  当前节点
     * @param left  剩余的左边括号数量
     * @param right 剩余的右边括号数量
     */
    private void BFS(String node, int left, int right, List<String> res) {
        if (left > right || left < 0) {
            // 进行减枝
            return;
        }
        // 如果两边都是 0 了那么就直接加入结果
        if (left == 0 && right == 0) {
            res.add(node);
            return;
        }
        // 先使用左括号
        // 左括号还有剩余就先遍历左子树
        String leftNode = node + "(";
        BFS(leftNode, left - 1, right, res);
        // 右括号还有剩余且剩下的右括号多于左子树
        String rightNode = node + ")";
        BFS(rightNode, left, right - 1, res);
    }
}