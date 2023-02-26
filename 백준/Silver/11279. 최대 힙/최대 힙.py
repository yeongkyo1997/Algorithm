import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    heap = []

    for _ in range(int(input())):
        n = int(input())
        if n == 0:
            if heap:
                print(heapq.heappop(heap)[1])
            else:
                print(0)
        else:
            heapq.heappush(heap, (-n, n))


if __name__ == '__main__':
    main()