import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()


class Ele:
    def __init__(self, n):
        self.n = n

    def __lt__(self, other):
        return other.n < self.n


heap = []
for _ in range(int(input())):
    x = int(input())
    if x == 0:
        if heap:
            print(heapq.heappop(heap).n)
        else:
            print(0)
    else:
        heapq.heappush(heap, Ele(x))