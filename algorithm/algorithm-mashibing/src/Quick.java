public class Quick {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 8, 1, 9, 5, 4, 6, 10};
        sort(arr,0, arr.length-1);
        traverse(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int mid = partition(arr, leftBound, rightBound);
        sort(arr,leftBound,mid-1);
        sort(arr,mid+1,rightBound);
    }

    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left < right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if (left < right) swap(arr, left, right);
        }
        if(pivot<arr[left]) swap(arr,left,rightBound);

        return left;
    }


    public static void swap(int[] arr, int pos1, int pos2) {
        int t;
        t = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = t;
    }

    private static void traverse(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
