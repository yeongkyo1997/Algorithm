#include <iostream>
#include <vector>
#include <algorithm>
#include <set> // set 헤더 파일 포함

using namespace std;

struct Event {
    int x, y1, y2, type;
    bool operator<(const Event& e) const {
        return x < e.x;
    }
};

class SegmentTree {
    vector<int> count, length;
    vector<int> y_coords;

public:
    SegmentTree(const vector<int>& y_sorted) {
        int n = y_sorted.size();
        count.resize(4 * n, 0);
        length.resize(4 * n, 0);
        y_coords = y_sorted;
    }

    void update(int node, int start, int end, int y1, int y2, int type) {
        if (y2 <= y_coords[start] || y1 >= y_coords[end]) {
            return;
        }
        if (y1 <= y_coords[start] && y_coords[end] <= y2) {
            count[node] += type;
        } else {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, y1, y2, type);
            update(node * 2 + 1, mid, end, y1, y2, type);
        }
        if (count[node] > 0) {
            length[node] = y_coords[end] - y_coords[start];
        } else if (start + 1 == end) {
            length[node] = 0;
        } else {
            length[node] = length[node * 2] + length[node * 2 + 1];
        }
    }

    int query() {
        return length[1];
    }
};

long long solution(vector<vector<int>> rectangles) {
    vector<Event> events;
    set<int> y_coords_set; // set 사용

    for (auto& rect : rectangles) {
        events.push_back({rect[0], rect[1], rect[3], 1});
        events.push_back({rect[2], rect[1], rect[3], -1});
        y_coords_set.insert(rect[1]);
        y_coords_set.insert(rect[3]);
    }

    vector<int> y_sorted(y_coords_set.begin(), y_coords_set.end());
    SegmentTree seg_tree(y_sorted);

    sort(events.begin(), events.end());

    long long area = 0;
    int prev_x = events[0].x;

    for (auto& event : events) {
        int x = event.x;
        int type = event.type;
        int y1 = event.y1;
        int y2 = event.y2;

        long long width = x - prev_x;
        long long height = seg_tree.query();
        area += width * height;

        seg_tree.update(1, 0, y_sorted.size() - 1, y1, y2, type);

        prev_x = x;
    }

    return area;
}
