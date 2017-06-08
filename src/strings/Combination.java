package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * A combination of an arbitrary number of lists
 *
 */
public class Combination<T> {
    private List<T> mCombinedList;

    public Combination(List<T> list) {
        mCombinedList = new ArrayList<>();
    }

    /**
     * Return a list of ways there are to select r elements from the set we were initialized with
     * @param r The number of elements to select
     * @return
     */
    public List<List<T>> select(int r) {
        return null;
    }
}
