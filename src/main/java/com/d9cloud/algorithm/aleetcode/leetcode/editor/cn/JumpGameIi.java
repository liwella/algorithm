//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1679 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;
public class JumpGameIi{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curDistance = 0;
        int nextDistance = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(i + nums[i], nextDistance);
            if (i == curDistance) {
                if (curDistance != nums.length - 1) {
                    ans++;
                    curDistance = nextDistance;
                    if (nextDistance >= nums.length - 1) return ans;
                } else {
                    break;
                }
            }
        }
        return ans;
    }*/

    public int jump(int[] nums) {
        int ans = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextDistance = Math.max(i + nums[i], nextDistance);
            if (i == curDistance) {
                curDistance = nextDistance;
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
    }

}