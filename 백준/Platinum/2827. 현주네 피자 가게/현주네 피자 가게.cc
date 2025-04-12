#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>
#include <map>

using namespace std;

typedef long long ll;

struct Node {
    ll count = 0; // Number of pizzas in the range
    ll sum_t = 0; // Sum of baking times (T) in the range
    ll sum_f = 0; // Contribution to the total Sum(Finish Times) from this range
};

vector<ll> initial_l, initial_t;
vector<ll> current_l, current_t;
vector<pair<int, pair<int, int>>> updates;
vector<int> t_values; // Stores all unique T values for compression
map<int, int> t_compress_map; // Maps original T to compressed index
vector<int> t_decompress_map; // Maps compressed index back to original T
vector<Node> tree; // Segment tree
int n, c;
int compressed_size; // Number of unique T values

Node merge(const Node& left, const Node& right) {
    Node result;
    result.count = left.count + right.count;
    result.sum_t = left.sum_t + right.sum_t;
    result.sum_f = left.sum_f + right.sum_f + right.count * left.sum_t;
    return result;
}

void update_tree(int node_idx, int range_start, int range_end, int target_compressed_idx, int t_val, int type) {
    if (range_start == range_end) {
        if (range_start != target_compressed_idx) return;

        if (type == 1) { // Add pizza
            tree[node_idx].count++;
            tree[node_idx].sum_t += t_val;
        } else { // Remove pizza
            tree[node_idx].count--;
            tree[node_idx].sum_t -= t_val;
        }

        if (tree[node_idx].count > 0) {
             int actual_T = t_decompress_map[target_compressed_idx];
             tree[node_idx].sum_f = (ll)actual_T * tree[node_idx].count * (tree[node_idx].count + 1) / 2;
        } else {
             tree[node_idx].sum_f = 0;
             tree[node_idx].sum_t = 0; // Ensure sum_t is also 0
        }
        return;
    }

    int mid = range_start + (range_end - range_start) / 2;
    int left_child = 2 * node_idx;
    int right_child = 2 * node_idx + 1;

    if (target_compressed_idx <= mid) {
        update_tree(left_child, range_start, mid, target_compressed_idx, t_val, type);
    } else {
        update_tree(right_child, mid + 1, range_end, target_compressed_idx, t_val, type);
    }

    tree[node_idx] = merge(tree[left_child], tree[right_child]);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> c;

    initial_l.resize(n + 1);
    initial_t.resize(n + 1);
    current_l.resize(n + 1);
    current_t.resize(n + 1);
    updates.resize(c);

    ll total_l = 0; // Stores the current sum of all L_i

    for (int i = 1; i <= n; ++i) {
        cin >> initial_l[i] >> initial_t[i];
        current_l[i] = initial_l[i];
        current_t[i] = initial_t[i];
        t_values.push_back(initial_t[i]);
        total_l += initial_l[i];
    }

    for (int i = 0; i < c; ++i) {
        cin >> updates[i].first >> updates[i].second.first >> updates[i].second.second;
        t_values.push_back(updates[i].second.second);
    }

    sort(t_values.begin(), t_values.end());
    t_values.erase(unique(t_values.begin(), t_values.end()), t_values.end()); // Keep only unique values

    compressed_size = t_values.size(); // Number of unique T values
    t_decompress_map.resize(compressed_size);
    for (int i = 0; i < compressed_size; ++i) {
        t_compress_map[t_values[i]] = i; // Map T -> compressed index
        t_decompress_map[i] = t_values[i]; // Map compressed index -> T
    }

    tree.resize(4 * compressed_size);

    for (int i = 1; i <= n; ++i) {
        update_tree(1, 0, compressed_size - 1, t_compress_map[current_t[i]], current_t[i], 1); // Add initial pizzas
    }

    cout << total_l - tree[1].sum_f << "\n";

    for (int i = 0; i < c; ++i) {
        int r = updates[i].first;          // Person index
        int l_new = updates[i].second.first; // New desired time
        int t_new = updates[i].second.second; // New baking time

        ll l_old = current_l[r]; // Get old desired time
        ll t_old = current_t[r]; // Get old baking time

        update_tree(1, 0, compressed_size - 1, t_compress_map[t_old], t_old, -1);

        total_l -= l_old;
        total_l += l_new;

        update_tree(1, 0, compressed_size - 1, t_compress_map[t_new], t_new, 1);

        current_l[r] = l_new;
        current_t[r] = t_new;

        cout << total_l - tree[1].sum_f << "\n";
    }

    return 0;
}