import java.util.*;

public class Solution{


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        while (t-- > 0) {
            int dim = sc.nextInt();
            sc.nextLine();
            String opponent = sc.nextLine();
            String myMove = invert(opponent);
            System.out.println("Case #" + (T - t) + ": " + myMove);
        }

    }

    private static String invert(String move) {
        String inverted = move.replace("E", "T");
        inverted = inverted.replace("S", "E");
        return inverted.replace("T", "S");
    }
}
