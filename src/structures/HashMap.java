package structures;

/**
 * Created by cary on 5/21/17.
 */
public class HashMap<T, E> {
    private static final int INITIAL_TABLE_SIZE = 256; // idk
    private E[] values;

    public HashMap() {
        values = (E[]) new Object[INITIAL_TABLE_SIZE];
    }
}
