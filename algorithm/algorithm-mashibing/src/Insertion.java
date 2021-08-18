public class Insertion {
    /**
     * 插入排序：对基本有序的数组最好用，稳定
     * 空间复杂度：O(1)
     * 时间复杂度：O(n2) 比选择排序快一些。最好时间复杂度为O(n)
     */
    public static void main(String[] args) {
        int[] arr = {13, 5, 3, 12, 11, 6, 8, 1, 10, 14, 7, 9, 4, 2};
//        insetSort1(arr);
        insetSort2(arr);
        traverse(arr);
    }

    //原始插入算法：后面插入过程有点像冒泡算法，因为它是从有序开始排起的
    public static void insetSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    //修改算法，去掉swap方法
    public static void insetSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while(j > 0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void traverse(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
