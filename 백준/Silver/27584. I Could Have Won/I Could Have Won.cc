#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false); // C 스타일 I/O와 분리해서 빠르게 처리
    cin.tie(nullptr);            // cin/cout 묶음 해제

    string S;
    cin >> S;                     // 점수 기록 문자열 입력
    int N = S.size();

    vector<int> answer;           // 조건을 만족하는 k들을 저장

    // k는 1부터 N까지 가능 (N보다 크면 게임이 하나도 완성되지 않음)
    for (int k = 1; k <= N; k++) {
        int a_cnt = 0, b_cnt = 0; // 현재 게임에서의 Alice/Bob 점수
        int a_wins = 0, b_wins = 0; // 완료된 게임 수

        // 전체 포인트 시퀀스를 순회하며 게임별 점수 집계
        for (char c : S) {
            if (c == 'A') {
                a_cnt++;
            } else { // c == 'B'
                b_cnt++;
            }

            // 먼저 k점에 도달한 쪽이 그 게임을 이기고 점수 초기화
            if (a_cnt == k) {
                a_wins++;
                a_cnt = b_cnt = 0;
            } else if (b_cnt == k) {
                b_wins++;
                a_cnt = b_cnt = 0;
            }
        }

        // Alice가 이긴 게임 수가 더 많으면 k를 정답 목록에 추가
        if (a_wins > b_wins) {
            answer.push_back(k);
        }
    }

    // 출력
    cout << answer.size() << "\n";
    if (!answer.empty()) {
        for (int i = 0; i < (int)answer.size(); i++) {
            if (i) cout << " ";
            cout << answer[i];
        }
        cout << "\n";
    }
    return 0;
}
