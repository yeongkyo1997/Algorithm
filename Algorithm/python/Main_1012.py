import sys

sys.setrecursionlimit(10 ** 5)
input = lambda: sys.stdin.readline().rstrip()

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def main():
    t = int(input())
    for _ in range(t):
        m, n, k = map(int, input().split())
        arr = [[0] * m for _ in range(n)]
        for _ in range(k):
            x, y = map(int, input().split())
            arr[y][x] = 1
        cnt = 0
        for i in range(n):
            for j in range(m):
                if arr[i][j] == 1:
                    cnt += 1
                    dfs(arr, i, j)
        print(cnt)


def dfs(arr, x, y):
    arr[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < len(arr) and 0 <= ny < len(arr[0]) and arr[nx][ny] == 1:
            dfs(arr, nx, ny)


if __name__ == '__main__':
    main()