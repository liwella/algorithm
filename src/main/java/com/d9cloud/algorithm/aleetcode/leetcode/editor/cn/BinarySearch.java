//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 
// 👍 719 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

public class BinarySearch{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // return recurveSearch(nums, 0, nums.length - 1, target);
        return cycleSearch(nums, 0, nums.length - 1, target);
    }

    /*public int recurveSearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) / 2;
        if (target == nums[middle]) {
            return middle;
        } else if (target > nums[middle]) {
            return recurveSearch(nums, middle + 1, end, target);
        } else {
            return recurveSearch(nums, start, middle - 1, target);
        }
    }*/

    public int cycleSearch(int[] nums, int start, int end, int target) {
        while (true) {
            if (start > end) {
                return -1;
            }
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                start = middle + 1;
                continue;
            } else {
                end = middle - 1;
                continue;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }

}