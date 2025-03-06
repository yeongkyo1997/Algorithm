#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

// 소수 판별 함수
bool isPrime(int num) {
    if (num < 2) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    
    int sqrtNum = sqrt(num);
    for (int i = 3; i <= sqrtNum; i += 2) {
        if (num % i == 0) return false;
    }
    return true;
}

// 최대공약수(GCD) 구하는 함수
long long gcd(long long a, long long b) {
    while (b != 0) {
        long long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// 최소공배수(LCM) 구하는 함수
long long lcm(long long a, long long b) {
    return a / gcd(a, b) * b; // 오버플로우 방지를 위해 나눗셈 먼저 수행
}

int main() {
    int N;
    cin >> N;
    
    vector<int> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    
    vector<int> primes;
    for (int i = 0; i < N; i++) {
        if (isPrime(A[i])) {
            primes.push_back(A[i]);
        }
    }
    
    if (primes.empty()) {
        cout << -1 << endl;
        return 0;
    }
    
    long long result = primes[0];
    for (int i = 1; i < primes.size(); i++) {
        result = lcm(result, primes[i]);
    }
    
    cout << result << endl;
    
    return 0;
}