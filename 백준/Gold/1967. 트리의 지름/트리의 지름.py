import sys
sys.setrecursionlimit(10**6)
class Node:
    def __init__(self, idx, cnt):
        self.idx = idx
        self.cnt = cnt

def dfs(idx, cnt):
    global max, max_idx
    if max < cnt:
        max = cnt
        max_idx = idx
    for a in graph[idx]:
        if not visited[a.idx]:
            visited[a.idx] = True
            dfs(a.idx, cnt + a.cnt)

n = int(sys.stdin.readline())
graph = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    parent, child, weight = map(int, sys.stdin.readline().split())
    graph[parent].append(Node(child, weight))
    graph[child].append(Node(parent, weight))

visited = [False] * (n + 1)
visited[1] = True
max = 0
max_idx = 0
dfs(1, 0)

visited = [False] * (n + 1)
visited[max_idx] = True
max = 0
dfs(max_idx, 0)

print(max)