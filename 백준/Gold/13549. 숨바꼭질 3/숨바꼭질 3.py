import sys
import heapq


input = lambda: sys.stdin.readline().rstrip()


def main():
    N, K = map(int, input().split())

    heap = [(0, N)]
    visited = set()

    while heap:
        weight, cur = heapq.heappop(heap)
        if cur > 100000 or cur < 0 or cur in visited:
            continue
        visited.add(cur)

        if cur == K:
            print(weight)
            return

        heapq.heappush(heap, (weight + 1, cur - 1))
        heapq.heappush(heap, (weight + 1, cur + 1))
        heapq.heappush(heap, (weight, cur * 2))


main()
