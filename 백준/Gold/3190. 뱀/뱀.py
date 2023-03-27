from collections import deque
dx, dy = (0, 0, 1, -1), (1, -1, 0, 0)
L, D = (3, 2, 0, 1), (2, 3, 1, 0)

def solve():
    x, y, z, d, ans = 0, 0, 0, 0, 0
    arr[0][0] = 2
    q = deque()
    q.append((0, 0))
    while True:
        x, y = x + dx[d], y + dy[d]
        ans += 1
        if x < 0 or x >= N or y < 0 or y >= N or arr[x][y] == 2:
            print(ans)
            return
        if not arr[x][y]:
            nx, ny = q.popleft()
            arr[nx][ny] = 0
        arr[x][y] = 2
        q.append((x, y))
        t, c = b[z]
        if ans == int(t):
            if c == 'L':
                d = L[d]
            else:
                d = D[d]
            z = (z + 1) % M


N = int(input())
arr = [[0] * N for _ in range(N)]
for _ in range(int(input())):
    u, v = map(int, input().split())
    arr[u - 1][v - 1] = 1
M = int(input())
b = [list(map(str, input().split())) for _ in range(M)]
solve()
