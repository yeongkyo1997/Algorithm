import collections

if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        line = ''
        while line.strip() == '':
            line = input()
        n = int(line)
        board = []
        for _ in range(n):
            row = input().strip()
            board.append(row)
        cur_scores = [0] * n
        remaining_matches = [[] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if i == j:
                    continue
                c = board[i][j]
                if c == '1':
                    cur_scores[i] += 2
                elif c == 'd':
                    cur_scores[i] += 1
                elif c == '.':
                    remaining_matches[i].append(j)
        possible = []
        for P in range(n):
            P_current = cur_scores[P]
            P_remaining = len(remaining_matches[P])
            P_max = P_current + 2 * P_remaining
            Q_cur = cur_scores.copy()
            Q_remaining = [0] * n
            for Q in range(n):
                if Q == P:
                    continue
                cnt = 0
                for R in remaining_matches[Q]:
                    if R != P:
                        cnt += 1
                Q_remaining[Q] = cnt
            match_list = []
            for i in range(n):
                if i == P:
                    continue
                for j in range(i + 1, n):
                    if j == P:
                        continue
                    if board[i][j] == '.':
                        match_list.append((i, j))
            m = len(match_list)
            size = 2 + m + n
            graph = [[] for _ in range(size)]


            def add_edge(fr, to, cap):
                graph[fr].append([to, cap, len(graph[to])])
                graph[to].append([fr, 0, len(graph[fr]) - 1])


            for idx, (i, j) in enumerate(match_list):
                add_edge(0, 2 + idx, 2)
                add_edge(2 + idx, 2 + m + i, 2)
                add_edge(2 + idx, 2 + m + j, 2)
            feasible = True
            for Q in range(n):
                if Q == P:
                    continue
                cap = P_max - Q_cur[Q]
                if cap < 0:
                    feasible = False
                    break
                add_edge(2 + m + Q, 1, cap)
            if not feasible:
                continue
            total_cap = 2 * m
            level = [-1] * size
            ptr = [0] * size


            def bfs():
                q = collections.deque()
                q.append(0)
                level[:] = [-1] * size
                level[0] = 0
                while q:
                    v = q.popleft()
                    for to, cap, rev in graph[v]:
                        if cap > 0 and level[to] == -1:
                            level[to] = level[v] + 1
                            q.append(to)
                            if to == 1:
                                break
                return level[1] != -1


            def dfs(v, pushed):
                if v == 1:
                    return pushed
                while ptr[v] < len(graph[v]):
                    to, cap, rev = graph[v][ptr[v]]
                    if cap > 0 and level[to] == level[v] + 1:
                        tr = dfs(to, min(pushed, cap))
                        if tr > 0:
                            graph[v][ptr[v]][1] -= tr
                            graph[to][rev][1] += tr
                            return tr
                    ptr[v] += 1
                return 0


            flow = 0
            while bfs():
                ptr = [0] * size
                pushed = dfs(0, float('inf'))
                while pushed > 0:
                    flow += pushed
                    pushed = dfs(0, float('inf'))
            if flow == total_cap:
                possible.append(str(P + 1))
        print(' '.join(possible))