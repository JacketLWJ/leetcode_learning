import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 罗文俊
 * 2022/1/24
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new MyThreeSumSolution().threeSum(new int[]{1,-1,-1,0}));
    }
}

/**
 * 排序后使用折半查找来实现
 */
class MyThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 结果集合
        List<List<Integer>> result = new ArrayList<>();
        // 对数组进行排序
        Arrays.sort(nums);
        // 用来标记上一次枚举过的值
        int lastI = 0, lastJ = 0, lastK = 0;
        // 排序后枚举结果满足条件 a <= b <= c，即 nums[i] <= num[j] <= num[k]
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == lastI) {
                // 如果上次枚举过了则直接跳过
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == lastJ) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k != j + 1 && nums[k] == lastK) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }
                    lastK = nums[k];
                }
                lastJ = nums[j];
            }
            lastI = nums[i];
        }
        return result;
    }
}