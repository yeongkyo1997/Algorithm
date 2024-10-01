import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()

if __name__ == '__main__':
    N = int(input())
    heap = [int(input()) for _ in range(N)]
    heapq.heapify(heap)

    result = 0
    while len(heap) > 1:
        a, b = heapq.heappop(heap), heapq.heappop(heap)
        result += a + b
        heapq.heappush(heap, a + b)

    print(result)