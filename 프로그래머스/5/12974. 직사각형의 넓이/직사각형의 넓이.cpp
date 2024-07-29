#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

struct Event {
    int x, y1, y2, type;
    bool operator<(const Event& other) const {
        return x < other.x;
    }
};

class SegmentTree {
public:
    SegmentTree(int n) : n(n), count(4 * n, 0), length(4 * n, 0), y_coords(n) {}

    void update(int l, int r, int val, int node, int node_l, int node_r) {
        if (r <= node_l || node_r <= l) return;
        if (l <= node_l && node_r <= r) {
            count[node] += val;
        } else {
            int mid = (node_l + node_r) / 2;
            update(l, r, val, 2 * node, node_l, mid);
            update(l, r, val, 2 * node + 1, mid, node_r);
        }
        if (count[node] > 0) {
            length[node] = y_coords[node_r] - y_coords[node_l];
        } else {
            if (node_r - node_l > 1) {
                length[node] = length[2 * node] + length[2 * node + 1];
            } else {
                length[node] = 0;
            }
        }
    }

    void setYCoords(const vector<int>& y_coords) {
        this->y_coords = y_coords;
    }

    int getLength() {
        return length[1];
    }

private:
    int n;
    vector<int> count, length;
    vector<int> y_coords;
};

long long solution(vector<vector<int>> rectangles) {
    vector<Event> events;
    vector<int> y_coords;
    for (const auto& rect : rectangles) {
        events.push_back({rect[0], rect[1], rect[3], 1});  // 시작 이벤트
        events.push_back({rect[2], rect[1], rect[3], -1}); // 끝 이벤트
        y_coords.push_back(rect[1]);
        y_coords.push_back(rect[3]);
    }

    sort(events.begin(), events.end());
    sort(y_coords.begin(), y_coords.end());
    y_coords.erase(unique(y_coords.begin(), y_coords.end()), y_coords.end());

    map<int, int> y_compress;
    for (int i = 0; i < y_coords.size(); ++i) {
        y_compress[y_coords[i]] = i;
    }

    SegmentTree seg_tree(y_coords.size());
    seg_tree.setYCoords(y_coords);
    long long prev_x = 0;
    long long total_area = 0;

    for (const auto& event : events) {
        int x = event.x;
        int y1 = y_compress[event.y1];
        int y2 = y_compress[event.y2];
        int type = event.type;

        long long width = x - prev_x;
        long long height = seg_tree.getLength();
        total_area += width * height;
        prev_x = x;

        seg_tree.update(y1, y2, type, 1, 0, y_coords.size() - 1);
    }

    return total_area;
}