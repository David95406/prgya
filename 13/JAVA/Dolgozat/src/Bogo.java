import java.util.Random;

public class Bogo {
        private static int attempts = 0;

        public static boolean isSorted(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }

        public static void bogoSort(int[] arr) {
            Random random = new Random();
            while (!isSorted(arr)) {
                System.out.println("Not sorted yet :(");
                attempts++;
                for (int i = 0; i < arr.length; i++) {
                    int randomIndex = random.nextInt(arr.length);
                    int temp = arr[i];
                    arr[i] = arr[randomIndex];
                    arr[randomIndex] = temp;
                }
            }
        }

        public static void main(String[] args) {
            int[] arr = {3, 2, 5, 1, 4, 8, 9, 7, 6, 0, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
            System.out.println("Original array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();

            bogoSort(arr);

            System.out.println("Sorted array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("Number of attempts: " + attempts);
        }

}

