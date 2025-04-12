#include <iostream>
#include <string>
#include <vector> // string으로 처리 가능하므로 필수는 아님

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int v;
    std::cin >> v; // 심사위원 수 V 입력

    std::string votes;
    std::cin >> votes; // 투표 결과 문자열 입력

    int countA = 0;
    int countB = 0;

    // 문자열을 순회하며 각 후보의 득표수 계산
    for (char vote : votes) {
        if (vote == 'A') {
            countA++;
        } else { // 문제 조건 상 'A' 아니면 'B'임
            countB++;
        }
    }

    // 득표수 비교하여 결과 출력
    if (countA > countB) {
        std::cout << "A\n";
    } else if (countB > countA) {
        std::cout << "B\n";
    } else {
        std::cout << "Tie\n";
    }

    return 0;
}