package 树;

/**
 * <pre>
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * </pre>
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/27-2:28 PM.
 * @since 2021/1/27-2:28 PM
 */
public class 二叉树中的最大路径和_124 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        treeNode3.setLeft(treeNode6);
        int max = new 二叉树的直径_543().diameterOfBinaryTree(treeNode1);
        System.out.println(max);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getLength(root);
        return max;
    }

    private int max = 0;

    public int getLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLength(root.getLeft());
        int right = getLength(root.getRight());
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right) + root.val;
    }
}
