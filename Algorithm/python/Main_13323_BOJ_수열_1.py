import heapq
import sys

input = lambda: sys.stdin.readline().rstrip()
n = int(input())
a = list(map(int, input().split()))
pq = []

mn = 0
diff = 0

for i in range(n):
    if not pq or pq[0] <= a[i] - diff:
        mn = mn
    else:
        mn = mn + pq[0] - a[i] + diff
        heapq.heappush(pq, a[i] - diff)
        heapq.heappop(pq)
    heapq.heappush(pq, a[i] - diff)
    diff += 1

print(mn)
