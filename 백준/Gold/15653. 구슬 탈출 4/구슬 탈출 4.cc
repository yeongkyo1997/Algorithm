#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <tuple> // tie를 사용하기 위해 필요
#include <utility>

using namespace std;

int n, m;
vector<string> board;
// visited[rx][ry][bx][by] stores whether this state has been reached.
bool visited[10][10][10][10];
// Direction vectors: Up, Down, Left, Right
int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

int main() {
    // Optimize C++ standard streams
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // Read board dimensions
    cin >> n >> m;
    board.resize(n);
    int rx = -1, ry = -1, bx = -1, by = -1; // Initial coordinates

    // Read board and find initial marble positions
    for (int i = 0; i < n; ++i) {
        cin >> board[i];
        for (int j = 0; j < m; ++j) {
            if (board[i][j] == 'R') {
                rx = i; ry = j;
                board[i][j] = '.'; // Treat the starting cell as empty
            } else if (board[i][j] == 'B') {
                bx = i; by = j;
                board[i][j] = '.'; // Treat the starting cell as empty
            }
        }
    }

    // Initialize BFS queue with the starting state: (red_row, red_col, blue_row, blue_col, move_count)
    queue<tuple<int, int, int, int, int>> q;

    // Check if marbles were found (should always be true based on constraints)
    if (rx == -1 || bx == -1) {
         cout << -1 << endl;
         return 0;
    }

    q.push({rx, ry, bx, by, 0});
    visited[rx][ry][bx][by] = true; // Mark the initial state as visited

    // Start BFS
    while (!q.empty()) {
        // Get the current state from the front of the queue using std::tie
        int crx, cry, cbx, cby, count;
        tie(crx, cry, cbx, cby, count) = q.front();
        q.pop();

        // Explore tilting in all four directions
        for (int i = 0; i < 4; ++i) {
            int dx = dr[i];
            int dy = dc[i];

            // Simulate the move for the current direction
            int nrx = crx, nry = cry; // Next red position
            int nbx = cbx, nby = cby; // Next blue position
            int r_dist = 0, b_dist = 0; // Distance traveled
            bool r_hole = false, b_hole = false; // Flags for falling into the hole

            // Simulate red marble's movement until it hits a wall or falls into the hole
            while (board[nrx + dx][nry + dy] != '#') {
                nrx += dx;
                nry += dy;
                r_dist++;
                if (board[nrx][nry] == 'O') {
                    r_hole = true;
                    break; // Red marble stops if it reaches the hole
                }
            }

            // Simulate blue marble's movement until it hits a wall or falls into the hole
            while (board[nbx + dx][nby + dy] != '#') {
                nbx += dx;
                nby += dy;
                b_dist++;
                if (board[nbx][nby] == 'O') {
                    b_hole = true;
                    break; // Blue marble stops if it reaches the hole
                }
            }

            // --- Check outcomes ---

            // If the blue marble fell into the hole, this move is invalid. Skip.
            if (b_hole) {
                continue;
            }

            // If the red marble fell into the hole (and blue did not), we found a solution.
            if (r_hole) {
                cout << count + 1 << endl; // Output the number of moves
                return 0; // Terminate the program
            }

            // --- Handle collision ---
            // If both marbles ended up in the same non-hole cell
            if (nrx == nbx && nry == nby) {
                // The marble that traveled farther must step back one position.
                // This simulates one marble blocking the other.
                if (r_dist > b_dist) { // Red traveled farther
                    nrx -= dx;
                    nry -= dy;
                } else { // Blue traveled farther (or equal distance)
                    nbx -= dx;
                    nby -= dy;
                }
            }

            // --- Add valid next state to queue ---
            // If this resulting state (nrx, nry, nbx, nby) hasn't been visited before
            if (!visited[nrx][nry][nbx][nby]) {
                visited[nrx][nry][nbx][nby] = true; // Mark as visited
                q.push({nrx, nry, nbx, nby, count + 1}); // Add to the queue
            }
        }
    }

    // If the queue becomes empty and no solution was found
    cout << -1 << endl;
    return 0;
}