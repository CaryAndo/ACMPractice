package etc;

import java.util.*;

/**
 * Created by cary on 5/22/17.
 */
public class PrimeNumberSieve {
    private Set<Integer> compositeSet;

    public PrimeNumberSieve(int upperBound) {
        this.compositeSet = new HashSet<>();

        for (int i = 2; i < upperBound / 2; i++) {
            for (int j = i; j < upperBound / 2; j++) {
                compositeSet.add(i*j);
            }
        }
    }

    public List<Integer> getPrimesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(start, 2); i < end; i++) {
            if (!compositeSet.contains(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void printPrimesInRange(int start, int finish) {
        start = Math.max(start, 2);

        while (start < finish) {
            boolean flag = false;

            for (int i = 2; i < start / 2; i++) {
                if (start % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(start);
            }

            start++;
        }
    }
}
