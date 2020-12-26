package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 *
 * @author jialong2.li
 * @version 1.0.0, 2020/12/26-8:40 PM.
 * @since 2020/12/26-8:40 PM
 */
public class TopK
{
    // 使用最大堆
    // 时间复杂度：O(N \logK)
    // 空间复杂度：O(K)

    public int[] getLeastNumbers(int[] arr, int k) {

        int len = arr.length;
        if (k == 0 || k > len) {
            return new int[0];
        }

        // 应该使用大顶堆，传入 k 是为了防止扩容
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> -o1 + o2);
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < len; i++) {
            Integer head = maxHeap.peek();
            if (head > arr[i]) {
                // 这里应该使用 replace ，但是 Java 不提供
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        // 这样写一行太长，目前没找到更好的写法，意思就是直接读取最大堆里面的数组，而不去 poll
        return Arrays.stream(maxHeap.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] res = topK.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(res));
    }
}
