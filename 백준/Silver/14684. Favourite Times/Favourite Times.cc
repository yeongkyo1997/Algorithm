#include <iostream>
#include <vector>
using namespace std;

// 주어진 시간의 숫자들이 등차수열을 이루는지 확인하는 함수
bool isArithmeticSequence(int hour, int minute) {
    vector<int> digits;
    
    // 시간이 한 자리 수인 경우 (1~9)
    if (hour < 10) {
        digits.push_back(hour);
    } else {
        // 시간이 두 자리 수인 경우 (10, 11, 12)
        digits.push_back(1);
        digits.push_back(hour % 10);
    }
    
    // 분 추가 (항상 두 자리)
    digits.push_back(minute / 10);
    digits.push_back(minute % 10);
    
    // 숫자가 2개 이상인 경우에만 등차수열 검사가 의미가 있음
    if (digits.size() <= 1) return false;
    
    // 공차 계산
    int diff = digits[1] - digits[0];
    
    // 모든 연속된 숫자 쌍의 차이가 공차와 같은지 확인
    for (int i = 1; i < digits.size(); i++) {
        if (digits[i] - digits[i-1] != diff) {
            return false;
        }
    }
    
    return true;
}

int main() {
    long long D;
    cin >> D;
    
    const int CYCLE = 720; // 12시간 = 720분
    
    // 한 사이클(720분) 동안 등차수열 시간의 개수 계산
    int cycleCount = 0;
    
    int hour = 12;
    int minute = 0;
    
    for (int i = 0; i < CYCLE; i++) {
        if (isArithmeticSequence(hour, minute)) {
            cycleCount++;
        }
        
        // 시간 증가
        minute++;
        if (minute == 60) {
            minute = 0;
            hour++;
            if (hour == 13) {
                hour = 1;
            }
        }
    }
    
    // 전체 사이클 수
    long long fullCycles = D / CYCLE;
    // 남은 분
    long long remainingMinutes = D % CYCLE;
    
    // 전체 결과 = (완전한 사이클의 등차수열 개수) + (남은 시간의 등차수열 개수)
    long long result = fullCycles * cycleCount;
    
    // 남은 시간 처리
    hour = 12;
    minute = 0;
    
    for (long long i = 0; i <= remainingMinutes; i++) {
        if (isArithmeticSequence(hour, minute)) {
            result++;
        }
        
        // 시간 증가
        minute++;
        if (minute == 60) {
            minute = 0;
            hour++;
            if (hour == 13) {
                hour = 1;
            }
        }
    }
    
    cout << result << endl;
    
    return 0;
}