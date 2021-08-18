public class Merge {

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};
//        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr,0,arr.length-1);
        traverse(arr);
    }

    public static void sort(int[] arr,int left,int right){
        if(left == right) return;
        //分成两半
        int mid = left + (right-left)/2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);

        merge(arr,left,mid+1,right);
    }

    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];
        for (int l = leftPtr; l <= rightBound; l++) {
            arr[l] = temp[l-leftPtr];
        }
    }

    private static void traverse(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
