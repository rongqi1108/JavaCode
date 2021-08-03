public class Selection {
    /**
     * 选择排序:不断把最小的往前放
     * 平均时间复杂度：O(n2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * <p>
     * 这个算法没什么用，最好和最差时间复杂度都是n2。
     * 不稳定是指两个相等的数有可能相对位置会变，如{1,4,5,4,3},排完序第一个4就会到第二个4后面
     */
    public static void main(String[] args) {
        int[] arr = {13, 5, 3, 12, 11, 6, 8, 1, 10, 14, 7, 9, 4, 2};
//        selection1(arr);
        selection2(arr);
//        selection3(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void selection1(int[] arr) {
        //原始的选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

    }

    public static void selection2(int[] arr) {
        //优化 同时找到最小最大，放到前面后面
        //难点 在中间的时候，会出现
        for (int i = 0; i < arr.length - i; i++) {
            int min = i;
            int max = i;

            for (int j = i + 1; j < arr.length - i; j++) {
                min = arr[j] < arr[min] ? j : min;
                max = arr[j] > arr[max] ? j : max;
            }
//            四种交叉情况分析
//            if(i == max && min < arr.length-1-i){
//                swap(arr, arr.length - i - 1, max);
//                swap(arr, i, min);
//            } else if(i == max && min == arr.length-1-i){
//                swap(arr, i, min);
//            } else {
//                swap(arr, i, min);
//                swap(arr, arr.length - i - 1, max);
//            }
//        }
            //代码的合并优化
                if (i == max) {
                    if(min < arr.length-1-i){
                        swap(arr,arr.length-i-1,max);
                    }
                    swap(arr,i,min);
                } else {
                    swap(arr,i,min);
                    swap(arr,arr.length-i-1,max);
                }
            }
        }

        public static void selection3 ( int[] arr){
            //优化 三个三个比较
            for (int i = 0; i < arr.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < arr.length; j += 2) {
                    int min2 = j;
                    if (j + 1 < arr.length) {
                        min2 = arr[j] > arr[j + 1] ? j + 1 : j;
                    }
                    min = arr[min2] < arr[min] ? min2 : min;
                }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        public static void swap ( int[] arr, int pos1, int pos2){
            int t;
            t = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = t;
        }
    }
