//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答
//案。
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 274 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] hash = new int[26];
        for (char c : words[0].toCharArray()) {
            hash[c - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] anotherHash = new int[26];
            for (char c : words[i].toCharArray()) {
                anotherHash[c - 'a']++;
            }
            for (int j = 0; j < hash.length; j++) {
                hash[j] = Math.min(hash[j], anotherHash[j]);
            }
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                char c = (char)(i + 'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        String[] words = {"bella", "label", "roller"};
        solution.commonChars(words);
    }

}