package dynamicProgramming;

/**
 * @author 罗文俊
 * 2022/3/24
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("caba"));
    }

    public String longestPalindrome(String s) {
        // 记录上一次最长位置
        int iMax = 0;
        int jMax = 0;
        // 转换为字符数组
        char[] chars = s.toCharArray();
        // DP Table
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化条件
        for (int i = 0; i < s.length(); i++) {
            // 只有一个子串时为回文串
            dp[i][i] = true;
            iMax = jMax = i;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            // 对于回文串长度为 2，时两字符相等即可
            if (chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                iMax = i;
                jMax = i + 1;
            }
        }

        // 字符长度为 3 以上
        for (int k = 2; k < s.length(); k++) {
            for (int i = 0; i < s.length() - k; i++) {
                // 状态转移方程
                if (dp[i + 1][i + k - 1] && chars[i] == chars[i + k]) {
                    dp[i][i + k] = true;
                    iMax = i;
                    jMax = i + k;
                }
            }
        }

        return s.substring(iMax, jMax + 1);
    }
}
