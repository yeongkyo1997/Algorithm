import sys
from collections import deque, defaultdict


def input(): return sys.stdin.readline().rstrip()


N, M = map(int, input().split())
graph = defaultdict(list)
in_degree = defaultdict(int)
result = []

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    in_degree[b] += 1

q = deque()
for i in range(1, N + 1):
    if in_degree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    result.append(cur)

    for i in graph[cur]:
        in_degree[i] -= 1
        if in_degree[i] == 0:
            q.append(i)

print(*result)