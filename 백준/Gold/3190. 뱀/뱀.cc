#include <bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    // Initialize the board with no apples
    vector<vector<int>> board(N+1, vector<int>(N+1, 0));

    int K;
    cin >> K;
    for(int i=0; i<K; ++i){
        int r, c;
        cin >> r >> c;
        board[r][c] = 1; // 1 represents an apple
    }

    int L;
    cin >> L;
    // Store direction changes in a queue
    queue<pair<int, char>> direction_changes;
    for(int i=0; i<L; ++i){
        int X;
        char C;
        cin >> X >> C;
        direction_changes.emplace(X, C);
    }

    // Directions: 0=Right, 1=Down, 2=Left, 3=Up
    int dir = 0;
    // Delta for rows and columns based on direction
    int dr[4] = {0, 1, 0, -1};
    int dc[4] = {1, 0, -1, 0};

    // Initialize the snake's position
    deque<pair<int, int>> snake;
    snake.emplace_back(1, 1); // Starting at (1,1)

    // To quickly check if a cell is occupied by the snake
    vector<vector<bool>> occupied(N+1, vector<bool>(N+1, false));
    occupied[1][1] = true;

    int time = 0;
    while(1){
        time +=1;
        // Get current head position
        int head_r = snake.front().first;
        int head_c = snake.front().second;

        // Calculate next position
        int new_r = head_r + dr[dir];
        int new_c = head_c + dc[dir];

        // Check collision with walls
        if(new_r <1 || new_r > N || new_c <1 || new_c > N){
            break;
        }

        // Check collision with itself
        if(occupied[new_r][new_c]){
            break;
        }

        // Move the head
        snake.emplace_front(new_r, new_c);
        occupied[new_r][new_c] = true;

        // Check if there's an apple
        if(board[new_r][new_c] ==1){
            // Eat the apple, don't move the tail
            board[new_r][new_c] =0;
        }
        else{
            // Move the tail
            pair<int, int> tail = snake.back();
            occupied[tail.first][tail.second] = false;
            snake.pop_back();
        }

        // Check if it's time to change direction
        if(!direction_changes.empty() && direction_changes.front().first == time){
            char C = direction_changes.front().second;
            direction_changes.pop();
            if(C == 'L'){
                dir = (dir + 3) %4; // Turn left
            }
            else if(C == 'D'){
                dir = (dir +1) %4; // Turn right
            }
        }
    }

    cout << time;
    return 0;
}