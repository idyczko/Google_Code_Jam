import java.util.*;
import java.math.*;

public class Solution{

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int T = t;
        while (t-- > 0) {
            long N = sc.nextLong();
            int L = sc.nextInt();
            BigInteger primes[] = new BigInteger[L + 1];
            BigInteger cryptos[] = new BigInteger[L];
            int cryptomark = 0;
            cryptos[0] = sc.nextBigInteger();
            for (int i = 1; i < L; i++) {
              cryptos[i] = sc.nextBigInteger();
              if (!cryptos[i].equals(cryptos[i-1])) {
                cryptomark = i;
                primes[cryptomark] = cryptos[cryptomark].gcd(cryptos[cryptomark - 1]);
                break;
              }
            }
            for (int i = cryptomark - 1; i >= 0; i--) {
              primes[i] = cryptos[i].divide(primes[i+1]);
            }
            primes[cryptomark + 1] = cryptos[cryptomark].divide(primes[cryptomark]);
            for (int i = cryptomark + 2; i < L + 1; i++) {
              BigInteger cryptoLoop = sc.nextBigInteger();
              primes[i] = cryptoLoop.divide(primes[i-1]);
            }
            Map<BigInteger, Character> dictionary = constructDictionary(primes);
            StringBuilder message = new StringBuilder();
            for (BigInteger prime : primes) {
              message.append(dictionary.get(prime));
            }

            System.out.println("Case #" + (T - t) + ": " + message.toString());
        }

    }

    private static Map<BigInteger, Character> constructDictionary(BigInteger[] primes) {
      Map<BigInteger, Character> dictionary = new HashMap<>();
      Set<BigInteger> set = new HashSet<>();
      set.addAll(Arrays.asList(primes));
      BigInteger[] distinct = set.toArray(new BigInteger[26]);
      Arrays.sort(distinct);
      for (int i = 0; i < 26; i++) {
        dictionary.put(distinct[i], ALPHABET.charAt(i));
      }
      return dictionary;
    }

}
