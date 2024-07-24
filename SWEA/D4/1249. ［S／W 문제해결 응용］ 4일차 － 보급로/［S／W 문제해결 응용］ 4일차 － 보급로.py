import heapq
import math

T = int(input())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def bfs():
    heap = []
    heapq.heappush(heap, (0, 0, 0))
    visited = set()

    while heap:
        s, x, y = heapq.heappop(heap)
        if x == N - 1 and y == N - 1:
            return s

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if (nx, ny) in visited:
                continue
            visited.add((nx, ny))
            heapq.heappush(heap, (s + board[nx][ny], nx, ny))


for t in range(1, T + 1):
    N = int(input().rstrip())
    board = [list(list(map(int, list(input())))) for _ in range(N)]
    print(f'#{t} {bfs()}')