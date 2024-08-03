public class FibonacciSearch {

    // 辅助函数：生成斐波那契数列
    private static int[] generateFibonacci(int n) {
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    // 斐波那契查找算法
    public static int fibonacciSearch(int[] arr, int key) {
        int n = arr.length;

        // 生成斐波那契数列，找到最接近且大于等于 n 的值
        int[] fibonacci = generateFibonacci(n);
        int k = 0;
        while (fibonacci[k] < n) {
            k++;
        }

        // 将数组扩展到斐波那契数列的长度
        int[] temp = new int[fibonacci[k]];
        System.arraycopy(arr, 0, temp, 0, n);

        int low = 0;
        int high = n - 1;

        // 主要查找过程
        while (low <= high) {
            int mid = low + fibonacci[k - 1] - 1;

            if (key < temp[mid]) {
                high = mid - 1;
                k -= 1;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                // 找到了目标元素，需要判断返回的是原数组中的索引还是扩展数组中的索引
                return Math.min(mid, high);
            }
        }

        // 未找到目标元素
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15,16};
        int key = 11;

        int result = fibonacciSearch(arr, key);

        if (result != -1) {
            System.out.println("元素 " + key + " 在数组中的索引为：" + result);
        } else {
            System.out.println("元素 " + key + " 不在数组中");
        }
    }
}