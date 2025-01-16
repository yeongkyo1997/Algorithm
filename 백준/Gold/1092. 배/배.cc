#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;

    vector<int> cranes(n);
    for (int i = 0; i < n; ++i) {
        cin >> cranes[i];
    }

    int m;
    cin >> m;

    vector<int> boxes(m);
    for (int i = 0; i < m; ++i) {
        cin >> boxes[i];
    }

    sort(cranes.begin(), cranes.end(), greater<int>());
    sort(boxes.begin(), boxes.end(), greater<int>());

    if (boxes[0] > cranes[0]) {
        cout << -1 << endl;
        return 0;
    }

    int time = 0;
    while (!boxes.empty()) {
        time++;
        int box_idx = 0;
        for (int crane_idx = 0; crane_idx < n; ++crane_idx) {
            while (box_idx < boxes.size()) {
                if (cranes[crane_idx] >= boxes[box_idx]) {
                    boxes.erase(boxes.begin() + box_idx);
                    break;
                }
                box_idx++;
            }
             if(box_idx >= boxes.size()){
                break;
            }
          
            if(boxes.empty()){
              break;
            }

        }

    }

    cout << time << endl;

    return 0;
}