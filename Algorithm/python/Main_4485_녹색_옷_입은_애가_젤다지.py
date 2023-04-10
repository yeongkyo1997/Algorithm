import heapq
import math
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def dijkstra():
    heap = []
    heapq.heappush(heap, (arr[0][0], 0, 0))
    dist[0][0] = arr[0][0]

    while heap:
        cost, x, y = heapq.heappop(heap)

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if cost + arr[nx][ny] < dist[nx][ny]:
                    dist[nx][ny] = cost + arr[nx][ny]
                    heapq.heappush(heap, (dist[nx][ny], nx, ny))


num = 1
while True:
    N = int(input())

    if N == 0:
        break

    arr = [list(map(int, input().split())) for _ in range(N)]
    dist = [[math.inf] * N for _ in range(N)]

    dijkstra()
    print(f"Problem {num}: {dist[N - 1][N - 1]}")
    num += 1
