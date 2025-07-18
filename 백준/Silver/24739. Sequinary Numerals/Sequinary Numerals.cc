#include <iostream>
#include <string>
#include <algorithm>

void print_128(__int128_t n) {
    if (n == 0) {
        std::cout << "0";
        return;
    }
    std::string s;
    s.reserve(40);
    while (n > 0) {
        s += (n % 10) + '0';
        n /= 10;
    }
    std::reverse(s.begin(), s.end());
    std::cout << s;
}

long long gcd(long long a, long long b) {
    while (b) {
        a %= b;
        long long temp = a;
        a = b;
        b = temp;
    }
    return a;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    std::string s;
    std::cin >> s;

    int n = s.length() - 1;

    __int128_t numerator = 0;
    __int128_t p3 = 1;
    for (int i = 0; i < n; ++i) {
        p3 *= 3;
    }
    __int128_t p2 = 1;

    for (int i = 0; i <= n; ++i) {
        numerator += (s[i] - '0') * p3 * p2;
        if (i < n) {
            p3 /= 3;
        }
        p2 *= 2;
    }

    long long denominator = 1LL << n;

    __int128_t integer_part = numerator / denominator;
    long long rem_num = numerator % denominator;

    if (rem_num == 0) {
        print_128(integer_part);
    } else {
        long long common_divisor = gcd(rem_num, denominator);
        long long k = rem_num / common_divisor;
        long long m = denominator / common_divisor;
        print_128(integer_part);
        std::cout << " " << k << "/" << m;
    }
    std::cout << "\n";

    return 0;
}