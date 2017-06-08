import etc.PrimeNumberSieve;

public class Main {

    public static void main(String[] args) {



        PrimeNumberSieve.printPrimesInRange(100, 2000);

        /*TrieNode root = new TrieNode(' ');
        TrieNode.addWord("hey", root);
        TrieNode.addWord("heyboi", root);
        TrieNode.addWord("boi", root);
        TrieNode.addWord("bois", root);

        PrimeNumberSieve sieve = new PrimeNumberSieve(2000);
        List<Integer> thePrimes = sieve.getPrimesInRange(0, 100);
        System.out.println(thePrimes);*/
        //int count = TrieNode.partialWordCount("he", root);
        //System.out.println(count);

        /*
        int[][] a = {
                {1, 2, 3, 4},
                {1, 1, 3, 3},
                {4, 2, 1, 6},
                {9, 9, 9, 1}};

        boolean diagnalOkay = ArrayUtils.checkDiagnal(a, 2, 0);
        System.out.println("diagonal is okay: " + diagnalOkay);*/

/*
        char[] a = new char[26];
        for (int i = 0; i < 26; i++) {
            a[i] = (char) (65 + i);
        }

        String str = "";
        int number = 17577;

        while (number >= 0) {
            if (number < 26) {
                str = a[number] + str;
                break;
            } else {
                str = a[number % 26] + str;
                number = (number / 26) - 1;
            }
        }
        Map<Integer, List<Pair<Integer, Integer>>> f = new HashMap<>();
        */

        //System.out.println(str);
        /*System.out.println("Hello World!");
        int[] test = {12, 3, 7, 4, 2, 1, 9, 5};

        int[] i = {10, 10, 10, 10, 2, 14, 8, 4, 1, 6, 7, 9};
        int[] j = {2, 8, 14};



        Mergesort.mergesort(i);
        System.out.println(Arrays.toString(i));

        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> left = new TreeNode<>( 2);
        TreeNode<Integer> right = new TreeNode<>(3);
        TreeNode<Integer> l1 = new TreeNode<>(4);
        TreeNode<Integer> r1 = new TreeNode<>(5);
        TreeNode<Integer> l2 = new TreeNode<>(6);

        TreeNode<Integer> deep1 = new TreeNode<>(9);
        TreeNode<Integer> deepLeft = new TreeNode<>(11);
        TreeNode<Integer> deep2 = new TreeNode<>(10);

        root.setLeft(left);
        root.setRight(right);

        left.setLeft(l1);
        left.setRight(r1);

        right.setLeft(l2);

        deep1.setRight(deep2);
        r1.setRight(deep1);

        for (TreeNode what : root) {
            //System.out.println(what.getData());
        }

        for (TreeNode what : root.byLevel()) {
            //System.out.println(what.getData());
        }

        System.out.println("Height of the tree is: " + TreeUtils.treeHeight(root));
        System.out.println("The tree is balanced: " + TreeUtils.treeIsBalanced(root));

        /*TreeUtils.printLevels(root);

        System.out.println("Printing PreOrder:" + root.hashCode());
        TreeUtils.printPreOrder(root);
        System.out.println("Printing InOrder:");
        TreeUtils.printInOrder(root);
        System.out.println("Printing PostOrder:");
        TreeUtils.printPostOrder(root);*/

        //int[] testMerge = Mergesort.merge(i, j);
        //System.out.println(Arrays.toString(testMerge));

        //System.out.println(Arrays.toString(test));
        //sorting.Quicksort.quicksortInPlace(test, 0, test.length - 1);
        //quickSortPartition(test, 0, test.length - 1);
        //System.out.println(Arrays.toString(test));

    }
}
