import sys

sys.setrecursionlimit(100000)
input = lambda: sys.stdin.readline().rstrip()

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(y, x):
    if check[y][x]:
        return False
    check[y][x] = True

    for i in range(0, 4):
        next_x = x + dx[i]
        next_y = y + dy[i]

        if 0 <= next_x < m and 0 <= next_y < n and arr[next_y][next_x]:
            dfs(next_y, next_x)

    return True


for i in range(int(input())):
    m, n, cabbage = map(int, input().split())
    arr = [[0] * m for _ in range(n)]
    check = [[0] * m for _ in range(n)]

    for j in range(0, cabbage):
        x, y = map(int, input().split())
        arr[y][x] = 1

    result = 0

    for j in range(0, n):
        for k in range(0, m):
            if arr[j][k] and not check[j][k]:
                if dfs(j, k):
                    result += 1

    print(result)
