package 排序;

/**
 * 冒泡排序
 * https://juejin.cn/post/6844903461494980621
 *
 * 5个数要排4趟
 * 4个数排3趟,因此第一层是趟数,i从1开始好理解
 * 第二层就是每一趟要做的事情.
 * 从第0个数开始,两两比较,例如第一趟,要从j=0,比较到j=3;注意哦 别越界了.
 * @author jialong2.li
 * @version 1.0.0, 2021/1/4-11:00 PM.
 * @since 2021/1/4-11:00 PM
 */
public class 冒泡排序 {
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

