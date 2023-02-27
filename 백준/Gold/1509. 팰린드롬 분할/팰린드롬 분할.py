import sys

sys.setrecursionlimit(10000)
input = lambda: sys.stdin.readline().rstrip()

def main():
    string = input()
    N = len(string)
    graph = [[0] * N for _ in range(N)]
    for i in range(N):
        graph[i][i] = 1
    for i in range(N - 1):
        if string[i] == string[i + 1]:
            graph[i][i + 1] = 1
    for i in range(N - 2, -1, -1):
        for j in range(i + 2, N):
            if string[i] == string[j] and graph[i + 1][j - 1]:
                graph[i][j] = 1
    dp = [0] * N
    for i in range(N):
        if graph[0][i]:
            dp[i] = 1
        else:
            for j in range(i):
                if graph[j + 1][i]:
                    dp[i] = min(dp[i], dp[j] + 1) if dp[i] else dp[j] + 1
    print(dp[-1])

if __name__ == '__main__':
    main()