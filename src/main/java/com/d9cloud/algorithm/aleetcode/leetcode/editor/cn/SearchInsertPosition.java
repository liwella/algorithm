//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 为 无重复元素 的 升序 排列数组 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 1564 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

public class SearchInsertPosition{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = -5;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle - 1;
                if (right < left) {
                    return right + 1;
                }
            } else if (nums[middle] < target) {
                left = middle + 1;
                if (right < left) {
                    return right + 1;
                }
            } else {
                return middle;
            }
        }
        return middle;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = {1,3};
        int target = 2;
        solution.searchInsert(nums, target);
    }

}