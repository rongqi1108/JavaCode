public class Shell {
    /**
     * 希尔排序：改进的插入排序  间隔大移动次数少，间隔小距离短
     * 目的就是逐渐让数组变得有序
     * 不稳定
     */
    public static void main(String[] args) {
        int[] arr = {13, 5, 3, 12, 11, 6, 8, 1, 10, 14, 7, 9, 4, 2};
        shell1(arr);
        traverse(arr);
    }


    public static void shell1(int[] arr) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        for (int gap = h; gap > 0; gap=(gap-1)/3) {
            for (int i = gap; i < arr.length; i += gap) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
        }

//        for (int k = gap; k < gap*2; k++) {
//            for (int i = k; i < arr.length; i+=gap) {
//                int j = i;
//                int temp =arr[j];
//                while(j>gap-1){
//                    if(temp < arr[j-gap]){
//                        arr[j] = arr[j-gap];
//                        j-=gap;
//                    } else {
//                        break;
//                    }
//                }
//                arr[j] = temp;
//            }
//        }
    }

    public static void swap(int[] a, int i, int j) {
        int t;
        t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
