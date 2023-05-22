#include <bits/stdc++.h>

class Pair {
public:
    int height;
    int cnt;

    Pair(int height, int cnt) : height(height), cnt(cnt) {}
};

int main() {
    int n;
    std::cin >> n;

    std::stack<Pair> stack;
    long long cnt = 0;

    for (int i = 0; i < n; ++i) {
        int height;
        std::cin >> height;
        Pair pair(height, 1);

        while (!stack.empty() && stack.top().height <= height) {
            Pair pop = stack.top();
            stack.pop();
            cnt += pop.cnt;
            if (pop.height == height)
                pair.cnt += pop.cnt;
        }

        if (!stack.empty())
            cnt++;

        stack.push(pair);
    }

    std::cout << cnt << std::endl;

    return 0;
}