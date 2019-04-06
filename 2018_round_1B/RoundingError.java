import java.util.*;
import java.math.*;

public class RoundingError {

  public static void main(String argv[]) {
    int t = 0, T, N, L;
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    while (t++ < T) {
      System.out.print("Case #" + t + ": ");
      N = sc.nextInt();
      int leftToVote = N;
      PriorityQueue<BigDecimal> Q = new PriorityQueue<>(N, new Comparator<BigDecimal>() {
        @Override
        public int compare(BigDecimal d1, BigDecimal d2) {
          return -d1.add(new BigDecimal("0.5")).remainder(BigDecimal.ONE).compareTo(d2.add(new BigDecimal("0.5")).remainder(BigDecimal.ONE));
        }
      });
      L = sc.nextInt();
      int next;
      while (--L >= 0) {
        next = sc.nextInt();
        leftToVote -= next;
        Q.add(new BigDecimal(next).multiply(new BigDecimal(100)).divide(new BigDecimal(N), 10, RoundingMode.HALF_UP));
      }
      Q.add(BigDecimal.ZERO);
      while(leftToVote > 0) {
        BigDecimal d = Q.poll();
        if(d.equals(BigDecimal.ZERO)) {
          Q.add(BigDecimal.ZERO);
        }
        --leftToVote;
        Q.add(d.add(new BigDecimal(100).divide(new BigDecimal(N), 10, RoundingMode.HALF_UP)));
      }
      System.out.print(Arrays.stream(Q.toArray()).mapToInt(item -> ((BigDecimal) item).setScale(0, RoundingMode.HALF_UP).intValue()).sum() + "\n");
    }
  }
}
