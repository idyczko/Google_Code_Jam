import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        while (t-- > 0) {
            int N = sc.nextInt();
            int B = sc.nextInt();
            int bToFind = B;
            int F = sc.nextInt();
            List lists[] = new List[5];
            sc.nextLine();
            for (int i = 0; i < 5; i++) {
              String sinusoid = sinusoid(N, (int) Math.pow(2, i));
              System.out.println(sinusoid);
              String response = sc.nextLine();

              if (i > 0)
                response = fillPast(response, i, lists);

              List<Integer> indices = findRelativeIndices(response, (int) Math.pow(2, i), sinusoid);
              System.out.println("Found indices:");
              for (Integer ind : indices) {
                System.out.println(ind);
              }
              lists[i] = indices;
              bToFind -= indices.size() * ((int) Math.pow(2, i));
              if (bToFind == 0)
                break;
            }
            System.out.println("Case #" + (T - t) + ": " + rebuildIndices(lists));
        }

    }

    private static String rebuildIndices(List[] lists) {
      List<Integer> ids = new ArrayList<>();
      for (int i = lists.length - 1; i >= 0; i--) {
        if (lists[i] ==null)
          continue;
        List<Integer> relative = (List<Integer>) lists[i];
        for (int j = 0; j < relative.size(); j++) {
          ids.add(relative.get(j) + j * ((int) Math.pow(2, i)));
        }
      }
      Collections.sort(ids);
      return ids.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" "));
    }

    private static String fillPast(String response, int index, List lists[]) {
      for (int i =0; i < lists.length; i++) {
        int
        if (lists[i] == null)
          break;
        List<Integer> list = (List<Integer>) lists[i];
        int ind = 0;
        Integer index = list.get(ind);
        StringBuilder temp = new StringBuilder();
        for (int k = 0; k < response.length(); k++) {
          if (k > index) {
            temp.append(analyzePatternPhase(response, k, (int) Math.pow(2, i)));
            index = ind == list.size() - 1 ? response.length() + 1 : list.get(++ind);
          }
          temp.append(respoonse.charAt(k));
        }
        response = temp.toString();
      }
      return response;
    }

    private static String analyzePatternPhase(String response, int index, int span) {
      
    }

    private static List<Integer> findRelativeIndices(String response, int span, String sinusoid) {
      System.out.println("Find: " + response + " " + span);
      List<Integer> indices = new ArrayList<>();
      boolean one = false;
      int offset = 0;
      for (int i = 0; i < response.length();) {
        if ((i + offset)% span == 0)
          one = !one;

        if (response.charAt(i) != (one ? '1' : '0')) {
          indices.add(i);
          offset -= span;
          continue;
        }
        i++;
      }
      if (response.charAt(response.length() - 1) != sinusoid.charAt(sinusoid.length() - 1))
        indices.add(response.length());
      return indices;
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
