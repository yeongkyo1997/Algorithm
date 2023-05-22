#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> seq(N);
    vector<int> LIS(N);

    for (int i = 0; i < N; i++) {
        cin >> seq[i];
    }

    LIS[0] = seq[0];
    int lengthOfLIS = 1;

    for (int i = 1; i < N; i++) {
        int key = seq[i];

        if (LIS[lengthOfLIS - 1] < key) {
            lengthOfLIS++;
            LIS[lengthOfLIS - 1] = key;
        } else {
            int lo = 0;
            int hi = lengthOfLIS;
            while (lo < hi) {
                int mid = (lo + hi) / 2;

                if (LIS[mid] < key) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            LIS[lo] = key;
        }
    }
    cout << lengthOfLIS << endl;

    return 0;
}