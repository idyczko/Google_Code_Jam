import java.util.*;

public class Solution{

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        while (t-- > 0) {
            long N = sc.nextLong();
            int L = sc.nextInt();
            Long primes[] = new Long[L + 1];
            long crypto = sc.nextLong();
            long crypto_2 = sc.nextLong();
            long gcd = gcd(crypto, crypto_2);
            primes[0] = crypto/gcd;
            primes[1] = gcd;
            primes[2] = crypto_2/gcd;
            for (int i = 3; i < L; i++) {
              long cryptoLoop = sc.nextLong();
              primes[i] = cryptoLoop/primes[i-1];
            }
            primes[L] = sc.nextLong()/primes[L -1];
            Map<Long, Character> dictionary = constructDictionary(primes);
            StringBuilder message = new StringBuilder();
            for (Long prime : primes) {
              message.append(dictionary.get(prime));
            }

            System.out.println("Case #" + (T - t) + ": " + message.toString());
        }

    }

    private static Map<Long, Character> constructDictionary(Long[] primes) {
      Map<Long, Character> dictionary = new HashMap<>();
      Long[] distinct = new HashSet<Long>(Arrays.asList(primes)).toArray(new Long[26]);
      Arrays.sort(distinct);
      for (int i = 0; i < 26; i++) {
        dictionary.put(distinct[i], ALPHABET.charAt(i));
      }
      return dictionary;
    }

    private static long gcd(long a, long b) {
      if (b > a)
        return gcd(b, a);

      if (b == 0)
        return a;
      return gcd(b, a%b);
    }
}
