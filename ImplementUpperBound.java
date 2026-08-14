import java.util.Scanner;

public class ImplementUpperBound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
    }
}