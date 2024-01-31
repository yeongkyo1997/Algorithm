import heapq
import sys


def input(): return sys.stdin.readline().rstrip()


def solution(n, k):
    time = [float('inf')] * 100001
    time[n] = 0

    queue = [(0, n)]

    while queue:
        t, x = heapq.heappop(queue)

        if x == k:
            return t

        if 0 <= x*2 <= 100000 and t < time[x*2]:
            heapq.heappush(queue, (t, x*2))
            time[x*2] = t

        for nx in (x-1, x+1):
            if 0 <= nx <= 100000 and t + 1 < time[nx]:
                heapq.heappush(queue, (t+1, nx))
                time[nx] = t + 1


print(solution(*map(int, input().split())))