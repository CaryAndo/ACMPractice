package dp;

import java.util.Map;

/**
 * Created by cary on 6/3/17.
 */
public final class StairSteps {
    private int a;
    private int b;
    private int c;

    public static int steps(int stepNumber, Map<Integer, Integer> cache) {
        if (cache.containsKey(stepNumber)) {
            return cache.get(stepNumber);
        }

        if (stepNumber < 0) {
            return 0;
        } else if (stepNumber == 0) {
            return 1;
        }

        int ret = steps(stepNumber - 1, cache)
                + steps(stepNumber - 2, cache)
                + steps(stepNumber - 3, cache);

        cache.put(stepNumber, ret);
        return ret;
    }
}
