import sys

input = lambda: sys.stdin.readline().rstrip()


def main():
    INF = 987654321
    for _ in range(int(input())):
        n, m, k = map(int, input().split())
        adj = [[] for _ in range(n + 1)]
        dist = [[INF] * (m + 1) for _ in range(n + 1)]
        for _ in range(k):
            u, v, c, d = map(int, input().split())
            adj[u].append((v, c, d))

        dist[1][0] = 0
        for i in range(m + 1):
            for j in range(1, n + 1):
                if dist[j][i] == INF:
                    continue
                for v, c, d in adj[j]:
                    if i + c > m:
                        continue
                    dist[v][i + c] = min(dist[v][i + c], dist[j][i] + d)
        ans = min(dist[n])
        print(ans if ans != INF else 'Poor KCM')


main()
