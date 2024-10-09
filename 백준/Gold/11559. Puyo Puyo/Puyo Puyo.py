import collections
import sys

input = lambda: sys.stdin.readline().rstrip()


def down():
    for col in range(M):
        for row in range(N - 1, -1, -1):
            while board[row][col] != '.' and row + 1 < N and board[row + 1][col] == '.':
                board[row][col], board[row + 1][col] = board[row + 1][col], board[row][col]
                row += 1


def broken():
    def bfs(x, y):
        color = board[x][y]
        q = collections.deque()
        q.append((x, y))
        visited[x][y] = True
        path = [(x, y)]

        while q:
            x, y = q.popleft()

            for dx, dy in [(-1, 0), (0, 1), (1, 0), (0, -1)]:
                nx, ny = x + dx, y + dy

                if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and board[nx][ny] == color:
                    path.append((nx, ny))
                    visited[nx][ny] = True
                    q.append((nx, ny))

        if len(path) >= 4:
            for px, py in path:
                board[px][py] = '.'
            return True
        return False

    visited = [[False] * M for _ in range(N)]
    ret = False
    for i in range(N):
        for j in range(M):
            if board[i][j] != '.':
                ret |= bfs(i, j)

    return ret


if __name__ == '__main__':
    N = 12
    M = 6
    board = [list(input()) for _ in range(N)]

    result = 0

    while broken():
        down()
        result += 1

    print(result)