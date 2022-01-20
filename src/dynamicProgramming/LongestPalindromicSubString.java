package dynamicProgramming;

import java.util.Arrays;

/**
 * @author 罗文俊
 * 2022/1/18
 * 最长回文串动态规划解法
 */
public class LongestPalindromicSubString {
    public static void main(String[] args) {

    }
}

/**
 * 我的题解——动态规划解法
 */
class LongestPalindromicSolution {
    public String longestPalindrome(String s) {
        // 目标串转为字符数组
        char[] target = s.toCharArray();
        // 创建备忘录
        boolean[][] backup = new boolean[s.length()][s.length()];
        // 记录最长字串的位置
        int maxI = 0, maxJ = 0;
        int j;
        // 对于长度为 1 的情况来说那就都是了
        for (int i = 0; i < target.length; i++) {
            backup[i][i] = true;
            maxI = i;
            maxJ = i;
        }
        // 对于长度为 2 的情况，比较相邻两个字串是否相等
        for (int i = 0; i < target.length - 1; i++) {
            j = i + 1;
            if (target[i] == target[j]) {
                backup[i][j] = true;
                maxI = i;
                maxJ = j;
            } else backup[i][j] = false;
        }
        // 对于长度为 n 的情况
        for (int k = 3; k <= target.length; k++) {
            // 外层控制每一次子问题递增
            for (int i = 0; i <= target.length - k; i++) {
                j = i + k - 1;
                // 内层循环控制每个子问题记录
                if (backup[i + 1][j - 1]) {
                    // 如果P(i+1, j-1)为回文子串，那么比较当前 i 和 j 是否相等
                    if (target[i] == target[j]) {
                        backup[i][j] = true;
                        maxI = i;
                        maxJ = j;
                    } else backup[i][j] = false;
                }
            }
        }

        return String.copyValueOf(Arrays.copyOfRange(target, maxI, maxJ + 1));
    }
}

/**
 * 回溯算法：深度优先搜索
 * 从解空间开始搜索，最终如果深度搜索结果收敛为
 */
class BacktrackingSolution {
    public String longestPalindrome(String s) {
        // 转为字符数组
        char[] target = s.toCharArray();
        while (true) {
            // 外层控制每一个深度优先搜索策略
        }
    }
}

/**
 * 官方题解，动态规划
 */
class OfficialSolution1 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

/**
 * 官方题解，中心扩展算法
 */
class OfficialSolution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}