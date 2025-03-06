#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int R, C, T;
vector<string> grid;
int maxSweet = 0;

// DFS function: t = current time (number of moves made), (r, c) = current position, cnt = count of sweet potatoes eaten so far.
void dfs(int t, int r, int c, int cnt) {
    if(t == T) {
        maxSweet = max(maxSweet, cnt);
        return;
    }
    
    // Directions: stay, down, up, right, left.
    int dr[5] = {0, 1, -1, 0, 0};
    int dc[5] = {0, 0, 0, 1, -1};
    
    for (int i = 0; i < 5; i++){
        int nr = r + dr[i];
        int nc = c + dc[i];
        
        // Check grid boundaries.
        if(nr < 0 || nr >= R || nc < 0 || nc >= C)
            continue;
        // Check if there's an obstacle.
        if(grid[nr][nc] == '#')
            continue;
        
        int extra = 0;
        // If there is a sweet potato, eat it and mark the cell as empty.
        if(grid[nr][nc] == 'S'){
            extra = 1;
            grid[nr][nc] = '.';
        }
        
        dfs(t + 1, nr, nc, cnt + extra);
        
        // Backtrack: if we ate a sweet potato at (nr,nc), restore it.
        if(extra == 1)
            grid[nr][nc] = 'S';
    }
}
 
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    cin >> R >> C >> T;
    grid.resize(R);
    for (int i = 0; i < R; i++){
        cin >> grid[i];
    }
    
    int startR = -1, startC = -1;
    // Find Gahee's starting position, marked with 'G'
    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
            if(grid[i][j] == 'G'){
                startR = i;
                startC = j;
                // Replace 'G' with '.' so that we treat it as an empty space.
                grid[i][j] = '.';
                break;
            }
        }
        if(startR != -1)
            break;
    }
    
    dfs(0, startR, startC, 0);
    
    cout << maxSweet << "\n";
    return 0;
}