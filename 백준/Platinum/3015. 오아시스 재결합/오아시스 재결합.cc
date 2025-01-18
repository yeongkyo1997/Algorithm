#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    // (키, 해당 키의 연속 개수) 쌍을 저장할 스택
    stack<pair<long long, long long>> st;

    long long answer = 0;

    while (N--) {
        long long height;
        cin >> height;

        // 1. 스택 top의 키가 새 키보다 작으면 pop
        long long count = 1;  // 새로 들어오는 height의 연속 개수(일단 자기 자신 1명)
        while (!st.empty() && st.top().first < height) {
            answer += st.top().second; // pop된 애들은 현재 사람과 모두 볼 수 있음
            st.pop();
        }

        // 2. 만약 스택 top이 새 키와 같다면 (중복 키)
        if (!st.empty() && st.top().first == height) {
            long long sameCount = st.top().second;
            st.pop();
            answer += sameCount; // 같은 키들끼리는 서로 다 볼 수 있음

            // 스택이 아직 비어있지 않다면, 현재 사람은 스택의 top과도 볼 수 있음
            if (!st.empty()) answer++;

            // 새로 push할 때, 연속 개수를 1 더해서 push
            count = sameCount + 1;
        }
        else {
            // 3. 스택이 비어있지 않고, top의 키가 더 크다면 서로 볼 수 있음
            if (!st.empty()) answer++;
        }

        // (height, count)를 push
        st.push({height, count});
    }

    cout << answer << "\n";
    return 0;
}