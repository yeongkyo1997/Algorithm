import collections
import math
import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
M = int(input())
parent = [i for i in range(N + 1)]
dist = collections.defaultdict(int)
graph = collections.defaultdict(list)


def main():
    for i in range(M):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))
        graph[b].append((a, c))
    print(kruskal())


def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    if dist[a] < dist[b]:
        a, b = b, a
    parent[b] = a
    if dist[a] == dist[b]:
        dist[a] += 1
    return True


def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]


def kruskal():
    edges = []
    for i in graph:
        for j, c in graph[i]:
            edges.append((c, i, j))
    edges.sort()
    result = 0
    for c, a, b in edges:
        if union(a, b):
            result += c
    return result


if __name__ == '__main__':
    main()
