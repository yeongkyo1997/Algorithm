import heapq
import sys
from heapq import heapify

input = lambda: sys.stdin.readline().rstrip()


def main():
    N = int(input())
    heap = []

    for _ in range(N):
        x = int(input())

        if x == 0:
            if len(heap) == 0:
                print(0)
            else:
                print(heapq.heappop(heap)[1])
        else:
            heapq.heappush(heap, (abs(x), x))


if __name__ == '__main__':
    main()