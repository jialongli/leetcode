package 排序;

/**
 * 选择排序
 * https://juejin.cn/post/6844903461494980621
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/4-11:00 PM.
 * @since 2021/1/4-11:00 PM
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] sort = {10, 3, 1, 5, 6};
        for (int i = 0; i < sort.length; i++) {
            int tmp = sort[i];
            int index = i;
            for (int j = i + 1; j < sort.length; j++) {
                if (sort[j] < tmp) {
                    tmp = sort[j];
                    index = j;
                }
            }
            change(sort, i, index);
        }
        System.out.println(sort);
    }

    private static void change(int[] sort, int i, int j) {
        int tmp = sort[i];
        sort[i] = sort[j];
        sort[j] = tmp;

    }
}

