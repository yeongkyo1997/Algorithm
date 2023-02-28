import sys

input = lambda: sys.stdin.readline().rstrip()


# BOJ 14938 서강그라운드
def main():
    n, m, r = map(int, input().split())
    items = [0] + list(map(int, input().split()))
    graph = [[sys.maxsize] * (n + 1) for _ in range(n + 1)]
    for _ in range(r):
        a, b, l = map(int, input().split())
        graph[a][b] = l
        graph[b][a] = l

    for i in range(1, n + 1):
        graph[i][i] = 0

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    result = 0
    for i in range(1, n + 1):
        cnt = 0
        for j in range(1, n + 1):
            if graph[i][j] <= m:
                cnt += items[j]
        result = max(result, cnt)
    print(result)


if __name__ == '__main__':
    main()
