//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 
// 👍 254 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

public class ZuoXuanZhuanZiFuChuanLcof {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[end];
            chars[end] = chars[start];
            chars[start] = tmp;
            start++;
            end--;
        }
    }

    // 双指针，需要申请额外空间
    /*public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(' ');
        }
        int start = 0;
        int end = s.length();
        s += builder.toString();
        char[] chars = s.toCharArray();
        for (; start < n; start++) {
            chars[end++] = chars[start];
        }
        char[] result = new char[end - start];
        int i = 0;
        while (start < end) {
            result[i++] = chars[start++];
        }
        return new String(result);
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
    }

}