package task_02;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        test();
        int[] arr = {5, 6, 3, 2, 5, 1, 4, 9};
        System.out.println("INITIAL ARRAY: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("SORTED ARRAY: " + Arrays.toString(arr));
    }

    public static void test() {
        test(new int[]{1}, new int[]{1});
        test(new int[]{10, -10, 4, 7, 100, 34, 5, 4}, new int[]{-10, 4, 4, 5, 7, 10, 34, 100});
        test(new int[]{0, 12, -1, 0, 4}, new int[]{-1, 0, 0, 4, 12});
    }

    private static void test(int[] arr, int[] expected) {
        quickSort(arr);
        assert Arrays.equals(arr, expected);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }
        int partitionIndex = partition(arr, l, h);
        quickSort(arr, l, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, h);
    }

    static int partition(int[] arr, int low, int high) {
        int pivotIndex = new Random().nextInt(low, high);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] arr, int index, int i) {
        int t = arr[i];
        arr[i] = arr[index];
        arr[index] = t;
    }
}
