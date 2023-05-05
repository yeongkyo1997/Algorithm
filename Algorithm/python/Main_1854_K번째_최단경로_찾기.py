import heapq
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def dijkstra():
    pq = []
    heapq.heappush(pq, (0, 1))
    kth_queue[1].append(0)

    while pq:
        cur_d, cur_u = heapq.heappop(pq)
        cur_d = -cur_d

        for next_u, next_d in MAP[cur_u]:
            next_d += cur_d

            if len(kth_queue[next_u]) < K:
                heapq.heappush(pq, (-next_d, next_u))
                kth_queue[next_u].append(next_d)
            elif kth_queue[next_u][-1] > next_d:
                heapq.heappush(pq, (-next_d, next_u))
                kth_queue[next_u].pop()
                kth_queue[next_u].append(next_d)


N, M, K = map(int, input().split())
MAP = [[] for _ in range(N + 1)]
kth_queue = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v, d = map(int, input().split())
    MAP[u].append((v, d))

dijkstra()

for i in range(1, N + 1):
    if len(kth_queue[i]) != K:
        print(-1)
    else:
        print(kth_queue[i][-1])
