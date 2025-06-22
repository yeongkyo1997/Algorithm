#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <set>

using namespace std;

using i128 = __int128_t;

void print_i128(i128 n) {
    if (n == 0) {
        cout << "0";
        return;
    }
    string s = "";
    bool neg = n < 0;
    if (neg) {
        n = -n;
    }
    while (n > 0) {
        s += (n % 10) + '0';
        n /= 10;
    }
    if (neg) {
        s += '-';
    }
    reverse(s.begin(), s.end());
    cout << s;
}

i128 count_in_range(long long low, long long high, long long r, long long K) {
    if (low > high) {
        return 0;
    }
    long long first = low;
    long long rem_low = low % K;
    if (rem_low != r) {
        first += (r - rem_low + K) % K;
    }
    if (first > high) {
        return 0;
    }
    return (i128)(high - first) / K + 1;
}

i128 sum_in_range(long long low, long long high, long long r, long long K) {
    i128 n = count_in_range(low, high, r, K);
    if (n == 0) {
        return 0;
    }
    long long first_val = low;
    long long rem_low = low % K;
    if (rem_low != r) {
        first_val += (r - rem_low + K) % K;
    }
    i128 a1 = first_val;
    i128 an = a1 + (n - 1) * K;
    return (a1 + an) * n / 2;
}

i128 get_count_for_rem(long long r, long long N, long long M, long long K) {
    i128 total = 0;

    i128 n1 = count_in_range(0, N, r, K);
    if (n1 > 0) {
        i128 sum1 = sum_in_range(0, N, r, K);
        total += sum1 + n1;
    }

    i128 n2 = count_in_range(N + 1, M, r, K);
    total += n2 * (i128)(N + 1);

    i128 n3 = count_in_range(M + 1, N + M, r, K);
    if (n3 > 0) {
        i128 sum3 = sum_in_range(M + 1, N + M, r, K);
        total += n3 * (i128)(N + M + 1) - sum3;
    }
    
    return total;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long n_orig, m_orig, k;
    cin >> n_orig >> m_orig >> k;

    long long n = min(n_orig, m_orig);
    long long m = max(n_orig, m_orig);

    set<long long> candidates;
    for (long long i = 0; i < 4 && i < k; ++i) {
        candidates.insert(i);
    }
    if (k > 0) {
        for (long long i = 1; i < 4 && i < k; ++i) {
            candidates.insert(k - i);
        }
    }

    long long n_rem = n % k;
    for (long long i = -3; i <= 3; ++i) {
        candidates.insert((n_rem + i + k) % k);
    }
    long long m_rem = m % k;
    for (long long i = -3; i <= 3; ++i) {
        candidates.insert((m_rem + i + k) % k);
    }

    i128 max_val = -1;
    long long max_color = -1;
    i128 min_val = -1;
    long long min_color = -1;

    for (long long r : candidates) {
        if (r < 0 || r >= k) continue;
        
        i128 current_count = get_count_for_rem(r, n, m, k);

        if (max_color == -1 || current_count > max_val) {
            max_val = current_count;
            max_color = r + 1;
        }
        if (min_color == -1 || current_count < min_val) {
            min_val = current_count;
            min_color = r + 1;
        }
    }

    cout << max_color << " ";
    print_i128(max_val);
    cout << "\n";

    cout << min_color << " ";
    print_i128(min_val);
    cout << "\n";

    return 0;
}