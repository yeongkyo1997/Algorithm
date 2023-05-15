#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

using namespace std;

vector<int> arr, tree;

void init(int node, int start, int end);
int query(int start, int end, int node, int left, int right);
long getMax(int start, int end, int N);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    string line;
    int N, tmp;

    while (true) {
        getline(cin, line);
        istringstream iss(line);

        iss >> N;
        if (N == 0) {
            break;
        }

        arr.resize(N + 1);
        for (int i = 1; i <= N; i++) {
            iss >> tmp;
            arr[i] = tmp;
        }

        tree.resize(N * 4);
        init(1, 1, N);

        cout << getMax(1, N, N) << "\n";
    }

    return 0;
}

void init(int node, int start, int end) {
    if (start == end) {
        tree[node] = start;
    } else {
        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);

        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }
}

int query(int start, int end, int node, int left, int right) {
    if (right < start || end < left) {
        return -1;
    }

    if (left <= start && end <= right) {
        return tree[node];
    }

    int mid = (start + end) / 2;
    int m1 = query(start, mid, node * 2, left, right);
    int m2 = query(mid + 1, end, node * 2 + 1, left, right);

    if (m1 == -1) {
        return m2;
    } else if (m2 == -1) {
        return m1;
    } else {
        if (arr[m1] <= arr[m2]) {
            return m1;
        } else {
            return m2;
        }
    }
}

long getMax(int start, int end, int N) {
    int m = query(1, N, 1, start, end);

    long area = (end - start + 1) * (long)arr[m];

    if (start <= m - 1) {
        long tmp = getMax(start, m - 1, N);
        area = max(area, tmp);
    }

    if (m + 1 <= end) {
        long tmp = getMax(m + 1, end, N);
        area = max(area, tmp);
    }

    return area;
}