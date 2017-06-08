package strings;


import java.util.ArrayList;
import java.util.List;

/**
 *    A class to generate the cartesian product of a list of Strings
 *    The class has two constructors and uses two different approaches
 *    The first involves front-loading the calculation of the cartesian product
 *    and has a O(1) time complexity for retrieving products in order.
 *    The second (more balanced) approach saves the creation of the products until
 *    the class is asked for the next one in order.
 *
 *    Example of a cartesian product:
 *    {"cats", "hi" , "lol"}
 *    chl cho chl cil cio cil... etc.
 *
 *    For the first approach:
 *    n = number of words
 *    L = length of longest word
 *    space: O(L^n)
 *    time: O(L*?) lol way not great
 *
 *
 *    CPGenerator cp = new CPGenerator({"cats", "hi" , "lol"})
 *    onsubmit.onclick = cp.next(); -> "cho"
 *    cp.next() -> cio
 */
public class CPGenerator {
    private int index = 0;
    private List<String> array;
    int[] indices;

    /**
     * {"cat", "dog"}
     * {"c", "a", "t"}
     * {"cd", "cd", "cg", }
     */
    public List<String> combinations(String[] arr) {
        if (arr == null) {
            return null;
        }

        List<String> combinations = new ArrayList<>();
        for (Character c : arr[0].toCharArray()) {
            combinations.add(c.toString());
        }

        for (int i = 1; i < arr.length; i++) {
            combinations = combine(combinations, arr[i]);
        }

        return combinations;
    }

    /**
     * {{'c','a', 't'}, "dog"}
     * cd co cg        ad ao ag      td to tg
     */
    public List<String> combine(List<String> combos, String str2) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < combos.size(); j++) {
                ret.add(combos.get(j) + str2.charAt(j));
            }
        }

        return ret;
    }

    public CPGenerator(String[] arr) {
        this.array = combinations(arr);
        this.indices = new int[arr.length];
    }

    private void incrementArray(List<String> arr, int[] indices) {
        int carry = 1;
        for (int i = indices.length - 1; i >= 0; i--) {
            if (indices[i] + carry == arr.get(i).length()) {
                indices[i] = 0;
            } else {
                indices[i] += carry;
                return;
            }
        }
    }

    // {"cat", "dog"}
    // {0, 0}
    // cd co

    public String getNext2() {
        StringBuilder sb = new StringBuilder("");
        String s = "";
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i).charAt(indices[i]));
        }
        incrementArray(array, indices);
        return sb.toString();
    }

    public boolean hasNext() {
        return index < array.size();
    }

    public boolean hasNext2() {
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < array.get(i).length()) {
                return true;
            }
        }

        return false;
    }

    public String getNext() {
        /*{"cat", "dog"}
        [0, 0]
        [0, 1]
        [0, 2]
        [1, 0]
        [1, 1]*/
        if (index >= array.size()) {
            return null;
        }

        String ret = array.get(index);
        index++;
        return ret;
    }
}