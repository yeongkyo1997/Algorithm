#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Student {
    int d;
    vector<int> algorithms;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N, K, D;
    cin >> N >> K >> D;
    
    vector<Student> students(N);
    for (int i = 0; i < N; ++i) {
        int M, d;
        cin >> M >> d;
        students[i].d = d;
        students[i].algorithms.resize(M);
        for (int j = 0; j < M; ++j) {
            cin >> students[i].algorithms[j];
        }
    }
    
    sort(students.begin(), students.end(), [](const Student& a, const Student& b) {
        return a.d < b.d;
    });
    
    vector<int> cnt(K + 1, 0);
    int s = 0;
    int max_E = 0;
    
    for (int e = 0; e < N; ++e) {
        for (int algo : students[e].algorithms) {
            cnt[algo]++;
        }
        
        while (students[e].d - students[s].d > D) {
            for (int algo : students[s].algorithms) {
                cnt[algo]--;
            }
            s++;
        }
        
        int current_size = e - s + 1;
        int or_count = 0;
        int and_count = 0;
        
        for (int b = 1; b <= K; ++b) {
            if (cnt[b] > 0) or_count++;
            if (cnt[b] == current_size) and_count++;
        }
        
        max_E = max(max_E, (or_count - and_count) * current_size);
    }
    
    cout << max_E << '\n';
    
    return 0;
}