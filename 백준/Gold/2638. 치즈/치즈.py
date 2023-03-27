import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

# BOJ 2638 - 치즈
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def main():
    N, M = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(N)]
    result = 0
    while True:
        if check(board):
            break
        visited = [[0] * M for _ in range(N)]
        dfs(0, 0, board, visited)
        for i in range(N):
            for j in range(M):
                if board[i][j] == 1:
                    if visited[i][j] >= 2:
                        board[i][j] = 0
        result += 1
    print(result)

def dfs(x, y, board, visited):
    visited[x][y] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(board) and 0 <= ny < len(board[0]):
            if board[nx][ny] == 0 and visited[nx][ny] == 0:
                dfs(nx, ny, board, visited)
            elif board[nx][ny] == 1:
                visited[nx][ny] += 1

def check(board):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 1:
                return False
    return True

if __name__ == '__main__':
    main()