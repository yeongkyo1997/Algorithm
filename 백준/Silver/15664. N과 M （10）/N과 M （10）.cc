#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int arr[8];
vector<int> sequence;

// 백트래킹 함수
void backtrack(int start) {
    if (sequence.size() == M) {
        // 수열 출력
        for(int i = 0; i < M; ++i) {
            if(i > 0) cout << ' ';
            cout << sequence[i];
        }
        cout << '\n';
        return;
    }

    for(int i = start; i < N; ++i) {
        // 중복된 숫자를 건너뛰기
        if(i > start && arr[i] == arr[i-1]) continue;
        sequence.push_back(arr[i]);
        backtrack(i + 1);
        sequence.pop_back();
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> M;
    for(int i = 0; i < N; ++i){
        cin >> arr[i];
    }
    
    sort(arr, arr + N);
    
    backtrack(0);
    
    return 0;
}