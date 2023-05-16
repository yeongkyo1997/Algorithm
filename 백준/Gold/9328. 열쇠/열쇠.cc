#include <bits/stdc++.h>

using namespace std;

const int MAX = 105;
const char WALL = '*';
const char DOC = '$';
const char DOORSTART = 'A';
const char DOOREND = 'Z'; 
const char KEYSTART = 'a';
const char KEYEND = 'z';

char room[MAX][MAX];
int h, w, result;
int delta[4][2] = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };
bool keyList[26];
vector<pair<int, int>> DoorList[26];

struct Node {
    int x, y;
    Node(int _x, int _y) : x(_x), y(_y) {}
};

bool checkStart(char cur, int x, int y) {
    if (cur == WALL)
        return false;
    else if (cur == DOC) {
        result++;
    }
    else if (KEYSTART <= cur && cur <= KEYEND) {
        keyList[cur - KEYSTART] = true;
    }
    else if (DOORSTART <= cur && cur <= DOOREND) {
        if(!keyList[cur-DOORSTART]) {
            DoorList[cur - DOORSTART].push_back({x, y});
            return false;
        }
    }
    return true;
}

queue<Node> getStart() {
    queue<Node> q;
    for (int j = 0; j < w; j++) {  // 위 아래
        if (checkStart(room[0][j], 0, j)) {
            q.push(Node(0, j));
            room[0][j] = '*';
        }
        if (checkStart(room[h - 1][j], h - 1, j)) {
            q.push(Node(h - 1, j));
            room[h - 1][j] = '*';
        }
    }
    for (int i = 0; i < h; i++) {  // 좌 우
        if (checkStart(room[i][0], i, 0)) {
            q.push(Node(i, 0));
            room[i][0] = '*';
        }
        if (checkStart(room[i][w - 1], i, w - 1)) {
            q.push(Node(i, w - 1));
            room[i][w - 1] = '*';
        }
    }
    return q;
}

int checkVisit(int dx, int dy) {
    if (dx < 0 || dx >= h || dy < 0 || dy >= w) return -1;
    if (room[dx][dy] == WALL) return -1;

    if (DOORSTART <= room[dx][dy] && room[dx][dy] <= DOOREND) {
        int doorNum = room[dx][dy] - DOORSTART;
        if (!keyList[doorNum]) {
            DoorList[doorNum].push_back({dx, dy});
            return -1;
        }
    } else if (KEYSTART <= room[dx][dy] && room[dx][dy] <= KEYEND) {
        int keyNum = room[dx][dy] - KEYSTART;
        keyList[keyNum] = true;
        if(!DoorList[keyNum].empty()) return 2;
    } else if (room[dx][dy] == DOC) {
        result++;
    }

    return 0;
}

void stealDoc() {
    queue<Node> q = getStart();

    for (int i = 0; i < 26; i++) {
        if (keyList[i]) {
            for (auto door : DoorList[i]) {
                room[door.first][door.second] = '*';
                q.push(Node(door.first, door.second));
            }
            DoorList[i].clear();
        }
    }

    while (!q.empty()) {
        Node cur = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {
            int dx = cur.x + delta[d][0];
            int dy = cur.y + delta[d][1];

            int cv = checkVisit(dx, dy);
            if (cv == 2) {
                int keyNum = room[dx][dy] - KEYSTART;
                for (auto door : DoorList[keyNum]) {
                    if (room[door.first][door.second] != WALL) {
                        room[door.first][door.second] = WALL;
                        q.push(Node(door.first, door.second));
                    }
                }
                DoorList[keyNum].clear();
                room[dx][dy] = WALL;
                q.push(Node(dx, dy));
            } else if (cv == 0) {
                room[dx][dy] = WALL;
                q.push(Node(dx, dy));
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int T;
    cin >> T;
    for (int tc = 1; tc <= T; tc++) {
        cin >> h >> w;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> room[i][j];
            }
        }

        string keys;
        cin >> keys;

        fill(keyList, keyList + 26, false);
        for (auto& door : DoorList) {
            door.clear();
        }
        for (char key : keys) {
            if (key != '0') {
                keyList[key - KEYSTART] = true;
            }
        }

        result = 0;
        stealDoc();
        cout << result << "\n";
    }

    return 0;
}