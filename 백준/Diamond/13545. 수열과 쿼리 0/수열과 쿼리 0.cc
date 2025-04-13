#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <deque>

std::vector<int> diff_counts_arr;
std::vector<int> block_max;
int diff_block_size;
int num_diff_blocks;
int n_global;

void update_max_diff_block(int block_idx) {
    int start_diff = block_idx * diff_block_size;
    int end_diff = std::min((block_idx + 1) * diff_block_size - 1, n_global);
    int current_max = -1;
    for (int d = end_diff; d >= start_diff; --d) {
        if (d >= 0 && d < diff_counts_arr.size() && diff_counts_arr[d] > 0) {
            current_max = d;
            break;
        }
    }
    if (block_idx >= 0 && block_idx < block_max.size()) {
       block_max[block_idx] = current_max;
    }
}

void modify_diff(int diff, int delta) {
    if (diff < 0 || diff > n_global) return;

    int block_idx = diff / diff_block_size;
     if (block_idx < 0 || block_idx >= num_diff_blocks) return;

    int old_count = diff_counts_arr[diff];
    diff_counts_arr[diff] += delta;
    int new_count = diff_counts_arr[diff];

     if (new_count < 0) {
         diff_counts_arr[diff] = 0;
         new_count = 0;
     }

    if (delta > 0) {
        if (new_count > 0 && diff > block_max[block_idx]) {
            block_max[block_idx] = diff;
        }
    } else {
        if (old_count > 0 && new_count <= 0 && diff == block_max[block_idx]) {
            update_max_diff_block(block_idx);
        }
    }
}


struct Query {
    int id;
    int i;
    int j;
    int block;
};

bool compareQueries(const Query& a, const Query& b) {
    if (a.block != b.block) {
        return a.block < b.block;
    }
    if (a.block % 2 == 1) {
        return a.j > b.j;
    } else {
        return a.j < b.j;
    }
}

std::vector<long long> P;
std::vector<std::deque<int>> indices_list;

void add(int k, bool adding_left) {
     if (k < 0 || k >= P.size()) return;
    long long val_ll = P[k];
     if (val_ll < 0 || val_ll >= indices_list.size()) return;
     int val = static_cast<int>(val_ll);


    int old_size = indices_list[val].size();
    if (old_size >= 2) {
        int old_diff = indices_list[val].back() - indices_list[val].front();
        modify_diff(old_diff, -1);
    }

    if (adding_left) {
        indices_list[val].push_front(k);
    } else {
        indices_list[val].push_back(k);
    }

    int new_size = indices_list[val].size();
    if (new_size >= 2) {
        int new_diff = indices_list[val].back() - indices_list[val].front();
        modify_diff(new_diff, +1);
    }
}

void remove(int k) {
    if (k < 0 || k >= P.size()) return;
    long long val_ll = P[k];
    if (val_ll < 0 || val_ll >= indices_list.size()) return;
    int val = static_cast<int>(val_ll);

    if (indices_list[val].empty()) return;

    int old_size = indices_list[val].size();
    if (old_size >= 2) {
        int old_diff = indices_list[val].back() - indices_list[val].front();
        modify_diff(old_diff, -1);
    }

    if (indices_list[val].front() == k) {
        indices_list[val].pop_front();
    } else if (indices_list[val].back() == k) {
        // Only pop back if size > 1 or if size is 1 (where front==back)
        indices_list[val].pop_back();
    }


    int new_size = indices_list[val].size();
    if (new_size >= 2) {
        int new_diff = indices_list[val].back() - indices_list[val].front();
        modify_diff(new_diff, +1);
    }
}

int get_max_difference() {
     int overall_max = 0;
    for (int b = num_diff_blocks - 1; b >= 0; --b) {
         if (b < 0 || b >= block_max.size()) continue;
        if (block_max[b] != -1) {
            overall_max = block_max[b];
            break;
        }
    }
    return overall_max;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    int n;
    std::cin >> n;
    n_global = n;

    std::vector<long long> S(n + 1);
    S[0] = 0;
    for (int k = 0; k < n; ++k) {
        int ak;
        std::cin >> ak;
        S[k + 1] = S[k] + ak;
    }

    P.resize(n + 1);
    long long min_s_val = 0;
     for (int k = 0; k <= n; ++k) {
        min_s_val = std::min(min_s_val, S[k]);
     }
    long long offset = -min_s_val;
    long long max_p_val = 0;
     for (int k = 0; k <= n; ++k) {
        P[k] = S[k] + offset;
        max_p_val = std::max(max_p_val, P[k]);
    }

    indices_list.resize(max_p_val + 1);


    diff_block_size = static_cast<int>(sqrt(n + 1));
    if (diff_block_size == 0) diff_block_size = 1;
    num_diff_blocks = (n / diff_block_size) + 1;
    diff_counts_arr.assign(n + 1, 0);
    block_max.assign(num_diff_blocks, -1);


    int m;
    std::cin >> m;
    std::vector<Query> queries(m);
    int mo_block_size = static_cast<int>(sqrt(n + 1));
     if (mo_block_size == 0) mo_block_size = 1;

    for (int qi = 0; qi < m; ++qi) {
        queries[qi].id = qi;
        std::cin >> queries[qi].i >> queries[qi].j;
        queries[qi].block = (queries[qi].i - 1) / mo_block_size;
    }

    std::sort(queries.begin(), queries.end(), compareQueries);

    std::vector<int> ans(m);
    int current_l = 0;
    int current_r = -1;

    for (const auto& q : queries) {
        int L = q.i - 1;
        int R = q.j;

        L = std::max(0, L);
        R = std::min(n, R);

        if (L > R) {
             ans[q.id] = 0;
             current_l = L; // Adjust current range if needed for next query
             current_r = R;
             continue;
        }


        while (current_l > L) {
            current_l--;
            add(current_l, true);
        }
        while (current_r < R) {
            current_r++;
            add(current_r, false);
        }
        while (current_l < L) {
            remove(current_l);
            current_l++;
        }
        while (current_r > R) {
            remove(current_r);
            current_r--;
        }

        ans[q.id] = get_max_difference();

    }

    for (int i = 0; i < m; ++i) {
        std::cout << ans[i] << "\n";
    }

    return 0;
}