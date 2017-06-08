package dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cary on 6/3/17.
 */
public final class BoxStacking {

    private static class Box {
        public int height;
        public int width;
        public int depth;
    }

    public static int getTallestStackHeight(List<Box> boxes) {
        HashMap<Box, Integer> cache = new HashMap<>();

        return getMaxBoxHeight(cache, boxes, 0);
    }

    private static int getMaxBoxHeight(Map<Box, Integer> cache, List<Box> boxes, int box) {
        if (cache.containsKey(boxes.get(box))) {
            return cache.get(boxes.get(box));
        }

        int maxHeight = 0;
        Box currentBox = boxes.get(box);

        for (int i = 0; i < boxes.size(); i++) {
            if (i != box && boxFits(boxes.get(i), currentBox)) {
                maxHeight = Math.max(getMaxBoxHeight(cache, boxes, i) , maxHeight);
            }
        }
        maxHeight += currentBox.height;

        cache.put(boxes.get(box), maxHeight);
        return maxHeight;
    }

    private static boolean boxFits(Box candidate, Box onto) {
        return candidate.height > onto.height
                && candidate.width > onto.height
                && candidate.depth > onto.depth;
    }

}
