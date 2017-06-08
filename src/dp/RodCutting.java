package dp;


import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cary on 6/3/17.
 */
public final class RodCutting {
    public static void testRodCut() {
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int rodLength = 4;
        RodCutting.maxValue(lengths, prices, rodLength);
        Pair<Integer, Integer> pair;
    }

    /**
     * Given an array with values of different lengths of rod
     * and a length of rod to cut, return the max value you
     * can get from cutting the rod up and selling it
     */
    public static void maxValue(int[] lengths, int[] prices, int rod) {
        Map<Integer, Integer> cachedValue = new HashMap<>();
        Map<Integer, Integer> priceMap = new HashMap<>();

        for (int i = 0; i < lengths.length; i++) {
            priceMap.put(lengths[i], prices[i]);
        }

        System.out.println(maxValue(priceMap, cachedValue, rod));
    }

    /**
     *
     * @param prices
     * @param cache
     * @param rod
     * @return
     */
    private static int maxValue(Map<Integer, Integer> prices, Map<Integer, Integer> cache, int rod) {
        if (cache.containsKey(rod)) {
            return cache.get(rod);
        }

        int maxValue = prices.getOrDefault(rod, 0);

        for (Map.Entry<Integer, Integer> entry : prices.entrySet()) {
            int tempLength = entry.getKey();
            int choppedLength = rod - tempLength;

            if (tempLength < rod) {
                int choppedValue = entry.getValue() + maxValue(prices, cache, choppedLength);
                maxValue = (choppedValue > maxValue) ? choppedValue : maxValue;
            }
        }

        cache.put(rod, maxValue);
        return maxValue;
    }
}
