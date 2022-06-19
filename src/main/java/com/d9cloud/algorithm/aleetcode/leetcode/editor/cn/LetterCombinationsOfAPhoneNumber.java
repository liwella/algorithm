//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1959 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private String[] keys = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    private List<String> result = new ArrayList<>();
    private StringBuilder builder = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        backTracing(digits, 0);
        return result;
    }

    private void backTracing(String digits, int startIndex) {
        if (startIndex == digits.length()) {
            result.add(builder.toString());
            return;
        }
        int index = digits.charAt(startIndex) - '0';
        int keyLength = keys[index].length();
        for (int i = 0; i < keyLength; i++) {
            builder.append(keys[index].charAt(i));
            backTracing(digits, startIndex + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

}