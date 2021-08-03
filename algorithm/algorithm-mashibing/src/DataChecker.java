import java.util.Arrays;
import java.util.Random;

public class DataChecker {
    static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

   public static void check() {
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        Arrays.sort(arr);
//        Selection.selection1(arr2);System.out.print("Selection1");
        Selection.selection2(arr2);System.out.print("Selection2");
//        Selection.selection3(arr2);System.out.print("Selection3");

        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                same = false;
                break;
            }
        }

        System.out.println(same == true ? " is right" : " is wrong");

    }

    public static void main(String[] args) {
        check();
    }
}
