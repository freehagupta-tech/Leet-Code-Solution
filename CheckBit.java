import java.util.Scanner;
class CheckBit {
    static boolean checkKthBit(int n, int k) {
        for (int i = 0; i < k; i++) {
            n = n / 2;
        }
        return n % 2 == 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(checkKthBit(n, k));
    }
}