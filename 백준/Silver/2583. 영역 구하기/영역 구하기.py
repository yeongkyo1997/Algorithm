import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
print = sys.stdout.write


def bfs(a1, b1):
    global visit, area, m, n

    q = deque([(a1, b1)])
    visit[a1][b1] = True
    cnt = 1

    while q:
        y, x = q.popleft()

        for dx, dy in [(0, 1), (0, -1), (-1, 0), (1, 0)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and not visit[ny][nx]:
                q.append((ny, nx))
                visit[ny][nx] = True
                cnt += 1

    area.append(cnt)


if __name__ == '__main__':
    m, n, k = map(int, input().split())
    visit = [[False] * n for _ in range(m)]
    area = []

    for _ in range(k):
        a, b, c, d = map(int, input().split())
        for r in range(b, d):
            for l in range(a, c):
                visit[r][l] = True

    ans = 0
    for i in range(m):
        for j in range(n):
            if not visit[i][j]:
                bfs(i, j)
                ans += 1

    print(f'{ans}\n')
    area.sort()
    print(' '.join(map(str, area)))