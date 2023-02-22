from sys import stdin
input = stdin.readline

n, m = map(int, input().split())
a = [[6]*(m+2)]
b = [[0]*(m+2) for _ in range(n+2)]
v = []
ans = 1e9
dx, dy = (-1, 0, 1, 0), (0, 1, 0, -1)
U, R, D, L = 1, 2, 4, 8
direct = [[0],
         [U, R, D, L],
         [U|D, R|L],
         [U|R, R|D, D|L, L|U],
         [L|U|R, U|R|D, R|D|L, D|L|U],
         [U|R|D|L]]

def init():
    for _ in range(n):
        a.append([6]+list(map(int, input().split()))+[6])
    a.append(list([6]*(m+2)))
    for i in range(n+2):
        for j in range(m+2):
            if a[i][j] == 6:
                b[i][j] = 1
            elif a[i][j]:
                v.append((i, j, a[i][j]))

def observe(x, y, i, d):
    for k in range(4):
        if i & (1<<k):
            nx, ny = x, y
            while a[nx][ny] != 6:
                b[nx][ny] += d
                nx, ny = nx+dx[k], ny+dy[k]

def solve(index):
    global ans
    if index == len(v):
        area = 0
        for i in range(1, n+1):
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
print(ans)
            