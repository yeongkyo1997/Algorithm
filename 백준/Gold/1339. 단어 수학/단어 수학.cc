#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;
    
    // 알파벳별 기여도를 저장할 배열(0으로 초기화)
    // A=0, B=1, ... Z=25
    long long alphaWeight[26] = {0};

    vector<string> words(N);
    for(int i = 0; i < N; i++){
        cin >> words[i];
    }

    // 각 단어에서, 알파벳의 자리수 기여도를 계산
    for(const auto &word : words){
        int len = word.size();
        long long placeValue = 1;
        
        // 끝자리(일의 자리)부터 시작하여 왼쪽으로 이동
        for(int i = len - 1; i >= 0; i--){
            int index = word[i] - 'A';
            alphaWeight[index] += placeValue;
            placeValue *= 10; 
        }
    }

    // alphaWeight가 큰 순으로 정렬하기 위해 벡터로 복사
    vector<long long> weights;
    for(int i = 0; i < 26; i++){
        if(alphaWeight[i] > 0){
            weights.push_back(alphaWeight[i]);
        }
    }

    // 내림차순 정렬
    sort(weights.begin(), weights.end(), greater<long long>());

    // 가장 큰 가중치에 9, 그 다음 8, … 순으로 할당
    long long answer = 0;
    long long digit = 9;
    for(auto w : weights){
        answer += w * digit;
        digit--;
    }

    cout << answer << "\n";
    
    return 0;
}