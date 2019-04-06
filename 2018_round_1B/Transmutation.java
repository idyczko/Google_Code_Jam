import java.util.*;
import java.math.*;

public class Transmutation {

  public static int[] treasury;
  public static Tuple[] map;

  public static void main(String argv[]) {
    int t = 0, T, M;
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    while (t++ < T) {
      System.out.print("Case #" + t + ": ");
      M = sc.nextInt();
      map = new Tuple[M];
      for(int i =0 ; i< M; i++) {
        map[i] = new Tuple(sc.nextInt(), sc.nextInt());
      }

      treasury = new int[M];
      for(int i =0 ; i< M; i++) {
        treasury[i] = sc.nextInt();
      }


  }
}

public static boolean create(int index) {
  if(treasury[map[index].x] > 0 && treasury[map[index].y] > 0){
    treasury[map[index].x]--;
    treasury[map[index].y]--;
    treasury[index]++;
    return true;
  } else {
    if (treasury[map[index].x] == 0) {
      create([map[index].x);
    } else {
      create([map[index].y);
    }
    return create(index);
  }
}

public static class Tuple {
  public int x;
  public int y;
  public Tuple(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

}
