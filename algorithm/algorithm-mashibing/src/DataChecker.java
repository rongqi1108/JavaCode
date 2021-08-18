import java.util.Arrays;
import java.util.Random;
/**
 * 用大量随机数据验证算法的正确性
 * */
public class DataChecker {

    public static void main(String[] args) {
        check();
    }

    //随机生成一个10000个元素的int数组
    static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    //复制数组，对两个数组分别排序，再一一比较。判断是否完全一致
   public static void check() {
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        Arrays.sort(arr);
//        Selection.selection1(arr2);System.out.print("Selection1");
//        Selection.selection2(arr2);System.out.print("Selection2");
//        Selection.selection3(arr2);System.out.print("Selection3");
//        Bubble.bubble1(arr2);System.out.print("bubble1");
//        Bubble.bubble2(arr2);System.out.print("bubble2");
//        Insertion.insetSort1(arr2);System.out.print("insetSort1");
//        Insertion.insetSort2(arr2);System.out.print("insetSort2");
//       Shell.shell1(arr2);System.out.print("shell1");
//        Merge.sort(arr2,0,arr.length-1);System.out.print("mergesort");
        Quick.sort(arr2,0,arr.length-1);System.out.print("quicksort");
        Count.sort(arr2);System.out.print("countsort");

        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                same = false;
                break;
            }
        }

        System.out.println(same == true ? " is right" : " is wrong");

    }


}
