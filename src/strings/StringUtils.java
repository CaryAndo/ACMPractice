package strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public final class StringUtils {
    private StringUtils() {

    }

    /**
     * Reverses all the words in a string but not the whole string
     *
     * @param string
     * @return
     */
    public static String reverseWordsInString(String string) {
        return null;
    }

    public static Collection<Character> inFirstButNotSecond(String first, String second) {

        return null;
    }

    /**
     * Check if two Strings are anagrams of each other
     *
     * @param first  First String
     * @param second Second String
     * @return Whether the two Strings are anagrams
     */
    public static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : first.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (char c : second.toCharArray()) {
            if (charMap.containsKey(c)) {
                if (charMap.get(c) == 1) {
                    charMap.remove(c);
                } else {
                    charMap.put(c, charMap.get(c) - 1);
                }
            } else {
                return false;
            }
        }

        return charMap.size() == 0;
    }

    /**
     * Determine the number of deletions (from either String) needed to make the Strings anagrams
     *
     * @param first  The first String to potentially edit
     * @param second The second String to potentially edit
     * @return The minimum number of edits needed to make the two Strings anagrams
     */
    public static int editsNeededForAnagram(String first, String second) {
        int edits = 0;
        Map<Character, Integer> firstCountMap = new HashMap<>();
        Map<Character, Integer> secondCountMap = new HashMap<>();

        for (Character c : first.toCharArray()) {
            if (firstCountMap.containsKey(c)) {
                firstCountMap.put(c, firstCountMap.get(c) + 1);
            } else {
                firstCountMap.put(c, 1);
            }
        }

        for (Character c : second.toCharArray()) {
            if (secondCountMap.containsKey(c)) {
                secondCountMap.put(c, secondCountMap.get(c) + 1);
            } else {
                secondCountMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : firstCountMap.entrySet()) {
            if (secondCountMap.containsKey(entry.getKey())) {
                int otherCount = secondCountMap.get(entry.getKey());
                if (entry.getValue() > otherCount) {
                    edits += Math.abs(entry.getValue() - otherCount);
                    firstCountMap.put(entry.getKey(), otherCount);
                } else if (entry.getValue() < otherCount) {
                    edits += Math.abs(entry.getValue() - otherCount);
                    secondCountMap.put(entry.getKey(), entry.getValue());
                }
            } else {
                edits += entry.getValue();
            }
        }

        for (Map.Entry<Character, Integer> entry : secondCountMap.entrySet()) {
            if (firstCountMap.containsKey(entry.getKey())) {
                int otherCount = firstCountMap.get(entry.getKey());
                edits += Math.abs(entry.getValue() - otherCount);
            } else {
                edits += entry.getValue();
            }
        }

        return edits;
    }
}
