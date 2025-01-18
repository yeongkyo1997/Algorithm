#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, L;
    cin >> N >> L;
    
    // N이 최대 5,000,000이므로, 메모리 관리에 주의
    // vector<int> A(N);
    // 대신, 배열을 사용할 수도 있지만, vector로도 충분합니다.
    vector<int> A(N);
    for(int &x : A){
        cin >> x;
    }
    
    // deque를 사용하여 슬라이딩 윈도우의 최소값을 찾음
    deque<int> dq; // 인덱스를 저장
    
    // 결과를 저장할 벡터
    // vector<int> D;
    // 하지만 N이 5,000,000이므로, 직접 출력하는 것이 메모리 면에서 유리할 수 있음
    
    string output; // 결과를 한 번에 출력하기 위해 문자열에 저장
    
    for(int i = 0; i < N; i++){
        // 현재 요소보다 뒤에 있는 모든 요소를 deque에서 제거
        while(!dq.empty() && A[i] <= A[dq.back()]){
            dq.pop_back();
        }
        
        // 현재 요소의 인덱스를 deque에 추가
        dq.push_back(i);
        
        // 윈도우의 시작 인덱스
        int window_start = i - L + 1;
        
        // 윈도우의 시작이 음수이면 0으로 설정
        if(window_start < 0){
            window_start = 0;
        }
        
        // deque의 앞쪽에 있는 인덱스가 현재 윈도우 범위를 벗어나면 제거
        while(!dq.empty() && dq.front() < window_start){
            dq.pop_front();
        }
        
        // 현재 윈도우의 최소값은 deque의 앞쪽에 있는 인덱스의 값
        // D_i = A[dq.front()]
        // 출력 형식에 맞게 결과를 문자열에 추가
        output += to_string(A[dq.front()]) + " ";
    }
    
    // 마지막에 추가된 공백 제거
    if(!output.empty()){
        output.pop_back();
    }
    
    cout << output;
    
    return 0;
}