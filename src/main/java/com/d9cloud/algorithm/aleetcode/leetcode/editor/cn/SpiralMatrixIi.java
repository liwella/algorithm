//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 711 👎 0

  
package com.d9cloud.algorithm.aleetcode.leetcode.editor.cn;
public class SpiralMatrixIi{
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int startx = 0;
        int starty = 0;
        int offset = 1;
        int loop = n / 2;
        int i, j;
        while (loop-- > 0) {
            for (j = starty; j < starty + n - offset; j++) {
                result[startx][j] = count++;
            }
            for (i = startx; i < startx + n - offset; i++) {
                result[i][j] = count++;
            }
            for (; j > starty; j--) {
                result[i][j] = count++;
            }
            for (; i > startx; i--) {
                result[i][j] = count++;
            }
            startx++;
            starty++;
            offset += 2;
        }
        if ((n % 2) == 1) {
            result[n/2][n/2] = count;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

}