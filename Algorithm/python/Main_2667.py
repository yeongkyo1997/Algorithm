import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    n = int(input())
    graph = [list(map(int, input())) for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    res = []
    for i in range(n):
        for j in range(n):
            if graph[i][j] == 1 and not visited[i][j]:
                cnt += 1
                res.append(dfs(i, j, graph, visited, n))
    print(cnt)
    res.sort()
    for i in res:
        print(i)


def dfs(x, y, graph, visited, n):
    visited[x][y] = True
    cnt = 1
    for i, j in (1, 0), (-1, 0), (0, 1), (0, -1):
        nx, ny = x + i, y + j
        if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1 and not visited[nx][ny]:
            cnt += dfs(nx, ny, graph, visited, n)
    return cnt


if __name__ == '__main__':
    main()
