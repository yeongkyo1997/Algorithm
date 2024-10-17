import heapq
import math
import sys

input = lambda: sys.stdin.readline().rstrip()


class Node:
    def __init__(self, min_val=math.inf, idx=100000):
        self.min_val = min_val
        self.idx = idx

    def __lt__(self, other):
        return (self.min_val, self.idx) < (other.min_val, other.idx)

    def __eq__(self, other):
        return self.idx == other

    def __iter__(self):
        yield from (self.min_val, self.idx)


if __name__ == '__main__':
    N = int(input())
    arr = [0] + list(map(int, input().split()))

    heap = [Node(arr[i], i) for i in range(1, N + 1)]
    heapq.heapify(heap)

    M = int(input())

    for _ in range(M):
        q, *data = map(int, input().split())

        if q == 1:
            i, v = data
            arr[i] = v
            heapq.heappush(heap, Node(v, i))
        else:
            while True:
                val, idx = heap[0]

                if val == arr[idx]:
                    print(idx)
                    break
                heapq.heappop(heap)