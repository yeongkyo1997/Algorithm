#include <iostream>
#include <vector>

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int n, m;
    std::cin >> n >> m;

    std::vector<std::vector<int>> a(n, std::vector<int>(m));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            std::cin >> a[i][j];
        }
    }

    int m_b, k;
    std::cin >> m_b >> k;

    std::vector<std::vector<int>> b(m, std::vector<int>(k));
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < k; ++j) {
            std::cin >> b[i][j];
        }
    }

    std::vector<std::vector<int>> c(n, std::vector<int>(k, 0));

    for (int i = 0; i < n; ++i) {
        for (int p = 0; p < m; ++p) {
            for (int j = 0; j < k; ++j) {
                c[i][j] += a[i][p] * b[p][j];
            }
        }
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < k; ++j) {
            std::cout << c[i][j] << (j == k - 1 ? "" : " ");
        }
        std::cout << "\n";
    }

    return 0;
}