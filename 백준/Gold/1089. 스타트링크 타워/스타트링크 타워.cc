#include <bits/stdc++.h>
using namespace std;

// 5×3 비트맵으로 정의된 0~9 숫자 패턴
const vector<vector<string>> DIGIT = {
    { "###",
      "#.#",
      "#.#",
      "#.#",
      "###" }, // 0
    { "..#",
      "..#",
      "..#",
      "..#",
      "..#" }, // 1
    { "###",
      "..#",
      "###",
      "#..",
      "###" }, // 2
    { "###",
      "..#",
      "###",
      "..#",
      "###" }, // 3
    { "#.#",
      "#.#",
      "###",
      "..#",
      "..#" }, // 4
    { "###",
      "#..",
      "###",
      "..#",
      "###" }, // 5
    { "###",
      "#..",
      "###",
      "#.#",
      "###" }, // 6
    { "###",
      "..#",
      "..#",
      "..#",
      "..#" }, // 7
    { "###",
      "#.#",
      "###",
      "#.#",
      "###" }, // 8
    { "###",
      "#.#",
      "###",
      "..#",
      "###" }  // 9
};

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    vector<string> S(5);
    for(int i = 0; i < 5; i++){
        cin >> S[i];
    }

    // 자리별로 가능한 숫자 집합
    vector<vector<int>> possible(N);
    for(int pos = 0; pos < N; pos++){
        // 관측된 5×3 블록 추출
        vector<string> block(5);
        int start = pos * 4;
        for(int r = 0; r < 5; r++){
            block[r] = S[r].substr(start, 3);
        }
        // 0~9 중에 호환되는 숫자 찾기
        for(int d = 0; d <= 9; d++){
            bool ok = true;
            for(int r = 0; r < 5 && ok; r++){
                for(int c = 0; c < 3; c++){
                    // 관측된 위치가 '#'인데 실제 패턴이 '.'이면 불가능
                    if(block[r][c] == '#' && DIGIT[d][r][c] == '.'){
                        ok = false;
                        break;
                    }
                }
            }
            if(ok) possible[pos].push_back(d);
        }
    }

    // 한 자리라도 가능한 숫자가 없다면 -1
    for(int i = 0; i < N; i++){
        if(possible[i].empty()){
            cout << -1 << "\n";
            return 0;
        }
    }

    // 자리별 개수, 합
    vector<long double> cnt(N), sumd(N);
    for(int i = 0; i < N; i++){
        cnt[i] = possible[i].size();
        sumd[i] = 0;
        for(int d : possible[i]) sumd[i] += d;
    }

    // 전체 조합 수 = 곱(cnt[i])
    long double total = 1;
    for(int i = 0; i < N; i++) total *= cnt[i];

    // 자리 가중치: 10^(N-1-i)
    vector<long double> weight(N, 1);
    for(int i = 0; i < N; i++){
        weight[i] = powl(10.0L, N-1-i);
    }

    // 모든 수의 합 계산
    // 위치 i에서의 기여 = weight[i] * sumd[i] * (total / cnt[i])
    long double grand_sum = 0;
    for(int i = 0; i < N; i++){
        grand_sum += weight[i] * sumd[i] * (total / cnt[i]);
    }

    // 평균
    long double average = grand_sum / total;

    // 출력 (1e-5 오차 허용)
    cout << fixed << setprecision(5) << average << "\n";
    return 0;
}