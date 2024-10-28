#include <bits/stdc++.h>
using namespace std;

void generate_subsets(int n, int k, int start, int bitmask, vector<int> &subsets_bitmask)
{
    if (k == 0)
    {
        subsets_bitmask.push_back(bitmask);
        return;
    }
    for (int i = start; i < n; i++)
    {
        generate_subsets(n, k - 1, i + 1, bitmask | (1 << i), subsets_bitmask);
    }
}

vector<int> get_dice_indices(int bitmask, int n)
{
    vector<int> indices;
    for (int i = 0; i < n; i++)
    {
        if (bitmask & (1 << i))
        {
            indices.push_back(i);
        }
    }
    return indices;
}

vector<long long> compute_sum_freq(const vector<vector<int>> &dice, const vector<int> &subset_indices)
{
    vector<long long> sum_freq(501, 0);
    sum_freq[0] = 1;

    for (auto &die_idx : subset_indices)
    {
        vector<long long> new_sum_freq(501, 0);
        for (int s = 0; s <= 500; s++)
        {
            if (sum_freq[s] == 0)
                continue;
            for (auto &face : dice[die_idx])
            {
                int new_s = s + face;
                if (new_s > 500)
                    continue;
                new_sum_freq[new_s] += sum_freq[s];
            }
        }
        sum_freq = move(new_sum_freq);
    }
    return sum_freq;
}

vector<long long> compute_prefix_sum(const vector<long long> &sum_freq)
{
    vector<long long> prefix_sum(sum_freq.size(), 0);
    prefix_sum[0] = sum_freq[0];
    for (int s = 1; s < sum_freq.size(); s++)
    {
        prefix_sum[s] = prefix_sum[s - 1] + sum_freq[s];
    }
    return prefix_sum;
}

vector<int> solution(vector<vector<int>> dice)
{
    int n = dice.size();
    int k = n / 2;

    vector<int> subsets_bitmask;
    generate_subsets(n, k, 0, 0, subsets_bitmask);

    unordered_map<int, int> bitmask_to_index;
    for (int i = 0; i < subsets_bitmask.size(); i++)
    {
        bitmask_to_index[subsets_bitmask[i]] = i;
    }

    int total_subsets = subsets_bitmask.size();
    vector<vector<long long>> all_sum_freq(total_subsets, vector<long long>());
    vector<vector<long long>> all_prefix_sum(total_subsets, vector<long long>());

    for (int i = 0; i < total_subsets; i++)
    {
        vector<int> subset_indices = get_dice_indices(subsets_bitmask[i], n);
        all_sum_freq[i] = compute_sum_freq(dice, subset_indices);
        all_prefix_sum[i] = compute_prefix_sum(all_sum_freq[i]);
    }

    long long max_win = -1;
    int best_subset_index = -1;

    for (int i = 0; i < total_subsets; i++)
    {
        int subset_A_bitmask = subsets_bitmask[i];
        int subset_B_bitmask = (~subset_A_bitmask) & ((1 << n) - 1);

        if (bitmask_to_index.find(subset_B_bitmask) == bitmask_to_index.end())
            continue;
        int j = bitmask_to_index[subset_B_bitmask];

        vector<long long> &sum_freq_A = all_sum_freq[i];
        vector<long long> &sum_freq_B = all_sum_freq[j];
        vector<long long> &prefix_sum_B = all_prefix_sum[j];

        long long win_A = 0;
        for (int s_A = 1; s_A <= 500; s_A++)
        {
            if (s_A == 0)
                continue;
            if (s_A - 1 >= 0)
            {
                win_A += sum_freq_A[s_A] * prefix_sum_B[s_A - 1];
            }
        }

        if (win_A > max_win)
        {
            max_win = win_A;
            best_subset_index = i;
        }
    }

    vector<int> best_subset = get_dice_indices(subsets_bitmask[best_subset_index], n);
    for (auto &idx : best_subset)
        idx += 1;
    sort(best_subset.begin(), best_subset.end());

    return best_subset;
}
