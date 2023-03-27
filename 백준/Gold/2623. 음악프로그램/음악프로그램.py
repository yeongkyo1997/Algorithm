import sys

sys.setrecursionlimit(1000000)
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)
for _ in range(M):
    temp = list(map(int, input().split()))
    for i in range(1, temp[0]):
        arr[temp[i]].append(temp[i + 1])
        indegree[temp[i + 1]] += 1

queue = []
for i in range(1, N + 1):
    if indegree[i] == 0:
        queue.append(i)

result = []
while queue:
    now = queue.pop(0)
    result.append(now)
    for i in arr[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append(i)

if len(result) == N:
    for i in result:
        print(i)
else:
    print(0)