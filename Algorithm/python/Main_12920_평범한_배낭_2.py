import sys

input = lambda: sys.stdin.readline().rstrip()

weight = []
sati = []
N, M = map(int, input().split())
dp = [0] * (M + 1)

for i in range(N):
    V, C, K = map(int, input().split())
    idx = 1

    while K > 0:
        tmp = min(idx, K)
        weight.append(V * tmp)
        sati.append(C * tmp)
        idx *= 2
        K -= tmp

for i in range(len(weight)):
    for j in range(M, 0, -1):
        if j >= weight[i]:
            dp[j] = max(dp[j], dp[j - weight[i]] + sati[i])
print(dp[M])
