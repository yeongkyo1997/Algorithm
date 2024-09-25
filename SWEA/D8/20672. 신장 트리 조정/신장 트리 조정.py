import math
from collections import deque

MOD = 1000000007


class Dinic:
    class E:
        def __init__(self, t, c, r):
            self.t = t
            self.c = c
            self.r = r

    def __init__(self, n):
        self.n = n
        self.g = [[] for _ in range(n)]
        self.lvl = [0] * n
        self.it = [0] * n

    def clear(self):
        self.g = [[] for _ in range(self.n)]

    def add(self, f, t, c):
        self.g[f].append(self.E(t, c, len(self.g[t])))
        self.g[t].append(self.E(f, 0, len(self.g[f]) - 1))

    def bfs(self, s, t):
        self.lvl = [-1] * self.n
        q = deque([s])
        self.lvl[s] = 0
        while q:
            v = q.popleft()
            for e in self.g[v]:
                if e.c > 0 and self.lvl[e.t] < 0:
                    self.lvl[e.t] = self.lvl[v] + 1
                    q.append(e.t)
        return self.lvl[t] != -1

    def dfs(self, v, t, f):
        if v == t:
            return f
        for i in range(self.it[v], len(self.g[v])):
            e = self.g[v][i]
            if e.c > 0 and self.lvl[v] < self.lvl[e.t]:
                d = self.dfs(e.t, t, min(f, e.c))
                if d > 0:
                    e.c -= d
                    self.g[e.t][e.r].c += d
                    return d
            self.it[v] += 1
        return 0

    def flow(self, s, t):
        fl = 0
        while self.bfs(s, t):
            self.it = [0] * self.n
            f = self.dfs(s, t, math.inf)
            while f > 0:
                fl += f
                f = self.dfs(s, t, math.inf)
        return fl

    def cut(self, s, t):
        self.flow(s, t)
        vis = [False] * self.n
        q = deque([s])
        vis[s] = True
        while q:
            u = q.popleft()
            for e in self.g[u]:
                if e.c > 0 and not vis[e.t]:
                    vis[e.t] = True
                    q.append(e.t)
        return vis


def solve():
    N, M = map(int, input().split())
    edges = []
    adj = [[[] for _ in range(N)] for _ in range(N)]
    for e in range(M):
        a, b, w = map(int, input().split())
        a -= 1
        b -= 1
        edges.append((a, b, w))
        adj[a][b].append(e)
    con = [[False] * M for _ in range(M)]
    for k in range(2):
        tree_edges = list(map(int, input().split()))
        tree = [[] for _ in range(N)]
        for idx in range(N - 1):
            e = tree_edges[idx] - 1
            a, b, _ = edges[e]
            tree[a].append((b, e))
            tree[b].append((a, e))
        for st in range(N):
            par = [-1] * N
            pei = [-1] * N
            q = deque([st])
            while q:
                u = q.popleft()
                for v, e in tree[u]:
                    if par[v] == -1 and v != st:
                        par[v] = u
                        pei[v] = e
                        q.append(v)
            for en in range(N):
                path_edges = []
                node = en
                while node != st and pei[node] != -1:
                    path_edges.append(pei[node])
                    node = par[node]
                if len(path_edges) <= 1:
                    continue
                for gei in adj[st][en]:
                    for tei in path_edges:
                        if k == 0:
                            con[gei][tei] = True
                        else:
                            con[tei][gei] = True
    result = 0
    q = deque([(1, int(1e9), list(range(M)))])
    while q:
        rec = q.popleft()
        l, h, alive = rec[0], rec[1], rec[2]
        if l == h:
            for e in alive:
                result += abs(edges[e][2] - l)
            continue
        mid = (l + h) // 2
        S = len(alive)
        T = S + 1
        dinic = Dinic(S + 2)
        for idx, e in enumerate(alive):
            w = edges[e][2]
            cost = abs(mid - w) - abs(mid + 1 - w)
            cost = -cost
            if cost >= 0:
                dinic.add(S, idx, cost)
            else:
                dinic.add(idx, T, -cost)
        for idx1, eidx1 in enumerate(alive):
            for idx2, eidx2 in enumerate(alive):
                if con[eidx1][eidx2]:
                    dinic.add(idx1, idx2, int(1e9))
        cut = dinic.cut(S, T)
        group = [[], []]
        for idx, e in enumerate(alive):
            if cut[idx]:
                group[1].append(e)
            else:
                group[0].append(e)
        if l <= mid and group[1]:
            q.append((l, mid, group[1]))
        if mid + 1 <= h and group[0]:
            q.append((mid + 1, h, group[0]))
    print(f"#{t + 1} {result}")


if __name__ == "__main__":
    Test = int(input())
    for t in range(Test):
        solve()
