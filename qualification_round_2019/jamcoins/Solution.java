import java.util.*;

public class Solution{


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        while (t-- > 0) {
            int n = sc.nextInt();
            int a = getA(n);
            int b = n - a;
            System.out.println("Case #" + (T - t) + ": " + a +" " +b);
        }

    }

    private static int getA(int n) {
        String nString = Integer.toString(n);
        int value = 0;
        for (int i = 0; i < nString.length(); i++) {
                if (nString.charAt(i) == '4') {
                    value += Math.pow(10, (nString.length() - i - 1));
                }
        }
        return value;
    }
}
