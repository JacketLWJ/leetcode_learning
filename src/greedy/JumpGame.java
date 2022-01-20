package greedy;

/**
 * @author 罗文俊
 * 2022/1/19
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(new JumpGameSolution().canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(new JumpGameSolution().canJump(nums));
    }
}

/**
 * 跳跃游戏贪心题解
 */
class JumpGameSolution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        int current;
        for (int i = 0; i < nums.length; i++) {
            current = i + nums[i];
            if (current >= furthest && i <= furthest) {
                // 为达到连续可达，当前位置必须小于等于当前记录的最远可达距离
                furthest = current;
            }
        }
        return furthest >= nums.length - 1;
    }
}
