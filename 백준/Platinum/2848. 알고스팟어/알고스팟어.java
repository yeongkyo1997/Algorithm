import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int wordNum, usedCnt = 0;
    static List<String> dictionary = new LinkedList<>();
    static List<Integer> alphaOrder = new LinkedList<>();
    static boolean[] visited;
    static int[] indegree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        wordNum = Integer.parseInt(br.readLine());
        visited = new boolean[26];
        indegree = new int[26];
        graph = new List[26];

        String tmp;
        IntStream.range(0, 26).forEach(i -> graph[i] = new LinkedList<>());

        for (int i = 0; i < wordNum; ++i) {
            tmp = br.readLine();
            dictionary.add(tmp);

            for (int j = 0; j < tmp.length(); ++j) {
                if (!visited[tmp.charAt(j) - 'a']) {
                    visited[tmp.charAt(j) - 'a'] = true;
                    usedCnt++;
                }
            }
        }

        boolean isPossible = true;
        Queue<Integer> queue;
        for (int i = 0; i < wordNum - 1; i++) {
            for (int j = 0; j < dictionary.get(i).length(); j++) {
                if (j < dictionary.get(i + 1).length()) {
                    if (dictionary.get(i).charAt(j) != dictionary.get(i + 1).charAt(j)) {
                        graph[dictionary.get(i).charAt(j) - 'a'].add(dictionary.get(i + 1).charAt(j) - 'a');
                        indegree[dictionary.get(i + 1).charAt(j) - 'a']++;
                        break;
                    }
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        queue = IntStream.range(0, 26).filter(i -> visited[i]).filter(i -> indegree[i] == 0).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        boolean order = true;
        int alphabetIdx;

        for (int i = 0; i < usedCnt; ++i) {
            if (queue.isEmpty()) {
                isPossible = false;
                break;
            }

            alphabetIdx = queue.poll();

            if (queue.size() >= 1) order = false;
            else alphaOrder.add(alphabetIdx);

            for (int j = 0; j < graph[alphabetIdx].size(); ++j) {
                if (--indegree[graph[alphabetIdx].get(j)] == 0) queue.add(graph[alphabetIdx].get(j));
            }

        }

        if (!isPossible) bw.write("!\n");
        else if (order) {
            for (Integer integer : alphaOrder) bw.write((char) (integer + 'a'));
            bw.write("\n");
        } else bw.write("?\n");

        bw.close();
    }
}