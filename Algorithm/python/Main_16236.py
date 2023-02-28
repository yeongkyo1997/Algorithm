import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    board = [list(map(int, input().split())) for _ in range(n)]
    shark = [0, 0]
    for i in range(n):
        for j in range(n):
            if board[i][j] == 9:
                shark = [i, j]
                board[i][j] = 0
                break
    size = 2
    eat = 0
    time = 0
    while True:
        queue = [[shark[0], shark[1], 0]]
        visited = [[False] * n for _ in range(n)]
        visited[shark[0]][shark[1]] = True
        flag = False
        while queue:
            x, y, t = queue.pop(0)
            if board[x][y] != 0 and board[x][y] < size:
                flag = True
                if eat == size - 1:
                    size += 1
                    eat = 0
                else:
                    eat += 1
                board[x][y] = 0
                shark = [x, y]
                time += t
                break
            for dx, dy in (-1, 0), (1, 0), (0, -1), (0, 1):
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and board[nx][ny] <= size:
                    visited[nx][ny] = True
                    queue.append([nx, ny, t + 1])
        if not flag:
            break
    print(time)


if __name__ == '__main__':
    main()