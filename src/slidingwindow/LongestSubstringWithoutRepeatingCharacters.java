package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 罗文俊
 * 2022/1/21
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * 通过次数1,439,308提交次数3,749,404
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new MyLongestSubstringWithoutRepeatingCharactersSolution2().lengthOfLongestSubstring("bbbbb"));
    }
}

/**
 * 动态规划解法
 */
class MyLongestSubstringWithoutRepeatingCharactersSolution1 {
    public int lengthOfLongestSubstring(String s) {
        // 备忘录
        return 0;
    }
}

/**
 * 滑动窗口算法——Map实现
 * 1. 从左边开始增大窗口右边界
 * 2. 如果右边界的字符不在哈希表中，则继续增大右边界
 * 3. 如果右边界的字符出现在哈希表中，且重复位置位于边界内，则将左边界滑动到出现重复字符的右边
 * 哈希表表示当前左边界和右边界（包含边界）的不重复字符数
 */
class MyLongestSubstringWithoutRepeatingCharactersSolution2 {
    public int lengthOfLongestSubstring(String s) {
        // 窗口值
        int maxLength = 0;
        int currentLength;
        int left, right;
        left = right = 0;
        // 转为字符数组以便进行操作
        char[] target = s.toCharArray();
        // 用于指明重复的位置
        Integer repeatPos;
        // 窗口字符映射其位置
        Map<Character, Integer> winChars = new HashMap<>();
        while (right <= target.length - 1) {
            repeatPos = winChars.get(target[right]);
            if (repeatPos != null && repeatPos >= left) {
                // 如果出现重复字符，且重复的位置在边界内，则将 left 移动到重复字符之后
                left = winChars.get(target[right]) + 1;
            } else {
                // 如果没有出现重复字符，则比较当前窗口值是否大于最大值
                currentLength = right - left + 1;
                maxLength = Math.max(currentLength, maxLength);
            }
            // 将窗口右边界加入哈希表，或者更新最近重复位置
            winChars.put(target[right], right);
            // 右边界不断移动
            right++;
        }
        return maxLength;
    }
}

/**
 * 滑动窗口算法——Set实现
 * 1. 从左边开始增大窗口右边界
 * 2. 如果右边界的字符不在哈希表中，则继续增大右边界
 * 3. 如果右边界的字符出现在哈希表中，且重复位置位于边界内，则将左边界滑动到出现重复字符的右边
 * 哈希表表示当前左边界和右边界（包含边界）的不重复字符数
 */
class MyLongestSubstringWithoutRepeatingCharactersSolution3 {
    public int lengthOfLongestSubstring(String s) {
        // 窗口值
        int maxLength = 0;
//        int currentLength;
//        int left, right;
//        left = right = 0;
//        // 转为字符数组以便进行操作
//        char[] target = s.toCharArray();
//        // 用于指明重复的位置
//        Integer repeatPos;
//        // 窗口字符映射其位置
//        Set<Character> winChars = new HashSet<>();
//        while (right <= target.length - 1) {
//            repeatPos = winChars.get(target[right]);
//            if (repeatPos != null && repeatPos >= left) {
//                // 如果出现重复字符，且重复的位置在边界内，则将 left 移动到重复字符之后
//                left = winChars.get(target[right]) + 1;
//            } else {
//                // 如果没有出现重复字符，则比较当前窗口值是否大于最大值
//                currentLength = right - left + 1;
//                maxLength = Math.max(currentLength, maxLength);
//            }
//            // 将窗口右边界加入哈希表，或者更新最近重复位置
//            winChars.put(target[right], right);
//            // 右边界不断移动
//            right++;
//        }
        return maxLength;
    }
}