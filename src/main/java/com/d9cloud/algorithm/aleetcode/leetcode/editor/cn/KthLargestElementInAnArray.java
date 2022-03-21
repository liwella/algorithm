//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1538 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

public class KthLargestElementInAnArray{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length, nums.length + 1 - k);
    }

    public int find(int[] nums, int start, int end, int keyIndex) {
        if (start >= end) {
            return -1;
        }
        int pivort = partition(nums, start, end);
        if (keyIndex == pivort + 1) {
            return nums[pivort];
        } else if (keyIndex > pivort + 1) {
            return find(nums, pivort + 1, end, keyIndex);
        } else {
            return find(nums, 0, pivort, keyIndex);
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = end - 1;
        int i = start;
        for (int j = start; j < end - 1; j++) {
            if (nums[j] < nums[pivot]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, pivot);
        return i;
    }

    public void swap(int[] nums, int left, int right) {
        if (right == left) return;
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

}