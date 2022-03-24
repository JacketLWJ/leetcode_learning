package dynamicProgramming;

/**
 * @author 罗文俊
 * 2022/1/23
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new MyMaximumSubarraySolution1().maxSubArray(new int[]{5,4,-1,7,8}));
    }
}

/**
 * 动态规划解法
 * 思路：
 * 遍历数组，对后一位相加和后一位进行比较
 * 子问题与原问题相关性，相当于进行简单的实现
 */
class MyMaximumSubarraySolution1 {
    public int maxSubArray(int[] nums) {
        // 保存当前比较大的位置
        int pre = 0;
        int max = 0;
        for (int num : nums) {
            // 从相加的序列和当前后一位进行比较
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }
}

/**
 * 分治算法
 */
class MyMaximumSubarraySolution2 {
    public int maxSubArray(int[] nums) {
        return 0;
    }
}

/**
 * 时间窗算法实现
 */
class MyMaximumSubarraySolution3 {
    public int maxSubArray(int[] nums) {

        return 0;
    }
}