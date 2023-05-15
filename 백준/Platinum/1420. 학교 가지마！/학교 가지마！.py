from collections import deque
from typing import List

INF = 912345678

class Edge:
    def __init__(self, dst: int, c: int, f: int, rev_idx: int):
        self.dst = dst
        self.c = c
        self.f = f
        self.rev_idx = rev_idx


class Flow:
    def __init__(self, N: int):
        self.n = N
        self.g = [[] for _ in range(N + 1)]
        self.pre = [-1] * (N + 1)
        self.path = [None] * (N + 1)

    def add_edge(self, s: int, e: int, c: int, bi_dir: bool = False):
        e1 = Edge(e, c, 0, -1)
        e2 = Edge(s, 0 if not bi_dir else c, 0, -1)
        e1.rev_idx = len(self.g[e])
        e2.rev_idx = len(self.g[s])
        self.g[s].append(e1)
        self.g[e].append(e2)

    def add_flow(self, e: Edge, f: int):
        e.f += f
        self.g[e.dst][e.rev_idx].f -= f

    def flow(self, st: int, ed: int) -> int:
        self.pre = [-1] * (self.n + 1)
        q = deque([st])

        while q and self.pre[ed] == -1:
            cur = q.popleft()
            for nx in self.g[cur]:
                nxt, c, f = nx.dst, nx.c, nx.f
                if c > f and self.pre[nxt] == -1:
                    self.pre[nxt] = cur
                    self.path[nxt] = nx
                    q.append(nxt)
                    if nxt == ed:
                        break

        if self.pre[ed] == -1:
            return 0

        flow = INF
        idx = ed
        while idx != st:
            flow = min(flow, self.path[idx].c - self.path[idx].f)
            idx = self.pre[idx]

        idx = ed
        while idx != st:
            self.add_flow(self.path[idx], flow)
            idx = self.pre[idx]

        return flow

    def max_flow(self, st: int, ed: int) -> int:
        res = 0
        while True:
            f = self.flow(st, ed)
            if f == 0:
                break
            res += f
        return res

def main():
    n, m = map(int, input().split())
    grid = [input().strip() for _ in range(n)]

    dx = [0, 1, -1, 0]
    dy = [1, 0, 0, -1]
    is_pos = True

    f = Flow(n * m * 2)
    st, ed = None, None

    for i in range(n):
        for j in range(m):
            if grid[i][j] == '#':
                continue

            num = i * m + j
            f.add_edge(num * 2, num * 2 + 1, 1)

            if grid[i][j] == 'K':
                st = num
            elif grid[i][j] == 'H':
                ed = num

    for i in range(n):
        for j in range(m):
            cx, cy = i, j
            if grid[cx][cy] == '#':
                continue

            c_num = cx * m + cy

            for k in range(4):
                nx, ny = cx + dx[k], cy + dy[k]
                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue

                if grid[nx][ny] == '#':
                    continue

                if grid[cx][cy] == 'K' and grid[nx][ny] == 'H':
                    is_pos = False

                n_num = nx * m + ny
                f.add_edge(c_num * 2 + 1, n_num * 2, INF)

    if is_pos:
        f.n = n * m * 2
        res = f.max_flow(st * 2 + 1, ed * 2)
    else:
        res = -1

    print(res)

if __name__ == '__main__':
    main()