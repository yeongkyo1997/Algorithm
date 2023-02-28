import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()

# BOJ 7662 이중 우선순위 큐
def main():
    t = int(input())
    for _ in range(t):
        k = int(input())
        min_heap = []
        max_heap = []
        visited = [0] * 1000001
        for _ in range(k):
            cmd, num = input().split()
            num = int(num)
            if cmd == 'I':
                heapq.heappush(min_heap, (num, _))
                heapq.heappush(max_heap, (-num, _))
                visited[_] = 1
            else:
                if num == 1:
                    while max_heap and not visited[max_heap[0][1]]:
                        heapq.heappop(max_heap)
                    if max_heap:
                        visited[max_heap[0][1]] = 0
                        heapq.heappop(max_heap)
                else:
                    while min_heap and not visited[min_heap[0][1]]:
                        heapq.heappop(min_heap)
                    if min_heap:
                        visited[min_heap[0][1]] = 0
                        heapq.heappop(min_heap)
        while max_heap and not visited[max_heap[0][1]]:
            heapq.heappop(max_heap)
        while min_heap and not visited[min_heap[0][1]]:
            heapq.heappop(min_heap)
        if max_heap and min_heap:
            print(-max_heap[0][0], min_heap[0][0])
        else:
            print('EMPTY')


if __name__ == '__main__':
    main()
