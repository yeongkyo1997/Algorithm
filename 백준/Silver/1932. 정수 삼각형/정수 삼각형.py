import sys

input = sys.stdin.readline

n = int(input())
DP = [[] * i for i in range(1, n + 1)]
tri = [list(map(int, input().split())) for i in range(n)]
DP[0].append(tri[0][0])

for i in range(1, len(tri)):
    for j in range(len(tri[i])):
        if j == 0:
            DP[i].append(DP[i - 1][0] + tri[i][j])
        elif j == len(tri[i]) - 1:
            DP[i].append(DP[i - 1][-1] + tri[i][j])
        else:
            DP[i].append(max(DP[i - 1][j - 1] + tri[i][j], DP[i - 1][j] + tri[i][j]))

print(max(DP[-1]))
