public class Bubble {
    /**
     * 冒泡排序：相邻作比较，大的往后放。
     * */
    public static void main(String[] args) {
        int[] arr = {13,5, 3, 12, 11, 6, 8, 1,10,14, 7, 9, 4, 2};
        bubble(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubble(int[] arr) {
        for(int i = arr.length-1; i > 0; i--){
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

}
