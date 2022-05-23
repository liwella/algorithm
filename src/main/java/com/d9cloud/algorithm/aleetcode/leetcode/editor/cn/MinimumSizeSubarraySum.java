//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 1169 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;
public class MinimumSizeSubarraySum{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE; // 最终长度
        int subLength = 0; // 滑动窗口长度
        int sum = 0; // 滑动窗口的总大小
        int start = 0; // 滑动窗口起始位置
        int end = 0; // 滑动窗口结束位置
        for (; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                subLength = end - start + 1;
                result = Math.min(result, subLength);
                sum -= nums[start++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
    }

}