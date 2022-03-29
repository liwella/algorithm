//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 946 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

public class Sqrtx {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (middle > x / middle) {
                high = middle - 1;
            } else {
                if ((middle + 1) > x / (middle + 1) || middle == x) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        int result = solution.mySqrt(2147395599);
        System.out.println(result);
    }

}