import sys
from collections import defaultdict
import heapq


def input(): return sys.stdin.readline().strip()


t = int(input())

for _ in range(t):
    max_heap, min_heap = [], []
    lib = defaultdict(int)
    k = int(input())

    for _ in range(k):
        command, val = input().split()
        val = int(val)

        if command == 'I':
            heapq.heappush(max_heap, -val)
            heapq.heappush(min_heap, val)
            lib[val] += 1
        elif command == 'D':
            if val == -1:
                while min_heap and lib[min_heap[0]] == 0:
                    heapq.heappop(min_heap)
                if min_heap:
                    lib[heapq.heappop(min_heap)] -= 1
            else:
                while max_heap and lib[-max_heap[0]] == 0:
                    heapq.heappop(max_heap)
                if max_heap:
                    lib[-heapq.heappop(max_heap)] -= 1

    while max_heap and lib[-max_heap[0]] == 0:
        heapq.heappop(max_heap)
    while min_heap and lib[min_heap[0]] == 0:
        heapq.heappop(min_heap)

    if max_heap and min_heap:
        print(-max_heap[0], min_heap[0])
    else:
        print('EMPTY')