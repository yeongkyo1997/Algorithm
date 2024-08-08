import heapq

N, K = map(int, input().split())

heap = []

heapq.heappush(heap, (0, N))
visited = set()

while heap:
    depth, cur = heapq.heappop(heap)
    visited.add(N)
    if cur == K:
        print(depth)
        break

    if 0 <= cur * 2 <= 100_000 and cur * 2 not in visited:
        heapq.heappush(heap, (depth, cur * 2))
        visited.add(cur * 2)
    if 0 <= cur - 1 <= 100_000 and cur - 1 not in visited:
        heapq.heappush(heap, (depth + 1, cur - 1))
        visited.add(cur - 1)
    if 0 <= cur + 1 <= 100_000 and cur + 1 not in visited:
        heapq.heappush(heap, (depth + 1, cur + 1))
        visited.add(cur + 1)