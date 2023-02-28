import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 2150 Strongly Connected Component
def main():
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    reverse_graph = [[] for _ in range(V + 1)]
    for _ in range(E):
        a, b = map(int, input().split())
        graph[a].append(b)
        reverse_graph[b].append(a)

    visited = [False] * (V + 1)
    stack = []
    for i in range(1, V + 1):
        if not visited[i]:
            dfs(i, graph, visited, stack)

    visited = [False] * (V + 1)
    scc = []
    while stack:
        i = stack.pop()
        if not visited[i]:
            scc.append([])
            dfs(i, reverse_graph, visited, scc[-1])

    scc.sort()
    print(len(scc))
    for i in scc:
        print(*i)


def dfs(i, graph, visited, stack):
    visited[i] = True
    for next_node in graph[i]:
        if not visited[next_node]:
            dfs(next_node, graph, visited, stack)
    stack.append(i)


if __name__ == '__main__':
    main()
