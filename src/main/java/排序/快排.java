package 排序;

/**
 * 快排
 * https://time.geekbang.org/column/article/270342
 *
 *
 * @author jialong2.li
 * @version 1.0.0, 2021/1/4-11:00 PM.
 * @since 2021/1/4-11:00 PM
 */
public class 快排 {
    public static void main(String[] args) {
        int[] sort = {10, 3, 1, 5, 6};
        for (int i = 1; i < sort.length; i++) {
            for (int j = 0; j < sort.length - i; j++) {
                if (sort[j] > sort[j + 1]) {
                    change(sort, j, j + 1);
                }
            }
        }
        System.out.println(sort);
    }

    private static void change(int[] sort, int i, int j) {
        int tmp = sort[i];
        sort[i] = sort[j];
        sort[j] = tmp;
    }
}

