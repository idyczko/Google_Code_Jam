import java.util.*;

public class TroubleSort {

  public static void main(String[] args) {
    int N, T, t = 0;

    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    while (++t <= T) {
      boolean odd = true;
      N = sc.nextInt();
      PriorityQueue<Integer> kyuOdd = new PriorityQueue<Integer>(N/2 + 1);
      PriorityQueue<Integer> kyuEven = new PriorityQueue<Integer>(N/2);
      for (int i = 0; i< N; i++) {
        if (odd) {
          kyuOdd.add(sc.nextInt());
        } else {
          kyuEven.add(sc.nextInt());
        }
        odd ^= true;
      }
      System.out.print("Case #"+t+": ");
      int error_index = 0;
      boolean ok = true;
      odd = true;
      while (!kyuOdd.isEmpty() && !kyuEven.isEmpty()) {
        if (odd) {
          Integer oddInt = kyuOdd.poll();
          if (oddInt > kyuEven.peek()) {
            ok = false;
            break;
          }
        } else {
          Integer evenInt = kyuEven.poll();
          if (evenInt > kyuOdd.peek()) {
            ok = false;
            break;
          }
        }
        odd ^= true;
        error_index++;
      }
      if (ok) {
      System.out.println("OK");
    } else {
      System.out.println(error_index);
    }
    }
  }
}
