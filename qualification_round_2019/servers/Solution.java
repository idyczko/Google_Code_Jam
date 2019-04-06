import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int t = Integer.parseInt(line.trim());
        int T = t;
        while (t-- > 0) {
            //line = sc.nextLine();
            int N = sc.nextInt();
            int B = sc.nextInt();
            int bToFind = B;
            int F = sc.nextInt();
            sc.nextLine();
            List lists[] = new List[5];
            int maxLevel = 0;
            for (int i = 0; i < 5; i++) {
              String sinusoid = sinusoid(N, (int) Math.pow(2, i));
              System.out.println(sinusoid);
              String response = sc.nextLine();
            List<Integer> indices = findRelativeIndices(response, i, sinusoid, lists);
              /*System.out.println("Found indices:");
              for (Integer ind : indices) {
                System.out.println(ind);
              }*/
              lists[i] = indices;
              bToFind -= indices.size() * ((int) Math.pow(2, i));
              maxLevel = i;
              if (bToFind == 0)
                break;
            }
            System.out.println(rebuildIndices(lists, N, B, maxLevel + 1));
            Integer resp = sc.nextInt();
            if (resp == -1)
              return;
        }

    }

    private static List<Integer> findRelativeIndices(String response, int index, String sinusoid, List[] lists) {
      int span = (int) Math.pow(2, index);
      StringBuilder control = new StringBuilder();
      List<Integer> currentIndices = new ArrayList<Integer>();

      for (int i = 0; i < response.length(); i++) {
        //System.out.println("Iteration start: " + i + " Control: " + control.toString() + " Sinusoid: " + sinusoid);
        List<Integer> lengths = findLengthsAtIndex(i, lists, index);
        int sum = lengths.stream().mapToInt(integer -> integer.intValue()).sum();
        //System.out.println("Iteration: " + i + " sum: " + sum);
        control.append(sinusoid.substring(control.length(), control.length() + sum));
        if (sinusoid.charAt(control.length()) == response.charAt(i)) {
          control.append(response.charAt(i));
        } else {
          control.append(sinusoid.substring(control.length(), control.length() + span)).append(response.charAt(i));
          currentIndices.add(i);
        }
        //System.out.println("Iteration end: " + i + " Control: " + control.toString() + " Sinusoid: " + sinusoid);
      }

      List<Integer> lengths = findLengthsAtIndex(response.length(), lists, index);
      int sum = lengths.stream().mapToInt(integer -> integer.intValue()).sum();

      control.append(sinusoid.substring(control.length(), control.length() + sum));
      String s1 = control.substring(Math.max(control.length() - span, 0), control.length());
      if (!s1.equals(sinusoid.substring(sinusoid.length() - s1.length(), sinusoid.length())))
        currentIndices.add(response.length());

      return currentIndices;
    }

    private static List<Integer> findLengthsAtIndex(int index, List[] lists, int span) {
      List<Integer> lengths = new ArrayList<>();
      for (int i = 0; i < span; i++) {
        if (lists[i].contains(index)) {
          lengths.add((int) Math.pow(2, i));
        }
      }
      return lengths;
    }

    private static String rebuildIndices(List[] lists, int N, int B, int maxLevel) {
      StringBuilder sb = new StringBuilder();
      List<Integer> ids = new ArrayList<>();
      for (int i = 0; i <=N - B; i++) {
        int broken = findLengthsAtIndex(i, lists, maxLevel).stream().mapToInt(integer -> integer.intValue()).sum();
        while (broken-- > 0)
          sb.append(0);
        if(i != N - B)
          sb.append(1);
      }
      for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == '0')
          ids.add(i);
      }

      return ids.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" "));
    }


    private static String sinusoid(int length, int span) {
      StringBuilder sinusoid = new StringBuilder();
      boolean one = false;
      for (int i = 0; i < length; i++) {
        if (i % span == 0)
          one = !one;
        sinusoid.append(one ? 1 : 0);
      }
      return sinusoid.toString();
    }

}
