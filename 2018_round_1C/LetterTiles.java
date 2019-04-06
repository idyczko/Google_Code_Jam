
import java.util.*;

public class LetterTiles {

  public static void main(String argv[]) {
    int t = 0, T, N, L;
    Scanner sc = new Scanner(System.in);
    T = sc.nextInt();
    while (t++ < T) {
      System.out.print("Case #" + t + ": ");
      N = sc.nextInt();
      L = sc.nextInt();
      sc.nextLine();
      List<Set<Character>> domains = new ArrayList<Set<Character>>(N);
      for(int i = 0; i < L; i++) {
        domains.add(new HashSet<>());
      }
      Trie trie = new Trie();
      for(int i = 0; i<N; i++) {
        String word = sc.nextLine();
        trie.insert(word);
        for(int j = 0; j<L; j++) {
          domains.get(j).add(word.charAt(j));
        }
      }
      boolean condition = false;
      char current[] = new char[L];
      for(Object o : domains.get(0).toArray()) {
        Character c  = (Character) o;
        current[0] = c;
        condition  = search(1, trie.roots.get(c).nextLetters, domains, current, L);
        if(condition){
          break;
        }
      }
      System.out.print((condition?new String(current) : "-") + "\n");
  }
}

  public static boolean search(int level, Map<Character, Node> nextLetters, List<Set<Character>> domains, char[] current, int L) {
    if(level >= L) {
      return false;
    }
    Set<Character> set = new HashSet<>(domains.get(level));
    set.removeAll(nextLetters.keySet());
    if(!set.isEmpty()) {
      current[level++] = set.iterator().next();
      for(;level<L;level++) {
        current[level] = domains.get(level).iterator().next();
      }
      return true;
    }
    for(Object o : domains.get(level).toArray()) {
      Character c  = (Character) o;
      current[level] = c;
      boolean condition  = search(level+1, nextLetters.get(c).nextLetters, domains, current, L);
      if(condition){
        return true;
      }
    }
    return false;
  }

  public static class Trie {
    public Map<Character, Node> roots = new HashMap<Character, Node>();


    public void insert(String word) {
      insert(word, roots);
    }

    private void insert(String word, Map<Character, Node> currentChoice) {
      char chars[] = word.toCharArray();
      int i = 0;
      Node currentNode = currentChoice.get(chars[i++]);
      while (currentNode != null) {
        if(i >= word.length()) {
          return; //whole word is already in;
        }
        currentChoice = currentNode.nextLetters;
        currentNode = currentChoice.get(chars[i++]);
      }
      currentChoice.put(chars[i-1], new Node(chars[i-1]));
      insert(word.substring(i-1), currentChoice);
    }
  }

  public static class Node {
    public Character letter;
    public Map<Character, Node> nextLetters = new HashMap<>();

    public Node(char c) {
      this.letter = c;
    }

    @Override
    public boolean equals(Object o) {
      return this.letter.equals(((Node) o).letter);
    }

    @Override
    public int hashCode() {
      return this.letter.charValue();
    }

  }

}
