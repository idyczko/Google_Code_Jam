import java.util.*;

public class SavingTheWorld {

  private static void _main(long D, String P) {
    int num[] = new int[50];
    for (int i = 0; i < 50; i++)
      num[i] = 0;
    int index = 0, shooting_count = 0;
    long damage = 0;
    for (int i = 0; i< P.length(); i++) {
      if (P.charAt(i) == 'S') {
        shooting_count++;
        num[index]++;
        damage += Math.pow(2, index);
      } else if (P.charAt(i) == 'C') {
        index++;
      }
    }
    if (shooting_count > D) {
      System.out.println("IMPOSSIBLE");
      return;
    }
    int moves = 0;
    while (D < damage) {
      if(num[index] == 0){
        index--;
        continue;
      }
      num[index]--;
      num[index - 1]++;
      damage -= Math.pow(2, (index - 1));
      moves++;
    }
    System.out.println(moves);
    return;
  }

  public static void main(String[] args) {
    int T, t = 0;
    long D;
    String P;
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    while (++t <= T) {
      System.out.print("Case #" + t + ": ");
      D = sc.nextLong();
      P = sc.nextLine();
      _main(D, P);
    }
  }
}
