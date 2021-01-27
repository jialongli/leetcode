package 排序;

/**
 * 插入排序 就是打扑克
 * https://juejin.cn/post/6844903461494980621
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/4-11:00 PM.
 * @since 2021/1/4-11:00 PM
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] sort = {10, 3, 1, 5, 6};
        for (int i = 1; i < sort.length; i++) {
            int j = i - 1;
            while (j >= 0 && sort[j] > sort[i]) {
                j--;
            }
            insert(sort, i, j);
        }
        System.out.println(sort);
    }

    private static void insert(int[] sort, int i, int j) {
        //从最后一个开始调整
        for (int index = i; i >= j; i--) {

        }

    }
}

