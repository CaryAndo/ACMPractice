package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * A Node for use when constructing a Trie
 */
public class TrieNode {
    private char value;
    private Map<Character, TrieNode> children;
    private boolean endOfWord = false;
    private TrieNode parent;
    private int wordsInTree = 0;

    public TrieNode(char value) {
        this.value = value;
        this.children = new HashMap<>();
    }

    public void addChild(char c, boolean isEndOfWord) {
        TrieNode newTrieNode = new TrieNode(c);
        newTrieNode.isEndOfWord(isEndOfWord);
        newTrieNode.parent = this;
        children.put(c, newTrieNode);
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void isEndOfWord(boolean is) {
        this.endOfWord = is;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public TrieNode getParent() {
        return parent;
    }

    public void setParent(TrieNode node) {
        this.parent = node;
    }

    public int getWordsInTree() {
        return wordsInTree;
    }

    public static void addWord(String word, TrieNode root) {
        StringBuilder sb = new StringBuilder(word);
        addWord(sb, root);
    }

    public static void addWord(StringBuilder wordBuilder, TrieNode root) {
        char firstCharacter = wordBuilder.charAt(0);
        if (root.getChildren().containsKey(firstCharacter)) {
            if (wordBuilder.length() == 1) {
                root.getChildren().get(firstCharacter).isEndOfWord(true);
            } else {
                wordBuilder.deleteCharAt(0);
                addWord(wordBuilder, root.getChildren().get(firstCharacter));
            }
        } else if (wordBuilder.length() == 1) {
            root.addChild(firstCharacter, true);
            addOneToParentTrees(root.getChildren().get(firstCharacter));
        } else {
            root.addChild(firstCharacter, false);
            TrieNode node = root.getChildren().get(firstCharacter);
            wordBuilder.deleteCharAt(0);
            addWord(wordBuilder, node);
        }
    }

    /**
     * Return the number of words that start with a given partial word
     *
     * @param word The partial word to check for
     * @param root The root of the Trie
     * @return The number of words in our dictionary (Trie) that start with the word given
     */
    public static int partialWordCount(String word, TrieNode root) {
        StringBuilder sb = new StringBuilder(word);
        return partialWordCount(sb, root);
    }

    private static int partialWordCount(StringBuilder word, TrieNode root) {
        if (word.length() == 0) {
            return root.wordsInTree;
        } else if (root.getChildren().containsKey(word.charAt(0))) {
            char firstCharacter = word.charAt(0);
            word.deleteCharAt(0);
            return partialWordCount(word, root.getChildren().get(firstCharacter));
        } else {
            return 0;
        }
    }

    private static void addOneToParentTrees(TrieNode node) {
        if (node != null) {
            node.wordsInTree += 1;
            addOneToParentTrees(node.getParent());
        }
    }
}
