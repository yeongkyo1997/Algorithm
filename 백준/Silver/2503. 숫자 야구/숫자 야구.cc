#include <iostream>
#include <vector>

using namespace std;

struct Query {
    int digits[3];
    int strike;
    int ball;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<Query> queries;
    for (int i = 0; i < N; ++i) {
        int num, s, b;
        cin >> num >> s >> b;
        int d1 = num / 100;
        int d2 = (num / 10) % 10;
        int d3 = num % 10;
        queries.push_back({{d1, d2, d3}, s, b});
    }

    int valid_count = 0;

    for (int a = 1; a <= 9; ++a) {
        for (int b = 1; b <= 9; ++b) {
            if (b == a) continue;
            for (int c = 1; c <= 9; ++c) {
                if (c == a || c == b) continue;
                
                bool is_valid = true;
                for (const auto& q : queries) {
                    int strike = 0;
                    if (a == q.digits[0]) strike++;
                    if (b == q.digits[1]) strike++;
                    if (c == q.digits[2]) strike++;
                    
                    int common = 0;
                    if (a == q.digits[0] || a == q.digits[1] || a == q.digits[2]) common++;
                    if (b == q.digits[0] || b == q.digits[1] || b == q.digits[2]) common++;
                    if (c == q.digits[0] || c == q.digits[1] || c == q.digits[2]) common++;
                    
                    int ball = common - strike;
                    
                    if (strike != q.strike || ball != q.ball) {
                        is_valid = false;
                        break;
                    }
                }
                
                if (is_valid) {
                    valid_count++;
                }
            }
        }
    }

    cout << valid_count << '\n';
    return 0;
}