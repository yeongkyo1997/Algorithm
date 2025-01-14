#include <vector>
#include <string>
#include <algorithm> // std::max, std::min
#include <climits>   // LLONG_MIN, LLONG_MAX
using namespace std;

long long toLongLong(const string &s) {
    // 문자열 s를 long long으로 변환
    // (숫자가 1~1000이므로 int로 해도 되지만 일관성 있게 long long 사용)
    return stoll(s);
}

int solution(vector<string> arr)
{
    // 1. 숫자/연산자 분리
    vector<long long> nums; 
    vector<char> ops;    
    for(int i = 0; i < (int)arr.size(); i++){
        if(i % 2 == 0) {
            // 숫자 위치
            nums.push_back(toLongLong(arr[i]));
        } else {
            // 연산자 위치
            ops.push_back(arr[i][0]); // '+' or '-'
        }
    }

    int n = (int)nums.size(); // 숫자 개수

    // 2. dpMin[i][j], dpMax[i][j] 정의 (i~j 구간의 최소/최대값)
    //   자료형은 오버플로우 방지를 위해 long long 사용
    static long long dpMin[201][201], dpMax[201][201];
    // (n 최댓값 101이므로 크기는 201로 잡아도 충분)
    
    // 초기화
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            dpMin[i][j] = 0;
            dpMax[i][j] = 0;
        }
    }

    // 길이 1(단일 숫자) 구간 초기화
    for(int i = 0; i < n; i++){
        dpMin[i][i] = nums[i];
        dpMax[i][i] = nums[i];
    }

    // 3. 구간 길이를 2부터 n까지 늘려가며 DP 테이블 채운다
    //   length = 구간 안에 숫자가 몇 개인지
    for(int length = 2; length <= n; length++){
        for(int i = 0; i + length - 1 < n; i++){
            int j = i + length - 1; // 구간 [i, j]

            // dpMin[i][j], dpMax[i][j]를 갱신하기 위해
            // 매우 작은/큰 값으로 초기화
            long long minVal = LLONG_MAX;
            long long maxVal = LLONG_MIN;

            // 구간 [i, j] 내에서 가능한 분할점 k를 순회
            // k는 연산자의 인덱스로 보면 [i, j-1) 사이
            // 숫자로 보면 i <= k < j
            // ops[k]는 nums[k], nums[k+1] 사이의 연산자
            for(int k = i; k < j; k++){
                // 현재 연산자
                char op = ops[k]; 
                
                // dpMin[i][k], dpMax[i][k] 와 dpMin[k+1][j], dpMax[k+1][j] 조합
                long long a = dpMax[i][k];
                long long b = dpMin[i][k];
                long long c = dpMax[k+1][j];
                long long d = dpMin[k+1][j];

                // 가능한 4가지 조합을 모두 살펴서 min/max 갱신
                // op == '+'
                if(op == '+'){
                    // 최대값 후보
                    long long cand1 = a + c; 
                    long long cand2 = a + d;
                    long long cand3 = b + c;
                    long long cand4 = b + d;
                    maxVal = max({maxVal, cand1, cand2, cand3, cand4});
                    // 최소값 후보
                    minVal = min({minVal, cand1, cand2, cand3, cand4});
                }
                // op == '-'
                else {
                    // 최대값 후보
                    // ex) dpMax[i][k] - dpMin[k+1][j]
                    long long cand1 = a - c; 
                    long long cand2 = a - d;
                    long long cand3 = b - c;
                    long long cand4 = b - d;
                    maxVal = max({maxVal, cand1, cand2, cand3, cand4});

                    // 최소값 후보
                    minVal = min({minVal, cand1, cand2, cand3, cand4});
                }
            }

            dpMin[i][j] = minVal;
            dpMax[i][j] = maxVal;
        }
    }

    // 4. 최종 결과
    // 전체 수식을 한 덩어리로 봤을 때, [0, n-1] 구간의 최대값
    long long answer = dpMax[0][n-1];

    // 문제에서 결과를 int로 반환한다고 했으므로 형 변환
    return (int)answer;
}