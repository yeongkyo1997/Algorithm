#include <iostream>
#include <vector>
#include <string>
#include <memory> 

struct TrieNode {
    TrieNode* children[26];
    int count;             

    TrieNode() : count(0) {
        for (int i = 0; i < 26; ++i) {
            children[i] = nullptr;
        }
    }

    ~TrieNode() {
        for (int i = 0; i < 26; ++i) {
            delete children[i]; 
        }
    }
};

void insert(TrieNode* root, const std::string& s) {
    TrieNode* current = root;
    current->count++;
    for (char ch : s) {
        int index = ch - 'A'; 
        if (!current->children[index]) {
            current->children[index] = new TrieNode();
        }
        current = current->children[index]; 
        current->count++;                  
    }
}

long long calculate_score_dfs(TrieNode* node, int depth, int k) {
    if (!node) {
        return 0; 
    }

    long long score_from_children_subtrees = 0;
    long long groups_formed_at_children_level = 0;

    for (int i = 0; i < 26; ++i) {
        if (node->children[i]) {
            score_from_children_subtrees += calculate_score_dfs(node->children[i], depth + 1, k);
            groups_formed_at_children_level += (node->children[i]->count / k);
        }
    }

    long long groups_possible_at_node = node->count / k;

    long long groups_formed_exactly_here = groups_possible_at_node - groups_formed_at_children_level;

    long long current_node_score_contribution = groups_formed_exactly_here * depth;

    return score_from_children_subtrees + current_node_score_contribution;
}

long long solve() {
    int N, K;
    std::cin >> N >> K;

    TrieNode root;

    for (int i = 0; i < N; ++i) {
        std::string s;
        std::cin >> s;
        insert(&root, s);
    }

    return calculate_score_dfs(&root, 0, K);
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int T;
    std::cin >> T;
    for (int i = 1; i <= T; ++i) {
        long long result = solve();
        std::cout << "Case #" << i << ": " << result << std::endl;
    }
    return 0;
}