import java.util.Scanner;
class reverseQueue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q[] = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        for (int i = 0; i < n / 2; i++) {
            int temp = q[i];
            q[i] = q[n - 1 - i];
            q[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }
    }
}