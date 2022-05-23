//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 
// 👍 541 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;
public class SquaresOfASortedArray{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = result.length - 1;
        for (int head = 0, tail = nums.length - 1; head <= tail; ) {
            if (nums[head] * nums[head] > nums[tail] * nums[tail]) {
                result[k--] = nums[head] * nums[head];
                head++;
            } else {
                result[k--] = nums[tail] * nums[tail];
                tail--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
    }

}