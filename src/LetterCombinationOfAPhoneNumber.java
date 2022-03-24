import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 罗文俊
 * 2022/1/23
 */
public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new MyLetterCombinationSolution2().letterCombinations("2"));
    }
}

/**
 * 回溯法实现求解过程，非递归过程
 */
class MyLetterCombinationSolution1 {
    public List<String> letterCombinations(String digits) {
        // 使用哈希表存储各种结果
        HashMap<Character, char[]> numToChar = new HashMap<>();
        numToChar.put('2', new char[]{'a', 'b', 'c'});
        numToChar.put('3', new char[]{'d', 'e', 'f'});
        numToChar.put('4', new char[]{'g', 'h', 'i'});
        numToChar.put('5', new char[]{'j', 'k', 'l'});
        numToChar.put('6', new char[]{'m', 'n', 'o'});
        numToChar.put('7', new char[]{'p', 'q', 'r', 's'});
        numToChar.put('8', new char[]{'t', 'u', 'v'});
        numToChar.put('9', new char[]{'w', 'x', 'y', 'z'});
        // 将目标转为字符数组
        char[] target = digits.toCharArray();
        // 结果集合
        Set<String> result = new HashSet<>();

        for (char c : target) {
            // 获取目标可能
            char[] chars = numToChar.get(c);
            if (result.isEmpty()) {
                // 初始化结果集合
                for (char aChar : chars) {
                    result.add(String.valueOf(aChar));
                }
            } else {
                for (String s : result) {
                    for (char aChar : chars) {
                        result.add(s + aChar);
                    }
                    result.remove(s);
                }
            }
        }
        return result.stream().toList();
    }
}

/**
 * 回溯法——递归实现
 */
class MyLetterCombinationSolution2 {
    public List<String> letterCombinations(String digits) {
        // 使用哈希表存储各种结果
        HashMap<Character, char[]> numToChar = new HashMap<>();
        numToChar.put('2', new char[]{'a', 'b', 'c'});
        numToChar.put('3', new char[]{'d', 'e', 'f'});
        numToChar.put('4', new char[]{'g', 'h', 'i'});
        numToChar.put('5', new char[]{'j', 'k', 'l'});
        numToChar.put('6', new char[]{'m', 'n', 'o'});
        numToChar.put('7', new char[]{'p', 'q', 'r', 's'});
        numToChar.put('8', new char[]{'t', 'u', 'v'});
        numToChar.put('9', new char[]{'w', 'x', 'y', 'z'});

        char[] chars = digits.toCharArray();
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        return BFS(chars, 0, null, numToChar);
    }

    /**
     * 广度优先搜索——递归实现
     */
    private List<String> BFS(char[] digitsChar, int pos,
                             String parent, HashMap<Character, char[]> numToChar) {
        if (pos == digitsChar.length) {
            // 如果到达叶子节点直接
            return Collections.singletonList(parent);
        }
        char[] posChars = numToChar.get(digitsChar[pos]);
        List<String> result = new ArrayList<>();
        if (parent == null) {
            // 初始化结果
            for (char posChar : posChars) {
                result.addAll(BFS(digitsChar, pos + 1, String.valueOf(posChar), numToChar));
            }
        } else {
            // 如果存在父亲节点
            for (char posChar : posChars) {
                result.addAll(BFS(digitsChar, pos + 1, parent + posChar, numToChar));
            }
        }
        return result;
    }
}