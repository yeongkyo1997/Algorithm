import sys


def input(): return sys.stdin.readline().rstrip()


def move(N, clouds, a, b):
    ret = []
    for cloud in clouds:
        x, y = cloud
        nx, ny = (x + dx[a] * b) % N, (y + dy[a] * b) % N
        ret.append((nx, ny))
    return ret


def bug(N, A, clouds):
    for cloud in clouds:
        x, y = cloud
        A[x][y] += 1

    for cloud in clouds:
        x, y = cloud
        cnt = 0
        for dx, dy in [(-1, -1), (-1, 1), (1, -1), (1, 1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < N and A[nx][ny] > 0:
                cnt += 1
        A[x][y] += cnt


def make(N, A, pre):
    ret = []
    for r in range(N):
        for c in range(N):
            if A[r][c] >= 2 and (r, c) not in pre:
                ret.append((r, c))
                A[r][c] -= 2
    return ret


dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
moves = [list(map(int, input().split())) for _ in range(M)]

clouds = [(N - 1, 0), (N - 1, 1), (N - 2, 0), (N - 2, 1)]

for a, b in moves:
    clouds = move(N, clouds, a - 1, b)

    bug(N, A, clouds)

    clouds = make(N, A, clouds)

print(sum(sum(row) for row in A))