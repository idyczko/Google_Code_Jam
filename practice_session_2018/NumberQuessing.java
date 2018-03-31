import java.util.*;

public class NumberQuessing {

  public static void main(String[] args) {
    int T, t = 0, N;
    long A, B, X;
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    String line;
    while(++t <= T) {
      A = sc.nextLong();
      B = sc.nextLong();
      N = sc.nextInt();
      sc.nextLine();
      while(true) {
        X = (A+B)/2 + 1;
        System.out.println(X);
        System.out.flush();
        line = sc.nextLine();
        if("CORRECT".equals(line))
          break;
        if("WRONG_ANSWER".equals(line))
          return;
        if("TOO_SMALL".equals(line))
          A = (A+B)/2 + 1;
        if("TOO_BIG".equals(line))
          B = (A+B)/2;
      }
    }
    return;
  }
}
