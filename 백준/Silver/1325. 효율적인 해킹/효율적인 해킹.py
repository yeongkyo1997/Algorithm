import collections
import sys

input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())

arr = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    arr[b].append(a)

result = []
max = -1

for i in range(1, n + 1):
    visited = [0] * (n + 1)
    cnt = 0

    q = collections.deque()
    q.append(i)

    while q:
        node = q.popleft()

        if visited[node] == 0:
            visited[node] = 1
            cnt += 1

            for j in arr[node]:
                q.append(j)

    if max < cnt:
        result = []
        max = cnt
        result.append(i)
    elif max == cnt:
        result.append(i)

for i in result:
    print(i, end=' ')