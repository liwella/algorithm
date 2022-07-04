//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 
// 👍 1402 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backTracking(n, 0, chessboard);
        return result;
    }

    private void backTracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            result.add(array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] row : chessboard) {
            list.add(String.copyValueOf(row));
        }
        return list;
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(4);
    }

}