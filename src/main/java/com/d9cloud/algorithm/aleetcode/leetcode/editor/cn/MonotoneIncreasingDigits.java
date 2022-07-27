//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。 
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 109 
// 
// Related Topics 贪心 数学 
// 👍 273 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

public class MonotoneIncreasingDigits{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] numbers = (n + "").toCharArray();
        int flag = numbers.length;
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i - 1] > numbers[i]) {
                flag = i;
                numbers[i - 1]--;
            }
        }
        for (int i = flag; i < numbers.length; i++) {
            numbers[i] = '9';
        }
        return Integer.parseInt(String.valueOf(numbers));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MonotoneIncreasingDigits().new Solution();
    }

}