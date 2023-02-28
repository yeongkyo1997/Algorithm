import sys

input = lambda: sys.stdin.readline().rstrip()

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
visited = [[0] * 100 for _ in range(100)]


# BOJ - 10026 적록색약
def main():
    n = int(input())
    arr = [list(input()) for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if arr[i][j] != 0:
                cnt += 1
                dfs(arr, i, j)
    print(cnt, end=' ')

    for i in range(n):
        for j in range(n):
            if arr[i][j] == 'R':
                arr[i][j] = 'G'
    cnt = 0
    for i in range(n):
        for j in range(n):
            if arr[i][j] != 0:
                cnt += 1
                dfs(arr, i, j)
    print(cnt)


def dfs(arr, x, y):
    if arr[x][y] == 0:
        return 0
    arr[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if len(arr) > nx >= 0 != arr[nx][ny] and 0 <= ny < len(arr[0]):
            dfs(arr, nx, ny)


if __name__ == '__main__':
    main()
