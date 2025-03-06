#include <iostream>
#include <cmath>
using namespace std;

void primeFactorization(int n) {
    // N이 1인 경우 아무것도 출력하지 않음
    if (n == 1) return;
    
    // 2부터 시작하여 n의 제곱근까지 확인
    for (int i = 2; i <= sqrt(n); i++) {
        // i로 나누어 떨어지는 동안 계속 나누기
        while (n % i == 0) {
            cout << i << endl;
            n /= i;
        }
    }
    
    // 마지막 남은 수가 1보다 크면 그 수는 소수
    if (n > 1) {
        cout << n << endl;
    }
}

int main() {
    int n;
    cin >> n;
    
    primeFactorization(n);
    
    return 0;
}