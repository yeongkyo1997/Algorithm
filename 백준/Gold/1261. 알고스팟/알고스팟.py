import heapq
import sys


def input(): return sys.stdin.readline().rstrip()


M, N = map(int, input().split())
board = [list(map(int, input())) for _ in range(N)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

visited = [[False] * M for _ in range(N)]
visited[0][0] = True

heap = [(0, 0, 0)]

while heap:
    depth, x, y = heapq.heappop(heap)

    if x == N - 1 and y == M - 1:
        print(depth)
        break

    for dx, dy in d:
        nx, ny = x + dx, y + dy

        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
            visited[nx][ny] = True
            if board[nx][ny] == 1:
                heapq.heappush(heap, (depth + 1, nx, ny))
            else:
                heapq.heappush(heap, (depth, nx, ny))