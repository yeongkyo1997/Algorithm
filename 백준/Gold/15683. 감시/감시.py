from sys import stdin

input = stdin.readline

N, M = map(int, input().split())
arr = [[6] * (M + 2)]
b = [[0] * (M + 2) for _ in range(N + 2)]
v = []
result = 1e9
dx, dy = (-1, 0, 1, 0), (0, 1, 0, -1)
U, R, D, L = 1, 2, 4, 8
direct = [[0],
          [U, R, D, L],
          [U | D, R | L],
          [U | R, R | D, D | L, L | U],
          [L | U | R, U | R | D, R | D | L, D | L | U],
          [U | R | D | L]]


def init():
    for _ in range(N):
        arr.append([6] + list(map(int, input().split())) + [6])
    arr.append(list([6] * (M + 2)))
    for i in range(N + 2):
        for j in range(M + 2):
            if arr[i][j] == 6:
                b[i][j] = 1
            elif arr[i][j]:
                v.append((i, j, arr[i][j]))

def observe(x, y, i, d):
    for k in range(4):
        if i & (1<<k):
            nx, ny = x, y
            while arr[nx][ny] != 6:
                b[nx][ny] += d
                nx, ny = nx + dx[k], ny + dy[k]

def solve(index):
    global result
    if index == len(v):
        area = 0
        for i in range(1, N + 1):
            area += b[i].count(0)
        ans = min(ans, area)
        return
    x, y, ids = v[index]
    for i in direct[ids]:
        observe(x, y, i, 1)
        solve(index+1)
        observe(x, y, i, -1)

init()
solve(0)
print(result)
