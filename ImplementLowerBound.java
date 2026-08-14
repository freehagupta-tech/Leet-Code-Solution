
import java.util.Scanner;
public class ImplementLowerBound {
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

            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}
    

