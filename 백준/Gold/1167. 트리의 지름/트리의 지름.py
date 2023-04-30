import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


class Node:
    def __init__(self, index, dist):
        self.index = index
        self.dist = dist


v = int(input())
maxDist = 0
maxNode = 0
visited = [False] * (v + 1)
graph = [[] for _ in range(v + 1)]


def dfs(node, dist):
    global maxDist, maxNode

    if visited[node]:
        return

    if maxDist < dist:
        maxDist = dist
        maxNode = node
    visited[node] = True

    for i in range(len(graph[node])):
        nextIndex = graph[node][i].index
        nextDist = graph[node][i].dist
        dfs(nextIndex, nextDist + dist)


for _ in range(v):
    tmp = list(map(int, input().split()))
    fr = tmp[0]
    for i in range(1, len(tmp) - 1, 2):
        to = tmp[i]
        dist = tmp[i + 1]
        graph[fr].append(Node(to, dist))
        graph[to].append(Node(fr, dist))

dfs(1, 0)
visited = [False] * (v + 1)
maxDist = 0

dfs(maxNode, 0)

print(maxDist)