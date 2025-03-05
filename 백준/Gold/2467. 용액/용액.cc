#include <iostream>
#include <vector>
#include <cstdlib>  // llabs 함수 사용을 위해
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    vector<long long> solutions(N);
    
    // 용액의 특성값 입력 (오름차순으로 주어짐)
    for(int i = 0; i < N; i++){
        cin >> solutions[i];
    }
    
    // 투 포인터 설정
    int left = 0, right = N - 1;
    long long bestSum = 2000000000LL * 2LL;  // 충분히 큰 값으로 초기화
    long long answerLeft = solutions[left], answerRight = solutions[right];
    
    // left와 right가 만날 때까지 반복
    while(left < right){
        long long currentSum = solutions[left] + solutions[right];
        
        // 지금까지 찾은 합의 절대값보다 더 작은 경우 갱신
        if(llabs(currentSum) < bestSum){
            bestSum = llabs(currentSum);
            answerLeft = solutions[left];
            answerRight = solutions[right];
        }
        
        // 합이 0이면 바로 종료 (더 좋은 해는 없음)
        if(currentSum == 0){
            break;
        }
        
        // 합이 음수이면 left 포인터를 오른쪽으로 이동하여 합을 증가시킴
        if(currentSum < 0){
            left++;
        }
        // 합이 양수이면 right 포인터를 왼쪽으로 이동하여 합을 감소시킴
        else {
            right--;
        }
    }
    
    // 출력은 오름차순이어야 하므로, 이미 solutions 배열은 오름차순 정렬되어 있음.
    cout << answerLeft << " " << answerRight << "\n";
    return 0;
}