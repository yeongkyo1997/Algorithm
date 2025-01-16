#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long N;  // 합이 되어야 하는 값
    int L;        // 연속된 수열의 최소 길이
    cin >> N >> L;

    // 길이가 L부터 100까지 탐색
    for(int length = L; length <= 100; length++){
        // 연속된 수열의 합 공식:
        //   x + (x+1) + (x+2) + ... + (x+(length-1))
        // = length*x + (0+1+2+...+(length-1))
        // = length*x + length*(length-1)/2
        // 이를 N이라 할 때:
        //   length*x + length*(length-1)/2 = N
        //   length*x = N - length*(length-1)/2
        //   x = [N - length*(length-1)/2] / length
        //
        // x는 음이 아닌 정수(0 이상)여야 하고,
        // [N - length*(length-1)/2]이 length로 나누어떨어져야 함.

        long long numerator = N - (long long)length*(length-1)/2;
        // x ≥ 0 이어야 하므로, numerator ≥ 0 검사
        if(numerator < 0) {
            // length가 커질수록 (length*(length-1))/2는 더 커지므로,
            // 더 이상 해가 나올 수 없음. 바로 종료.
            break;
        }

        // 나누어떨어지는지 확인
        if(numerator % length == 0){
            long long x = numerator / length;
            // 음이 아닌 정수인지 확인
            if(x >= 0){
                // 조건을 만족하는 가장 짧은 length를 찾았으므로 출력 후 종료
                for(int i = 0; i < length; i++){
                    cout << x + i;
                    if(i < length - 1) cout << " ";
                }
                cout << "\n";
                return 0;
            }
        }
    }

    // 조건을 만족하는 수열을 찾지 못한 경우 또는 길이가 100을 초과할 경우
    cout << -1 << "\n";
    return 0;
}