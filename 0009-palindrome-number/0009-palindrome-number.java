class Solution {
    boolean  palindrome=false;
    public boolean isPalindrome(int x) {
        if(x<0)
          return false;
        int original=x;
        int rev=0;
        while(x!=0){
            int digit=x%10;
            rev=rev*10+digit;
            x=x/10;
        }
        return original==rev;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Solution obj=new Solution();
        System.out.println(obj.isPalindrome(n));
        sc.close();
    }
}