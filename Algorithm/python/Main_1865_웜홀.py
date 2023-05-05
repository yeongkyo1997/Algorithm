import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()


def main():
    for _ in range(int(input())):
        n, m, w = map(int, input().split())
        graph = [[] for _ in range(n + 1)]
        for _ in range(m):
            s, e, t = map(int, input().split())
            graph[s].append((e, t))
            graph[e].append((s, t))
        for _ in range(w):
            s, e, t = map(int, input().split())
            graph[s].append((e, -t))
        dist = [float('inf')] * (n + 1)
        dist[1] = 0
        is_cycle = False
        for _ in range(n):
            for i in range(1, n + 1):
                for j, t in graph[i]:
                    if dist[j] > dist[i] + t:
                        dist[j] = dist[i] + t
                        if _ == n - 1:
                            is_cycle = True
        print('YES' if is_cycle else 'NO')


if __name__ == '__main__':
    main()
