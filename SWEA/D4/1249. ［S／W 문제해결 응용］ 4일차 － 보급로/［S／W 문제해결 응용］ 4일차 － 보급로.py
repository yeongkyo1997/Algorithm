import heapq
import math

dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def find_path(x, y):
    heap = [(0, x, y)]
    dist = [[math.inf] * N for _ in range(N)]
    dist[0][0] = 0

    while heap:
        depth, x, y = heapq.heappop(heap)
        if x == N - 1 and y == N - 1:
            return depth

        for dx, dy in dir:
            nx, ny = x + dx, y + dy

            if 0 <= nx < N and 0 <= ny < N:
                if dist[nx][ny] > dist[x][y] + board[nx][ny]:
                    dist[nx][ny] = dist[x][y] + board[nx][ny]
                    heapq.heappush(heap, (dist[nx][ny], nx, ny))


for t in range(1, int(input()) + 1):
    N = int(input())
    board = [list(map(int, input())) for _ in range(N)]
    print(f'#{t} {find_path(0, 0)}')
