package dataStructure;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS<T> {
    private Object[] node;
    private final int SIZE;

    private int lastIdx;

    public BFS(int size) {
        SIZE = size;
        node = new Object[size + 1];
    }

    public boolean isFull() {
        return lastIdx == SIZE;
    }

    public void add(T data) {
        if (isFull()) return;
        node[++lastIdx] = data;
    }

    public void bfs() {
        int lvl = 0;
        int current = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            System.out.println("레벨 : " + " " + lvl++);
            for (int i = 0; i < queue.size(); i++) {
                current = queue.poll();

                System.out.print(node[current] + ", ");

                if (current * 2 <= lastIdx) {
                    queue.offer(current * 2);
                }
                if (current * 2 + 1 <= lastIdx) {
                    queue.offer(current * 2 + 1);
                }
            }
            System.out.println();
        }
    }
}
