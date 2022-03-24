package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author 罗文俊
 * 2022/3/24
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<HashSet<String>> dp = new ArrayList<>();
        if (n == 0) {
            return Collections.emptyList();
        }

        HashSet<String> oneSet = new HashSet<>();
        oneSet.add("()");
        dp.add(new HashSet<>());
        dp.add(oneSet);
        if (n == 1) {
            return new ArrayList<>(oneSet);
        }

        for (int i = 2; i <= n; i++) {
            HashSet<String> tempSet = new HashSet<>();
            for (String s : dp.get(i - 1)) {
                // 三种情况进行添加
                tempSet.add("(" + s + ")");
                tempSet.add(s + "()");
                tempSet.add("()" + s);
            }
            dp.add(tempSet);
        }

        return new ArrayList<>(dp.get(n));
    }
}
