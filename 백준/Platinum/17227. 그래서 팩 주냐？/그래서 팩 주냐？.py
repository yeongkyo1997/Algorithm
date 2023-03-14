import collections
import sys

sys.setrecursionlimit(10 ** 6)
input = lambda: sys.stdin.readline().rstrip()

N, E = map(int, input().split())
g = [[] for _ in range(N + 1)]
st = []
dp = [[0, 0] for _ in range(N + 1)]
q = collections.deque()
visited = [False for _ in range(N + 1)]
remain_cnt = [0 for _ in range(N + 1)]
one_num = [[0, 0] for _ in range(N + 1)]
costs = [[[] for _ in range(2)] for _ in range(N + 1)]

for i in range(E):
    a, b = map(int, input().split())
    g[b].append(a)
    remain_cnt[a] += 1

for i in range(1, N + 1):
    if len(g[i]) == 0:
        st.append(i)

q.append(N)
dp[N][0] = 999999
dp[N][1] = 0

while q:
    cur = q.popleft()
    visited[cur] = True

    if cur != N:
        costs[cur][0].sort()
        costs[cur][1].sort()
        # dp[cur][0] = copy.deepcopy(costs[cur][0][-1])
        # dp[cur][1] = copy.deepcopy(costs[cur][1][-1])
        dp[cur][0] = costs[cur][0][-1]
        dp[cur][1] = costs[cur][1][-1]
        tmp = 0

        for i in range(len(costs[cur][1]) - 2, -1, -1):
            tmp += 1
            newCost = tmp + costs[cur][1][i]
            if dp[cur][1] > newCost:
                dp[cur][1] = newCost

    for nxt in g[cur]:
        if visited[nxt]:
            continue

        costs[nxt][0].append(dp[cur][1])
        costs[nxt][1].append(dp[cur][0])

        remain_cnt[nxt] -= 1

        if remain_cnt[nxt] == 0:
            q.append(nxt)

result = 987654321
for i in range(len(st)):
    if result > dp[st[i]][1]:
        result = dp[st[i]][1]

if result == 999999:
    result = -1
print(result)
