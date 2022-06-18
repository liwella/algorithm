//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 
// 👍 1019 👎 0

package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracing(n, k, 1);
        return result;
    }

    private void backTracing(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracing(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

}