#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

using namespace std;

vector<int> tree;
int N, S, A, B, C;

int pickup(int left, int right, int node, int target) {
    if(left == right) return left;

    int mid = (left + right) / 2;
    if(tree[node * 2] >= target) {
        return pickup(left, mid, node * 2, target);
    } else {
        return pickup(mid + 1, right, node * 2 + 1, target - tree[node * 2]);
    }
}

void update(int left, int right, int node, int target, int diff) {
    if(target < left || right < target) return;

    tree[node] += diff;
    if(left != right) {
        int mid = (left + right) / 2;
        update(left, mid, node * 2, target, diff);
        update(mid + 1, right, node * 2 + 1, target, diff);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    // Find S, the smallest power of 2 greater than or equal to 1000000
    S = 1;
    while(S < 1000000) {
        S *= 2;
    }
    tree.resize(S * 2);

    cin >> N;
    stringstream ss;
    for(int i = 0; i < N; i++) {
        cin >> A;
        if(A == 1) {
            cin >> B;
            int index = pickup(1, S, 1, B);
            ss << index << "\n";
            update(1, S, 1, index, -1);
        } else {
            cin >> B >> C;
            update(1, S, 1, B, C);
        }
    }
    
    cout << ss.str();
    return 0;
}