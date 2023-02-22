package dataStructure;

public class CompleteBinaryTreeTest {
    public static void main(String[] args) {
        int size = 9;

//        BFS<Character> tree = new BFS<>(size);
        CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(size);
        for (int i = 0; i < size; ++i) {
            tree.add((char) (65 + i));
        }

//        System.out.print(tree);
        tree.bfs();
    }
}