import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    m = int(input())
    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    visited = [False] * (n + 1)
    visited[1] = True
    stack = [1]
    while stack:
        node = stack.pop()
        for i in graph[node]:
            if not visited[i]:
                visited[i] = True
                stack.append(i)
    print(visited.count(True) - 1)


if __name__ == '__main__':
    main()
