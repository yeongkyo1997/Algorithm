import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    N, M, R = map(int, input().split())
    items = [0] + list(map(int, input().split()))
    graph = [[float('inf')] * (N + 1) for _ in range(N + 1)]
    for _ in range(R):
        a, b, l = map(int, input().split())
        graph[a][b] = l
        graph[b][a] = l
    for i in range(1, N + 1):
        graph[i][i] = 0
    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]
    result = 0
    for i in range(1, N + 1):
        cnt = 0
        for j in range(1, N + 1):
            if graph[i][j] <= M:
                cnt += items[j]
        result = max(result, cnt)
    print(result)

if __name__ == '__main__':
    main()