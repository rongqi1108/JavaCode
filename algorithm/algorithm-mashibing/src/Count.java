public class Count {

    /**
     * 计数排序
     * */
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 3, 7, 1, 1, 0, 0, 5, 6, 9, 8, 5, 7, 4, 0, 9};
        sort(arr);
        traverse(arr);
    }

    public static void sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = arr[i] < min ? arr[i] : min;
            max = arr[i] > max ? arr[i] : max;
        }
        //偏移量，以免出现负数，造成数组越界
        int bias = 0-min;

        int[] bucket = new int[max-min+1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]+bias]++;
        }

        int k=0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]>0) {
                arr[k++]=i-bias;
                bucket[i]--;
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
