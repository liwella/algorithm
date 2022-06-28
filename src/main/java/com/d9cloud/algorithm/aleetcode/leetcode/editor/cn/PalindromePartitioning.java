//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1178 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<String>> result = new ArrayList<>();
        private List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            backTracking(s, 0);
            return result;
        }

        private void backTracking(String s, int startIndex) {
            if (startIndex >= s.length()) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (!isPalindrome(s, startIndex, i)) {
                    continue;
                }
                path.add(s.substring(startIndex, i + 1));
                backTracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }

}