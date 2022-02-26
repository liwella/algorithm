//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
// Related Topics 栈 递归 数学 字符串 
// 👍 708 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.Stack;

public class BasicCalculator {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int res = 0;
        int sign = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                if (i+1 != chars.length && chars[i+1] >= '0' && chars[i+1] <= '9') {
                    continue;
                }
            } else if (c == '+' || c == '-') {
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                sign = stack.pop();
                num = res;
                res = stack.pop();
            }
            res += sign * num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
    }

}