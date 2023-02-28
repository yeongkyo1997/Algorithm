import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 1927 최소 힙
def main():
    n = int(input())
    heap = []
    for _ in range(n):
        x = int(input())
        if x == 0:
            if heap:
                print(heapq.heappop(heap))
            else:
                print(0)
        else:
            heapq.heappush(heap, x)


if __name__ == '__main__':
    main()
