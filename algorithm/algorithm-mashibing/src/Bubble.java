public class Bubble {
    /**
     * 冒泡排序：相邻作比较，大的往后放。
     */
    public static void main(String[] args) {
        int[] arr = {13, 5, 3, 12, 11, 6, 8, 1, 10, 14, 7, 9, 4, 2};
//        bubble1(arr);
        bubble2(arr);
        traverse(arr);
    }



    //原始冒泡 O(n2)
    public static void bubble1(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //优化冒泡，使得在最好情况下时间复杂度为O(n)
    public static void bubble2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
    private static void traverse(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
