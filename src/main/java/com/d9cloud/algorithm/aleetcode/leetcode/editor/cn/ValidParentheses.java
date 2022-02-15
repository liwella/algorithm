//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2967 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ("{".equals(s.substring(i, i + 1)) || "(".equals(s.substring(i, i + 1)) || "[".equals(s.substring(i, i + 1))) {
                stack.push(s.substring(i, i + 1));
            } else if (")".equals(s.substring(i, i + 1)) && (stack.isEmpty() || !"(".equals(stack.pop()))) {
                return false;
            } else if ("]".equals(s.substring(i, i + 1)) && (stack.isEmpty() || !"[".equals(stack.pop()))) {
                return false;
            } else if ("}".equals(s.substring(i, i + 1)) && (stack.isEmpty() || !"{".equals(stack.pop()))) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String s = "()[]{}";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }

}