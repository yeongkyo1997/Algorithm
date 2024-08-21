import sys

input = lambda: sys.stdin.readline().rstrip()
sys.setrecursionlimit(10 ** 6)


def dfs(x):
    global ret
    visited[x] = True
    next_node = graph[x]
    if not visited[next_node]:
        dfs(next_node)
    elif not finished[next_node]:
        current = next_node
        while current != x:
            ret += 1
            current = graph[current]
        ret += 1
    finished[x] = True


def solve():
    global visited, finished, ret, graph
    N = int(input())
    graph = [0] + list(map(int, input().split()))
    visited = [False] * (N + 1)
    finished = [False] * (N + 1)
    ret = 0

    for i in range(1, N + 1):
        if not visited[i]:
            dfs(i)

    print(N - ret)


T = int(input())
for _ in range(T):
    solve()