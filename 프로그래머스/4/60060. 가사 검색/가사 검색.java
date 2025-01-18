import java.util.*;

class Solution {
    
    static class TrieNode {
        TrieNode[] children = new TrieNode[26]; 
        int count = 0;  
    }

    
    static TrieNode[] forwardRoots;
    static TrieNode[] backwardRoots;
    
    
    static final int MAX_LEN = 10000;

    
    public void insertForward(String word) {
        int length = word.length();
        TrieNode root = forwardRoots[length];
        for (char c : word.toCharArray()) {
            root.count++;
            int idx = c - 'a';
            if (root.children[idx] == null) {
                root.children[idx] = new TrieNode();
            }
            root = root.children[idx];
        }
        root.count++;
    }

    
    public void insertBackward(String word) {
        int length = word.length();
        TrieNode root = backwardRoots[length];
        
        for (int i = word.length()-1; i >= 0; i--) {
            char c = word.charAt(i);
            root.count++;
            int idx = c - 'a';
            if (root.children[idx] == null) {
                root.children[idx] = new TrieNode();
            }
            root = root.children[idx];
        }
        root.count++;
    }

    
    public int searchForward(String prefix) {
        int length = prefix.length();
        
        
        return 0; 
    }

    
    public int searchBackward(String suffix) {
        return 0; 
    }

    public int[] solution(String[] words, String[] queries) {
        
        forwardRoots = new TrieNode[MAX_LEN + 1];
        backwardRoots = new TrieNode[MAX_LEN + 1];
        for (int i = 0; i <= MAX_LEN; i++) {
            forwardRoots[i] = new TrieNode();
            backwardRoots[i] = new TrieNode();
        }

        
        for (String w : words) {
            insertForward(w);
            insertBackward(w);
        }

        
        Map<String,Integer> cache = new HashMap<>();
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            
            if (cache.containsKey(query)) {
                answer[i] = cache.get(query);
                continue;
            }

            
            int qLen = query.length();
            
            if (query.charAt(0) != '?') {
                
                
                int idx = query.indexOf('?'); 
                String prefix = query.substring(0, idx);
                answer[i] = searchForward(prefix, qLen);
            } else {
                
                
                int idx = query.lastIndexOf('?');
                String suffix = query.substring(idx+1);
                answer[i] = searchBackward(suffix, qLen);
            }

            cache.put(query, answer[i]);
        }
        return answer;
    }

    
    private int searchForward(String prefix, int totalLength) {
        TrieNode root = forwardRoots[totalLength];
        for (char c : prefix.toCharArray()) {
            if (root == null) return 0;
            int idx = c - 'a';
            if (root.children[idx] == null) return 0;
            root = root.children[idx];
        }
        return (root == null) ? 0 : root.count;
    }

    
    private int searchBackward(String suffix, int totalLength) {
        TrieNode root = backwardRoots[totalLength];
        
        for (int i = suffix.length()-1; i >= 0; i--) {
            char c = suffix.charAt(i);
            if (root == null) return 0;
            int idx = c - 'a';
            if (root.children[idx] == null) return 0;
            root = root.children[idx];
        }
        return (root == null) ? 0 : root.count;
    }
}