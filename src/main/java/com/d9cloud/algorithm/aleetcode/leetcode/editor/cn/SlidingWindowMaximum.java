//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 
// 👍 1661 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class MyQueue {
        private Deque<Integer> queue = new ArrayDeque<>();

        void pop(int value) {
            if (!queue.isEmpty() && value == queue.peekFirst()) {
                queue.poll();
            }
        }

        void push(int value) {
            while (!queue.isEmpty() && value > queue.peekLast()) {
                queue.pollLast();
            }
            queue.addLast(value);
        }

        Integer max() {
            return queue.peekFirst();
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        result[index++] = queue.max();
        for (int i = k; i < nums.length; i++) {
            queue.pop(nums[i - k]);
            queue.push(nums[i]);
            result[index++] = queue.max();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }

}