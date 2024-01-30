import heapq

N = int(input())

heap = []
for _ in range(N):
    numbers = list(map(int, input().split()))

    for i in numbers:
        if len(heap) < N:
            heapq.heappush(heap, i)
        else:
            heapq.heappushpop(heap, i)

print(heap[0])