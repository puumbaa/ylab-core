package task_01;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        test();
        run(10);
    }

    public static void test() {
        test(new int[]{1}, new Result(1, 1, 1));
        test(new int[]{-1, -1}, new Result(-1, -1, -1));
        test(new int[]{10, 5, 10, 0, -1, 4}, new Result(10, -1, 28.0/6));
    }

    private static void test(int[] arr, Result expected) {
        assert getResult(arr).equals(expected);
    }

    private static void run(int n) {
        int[] arr = createRandomArray(n);
        System.out.println("INITIAL ARRAY: " + Arrays.toString(arr));
        print(getResult(arr));
    }

    private static void print(Result result) {
        System.out.printf("""
                MAX = %s\s
                MIN = %s\s
                AVG = %s""", result.max, result.min, result.avg);
    }

    private static Result getResult(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
            sum += x;
        }
        return new Result(max, min, sum / arr.length);
    }

    private static int[] createRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    private static class Result {
        private final int max;
        private final int min;
        private final double avg;

        Result(int max, int min, double avg) {
            this.max = max;
            this.min = min;
            this.avg = avg;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return max == result.max && min == result.min && Double.compare(result.avg, avg) == 0;
        }
    }
}
