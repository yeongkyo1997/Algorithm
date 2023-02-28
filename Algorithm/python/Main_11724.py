import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 11724 연결 요소의 개수
def main():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    visited = [False] * (n + 1)
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    def dfs(v):
        visited[v] = True
        for i in graph[v]:
            if not visited[i]:
                dfs(i)

    cnt = 0
    for i in range(1, n + 1):
        if not visited[i]:
            dfs(i)
            cnt += 1
    print(cnt)


if __name__ == '__main__':
    main()
