package 动态规划;

/**
 * <pre>
 *     给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 *
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/2/3-9:28 AM.
 * @since 2021/2/3-9:28 AM
 */
public class 最小路径和_64 {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int l = grid[0].length;
        int[][] dp = new int[h][l];
        dp[h - 1][l - 1] = grid[h - 1][l - 1];
        //先遍历最下面这一列
        for (int i = h - 1; i >= 0; i--) {
            for (int j = l - 1; j >= 0; j--) {
                //说明这是最后一列
                if ((i == h - 1) && (j == l - 1)) {
                    continue;
                }
                if (j == l - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (i == h - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }

            }
        }
        return dp[0][0];
    }
}
